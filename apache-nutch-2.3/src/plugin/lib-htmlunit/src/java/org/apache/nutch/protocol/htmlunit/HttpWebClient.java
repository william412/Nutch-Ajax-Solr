package org.apache.nutch.protocol.htmlunit;

import java.net.URL;

import org.apache.hadoop.conf.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * Htmlunit WebClient Helper
 * Use one WebClient instance per thread by ThreadLocal to support multiple threads execution
 * 
 * @author EMAIL:s2jh-dev@hotmail.com , QQ:2414521719
 */
public class HttpWebClient {

    private static final Logger LOG = LoggerFactory.getLogger(HttpWebClient.class);

    private static ThreadLocal<WebClient> threadWebClient = new ThreadLocal<WebClient>();

    private static String acceptLanguage;

    public static Page getPage(String url, Configuration conf) {
        synchronized (Thread.currentThread()) {
            try {
                WebRequest req = new WebRequest(new URL(url));
                req.setAdditionalHeader("Accept-Language", acceptLanguage);
                //req.setAdditionalHeader("Cookie", "");

                WebClient webClient = threadWebClient.get();
                if (webClient == null) {
                    LOG.info("Initing web client for thread: {}", Thread.currentThread().getId());
                    webClient = new WebClient(BrowserVersion.FIREFOX_24);
                    webClient.getOptions().setCssEnabled(false);
                    webClient.getOptions().setAppletEnabled(false);
                    webClient.getOptions().setThrowExceptionOnScriptError(false);
                    // AJAX support
                    webClient.setAjaxController(new NicelyResynchronizingAjaxController());
                    // Use extension version htmlunit cache process
                    webClient.setCache(new ExtHtmlunitCache());
                    // Enhanced WebConnection based on urlfilter
                    webClient.setWebConnection(new RegexHttpWebConnection(webClient, conf));
                    webClient.waitForBackgroundJavaScript(600 * 1000);
                    //设置足够高度以支持一些需要页面内容多需屏幕滚动显示的页面
                    webClient.getCurrentWindow().setInnerHeight(6000);
                    if (acceptLanguage == null && conf != null) {
                        acceptLanguage = conf.get("http.accept.language", " zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
                    }
                    threadWebClient.set(webClient);
                }
                Page page = webClient.getPage(req);
                return page;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static HtmlPage getHtmlPage(String url, Configuration conf) {
        return (HtmlPage) getPage(url, conf);
    }

    public static void main(String[] args) {
        HtmlPage page = getHtmlPage("http://www.jumeiglobal.com/deal/ht150312p1286156t1.html", null);
        System.out.println(page.asXml());
    }
}

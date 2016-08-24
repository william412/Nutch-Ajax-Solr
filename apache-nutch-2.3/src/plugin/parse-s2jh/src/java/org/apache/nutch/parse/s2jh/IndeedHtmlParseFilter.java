package org.apache.nutch.parse.s2jh;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.nutch.parse.HTMLMetaTags;
import org.apache.nutch.parse.Parse;
import org.apache.nutch.storage.WebPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.DocumentFragment;

import com.google.common.collect.Lists;

/**
 * 
 * @author EMAIL:zhang1kr@gmail.com
 *
 */
public class IndeedHtmlParseFilter extends AbstractHtmlParseFilter {

    public static final Logger LOG = LoggerFactory.getLogger(IndeedHtmlParseFilter.class);

    @Override
    public Parse filterInternal(String url, WebPage page, Parse parse, HTMLMetaTags metaTags, DocumentFragment doc) throws Exception {
    	List<Position> positions = Lists.newArrayList();
    	CrawlData crawlData = new CrawlData(url, positions);
        
    	// www.indeed.ca
    	if (StringUtils.isNotBlank(url) && url.charAt(19) == 'a') {
    		//Record 1-3 & 24-25
        	for (int i = 1; i < 6; i++) {
        		if (StringUtils.isBlank(getAttributeValueByXpath(doc, "//*[@id='sja" + i + "']", "title"))) {
    				break;
    			}
        		
        		Position position = new Position();
        		position.setPositionName(getAttributeValueByXpath(doc, "//*[@id='sja" + i + "']", "title"));
        		position.setCompanyName(getXPathValue(doc, "//*[@id='sja" + i + "']/../DIV[@class='sjcl']/SPAN[@class='company']"));
        		position.setWorkPlace(getXPathValue(doc, "//*[@id='sja" + i + "']/../DIV[@class='sjcl']/SPAN[@class='location']"));
        		position.setPositionLink(getAttributeValueByXpath(doc, "//*[@id='sja" + i + "']", "href"));
        		position.setPostTime(getXPathValue(doc, "//*[@id='sja" + i + "']/../DIV[@class='result-link-bar-container']/DIV/SPAN[1]"));
        		
        		positions.add(position);
        	}
        	
        	//Record 4-23
        	for (int i = 5; i < 25; i++) {
        		if (StringUtils.isBlank(getAttributeValueByXpath(doc, "//TD[@id='resultsCol']/DIV[" + i + "]/H2/A", "title"))) {
        			break;
    			}
        		
        		Position position = new Position();
        		position.setPositionName(getAttributeValueByXpath(doc, "//TD[@id='resultsCol']/DIV[" + i + "]/H2/A", "title"));
        		position.setCompanyName(getXPathValue(doc, "//TD[@id='resultsCol']/DIV[" + i + "]/SPAN[@class='company']"));
        		position.setWorkPlace(getXPathValue(doc, "//TD[@id='resultsCol']/DIV[" + i + "]/SPAN[@itemprop='jobLocation']"));
        		position.setPositionLink(getAttributeValueByXpath(doc, "//TD[@id='resultsCol']/DIV[" + i + "]/H2/A", "href"));
        		position.setPostTime(getXPathValue(doc, "//TD[@id='resultsCol']/DIV[" + i + "]/TABLE//SPAN[@class='date']"));
        		
        		positions.add(position);
    		}
    	} 
    	
    	// www.indeed.com page > 1
    	else if (StringUtils.isNotBlank(url) && url.charAt(19) == 'o' && StringUtils.isNumeric(String.valueOf(url.charAt(url.length() - 1)))) {
    		
    		for (int i = 4; i < 14; i++) {
    			if (StringUtils.isBlank(getAttributeValueByXpath(doc, "//TD[@id='resultsCol']/DIV[" + i + "]/H2/A", "title"))) {
    				break;
    			}
    			
    			Position position = new Position();
    			position.setPositionName(getAttributeValueByXpath(doc, "//TD[@id='resultsCol']/DIV[" + i + "]/H2/A", "title"));
    			position.setCompanyName(getXPathValue(doc, "//TD[@id='resultsCol']/DIV[" + i + "]/SPAN[@class='company']"));
    			position.setWorkPlace(getXPathValue(doc, "//TD[@id='resultsCol']/DIV[" + i + "]/SPAN[@itemprop='jobLocation']"));
    			position.setPositionLink(getAttributeValueByXpath(doc, "//TD[@id='resultsCol']/DIV[" + i + "]/H2/A", "href"));
        		position.setPostTime(getXPathValue(doc, "//TD[@id='resultsCol']/DIV[" + i + "]/TABLE//SPAN[@class='date']"));
        		
    			positions.add(position);
    		}
    		
    		for (int i = 1; i < 6; i++) {
        		if (StringUtils.isBlank(getAttributeValueByXpath(doc, "//*[@id='sja" + i + "']", "title"))) {
        			break;
    			}
        		
        		Position position = new Position();
        		position.setPositionName(getAttributeValueByXpath(doc, "//*[@id='sja" + i + "']", "title"));
        		position.setCompanyName(getXPathValue(doc, "//*[@id='sja" + i + "']/../DIV[@class='sjcl']/SPAN[@class='company']"));
        		position.setWorkPlace(getXPathValue(doc, "//*[@id='sja" + i + "']/../DIV[@class='sjcl']/SPAN[@class='location']"));
        		position.setPositionLink(getAttributeValueByXpath(doc, "//*[@id='sja" + i + "']", "href"));
        		position.setPostTime(getXPathValue(doc, "//*[@id='sja" + i + "']/../DIV[@class='result-link-bar-container']/DIV/SPAN[1]"));
        		
        		positions.add(position);
        	}
		}
    	
    	// www.indeed.com page = 1
    	else if (StringUtils.isNotBlank(url) && url.charAt(19) == 'o') {
    		
    		for (int i = 4; i < 14; i++) {
    			if (StringUtils.isBlank(getAttributeValueByXpath(doc, "//TD[@id='resultsCol']/DIV[" + i + "]/H2/A", "title"))) {
    				break;
    			}
    			
    			Position position = new Position();
    			position.setPositionName(getAttributeValueByXpath(doc, "//TD[@id='resultsCol']/DIV[" + i + "]/H2/A", "title"));
    			position.setCompanyName(getXPathValue(doc, "//TD[@id='resultsCol']/DIV[" + i + "]/SPAN[@class='company']"));
    			position.setWorkPlace(getXPathValue(doc, "//TD[@id='resultsCol']/DIV[" + i + "]/SPAN[@itemprop='jobLocation']"));
    			position.setPositionLink(getAttributeValueByXpath(doc, "//TD[@id='resultsCol']/DIV[" + i + "]/H2/A", "href"));
        		position.setPostTime(getXPathValue(doc, "//TD[@id='resultsCol']/DIV[" + i + "]/TABLE//SPAN[@class='date']"));
    			
    			positions.add(position);
    		}
    		
    		for (int i = 1; i < 4; i++) {
        		if (StringUtils.isBlank(getAttributeValueByXpath(doc, "//*[@id='sja" + i + "']", "title"))) {
    				break;
    			}
        		
        		Position position = new Position();
        		position.setPositionName(getAttributeValueByXpath(doc, "//*[@id='sja" + i + "']", "title"));
        		position.setCompanyName(getXPathValue(doc, "//*[@id='sja" + i + "']/../DIV[@class='sjcl']/SPAN[@class='company']"));
        		position.setWorkPlace(getXPathValue(doc, "//*[@id='sja" + i + "']/../DIV[@class='sjcl']/SPAN[@class='location']"));
        		position.setPositionLink(getAttributeValueByXpath(doc, "//*[@id='sja" + i + "']", "href"));
        		position.setPostTime(getXPathValue(doc, "//*[@id='sja" + i + "']/../DIV[@class='result-link-bar-container']/DIV/SPAN[1]"));
        		
        		positions.add(position);
        	}
		}
    	
        savePositionCrawlData(url, crawlData, page);

        return parse;
    }

    @Override
    public String getUrlFilterRegex() {
        //return "^http://www.indeed.ca/jobs\\?q=.*(&start=\\d+)*$";
        return "^http://www.indeed.c(a|om)/jobs\\?q=(hadoop|java|python|c%23|php|ruby|c|c%2B%2B|objective\\+c|swift|javascript|visual\\+basic|r|perl|sql)&sort=date(&start=\\d+)*$";
    }

    @Override
    protected boolean isParseDataFetchLoadedInternal(String url, String html) {
        return true;
    }

    @Override
    protected boolean isContentMatchedForParse(String url, String html) {
        return true;
    }
}

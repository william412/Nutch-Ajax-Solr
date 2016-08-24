Nutch AJAX page Fetch, Parse, Index Plugin
==============

### ��Ŀ���

����Apache Nutch 2.3��Htmlunit, Selenium WebDriver�������չ��ʵ�ֶ���AJAX��������ҳ�������ҳ������ץȡ���Լ��ض�������Ľ�����������

According to the implementation of Apache Nutch 2.X, we can't get dynamic HTML information from fetch pages including AJAX requests as it will ignore all AJAX requests.

This plugin will use Htmlunit and Selenium WebDriver to fetch whole page content with necessary dynamic AJAX requests. 

It developed and tested with Apache Nutch 2.3, you can try it on other Nutch 2.X version or refactor the source codes as your design.

### ��Ҫ����

* **�����HTMLҳ��ץȡ**: ���ڳ��������������û��AJAX���Ե�ҳ�����ֱ����Nutch�Դ���protocol-http���ץȡ��

* **�����AJAXҳ��ץȡ**: ���ھ��󲿷�����jQuery ajax���ص�ҳ�棬����ֱ����htmlunit��չ���ץȡ��

* **�����AJAX����ҳ��ץȡ**: �����Ա�/��è��ҳ������˶��ص�Kissy Javascript�����Ŀǰ����htmlunit�޷���ȷ����������˶�����β���Ч�ʵ�һЩ��Selenium WebDriver��ʽʵ��ҳ������ץȡ��

* **����ҳ�������AJAX����ҳ��ץȡ**: �����Ա�/��è����Ʒ����ҳ������ҳ�����������Ʒ������Ϣ�ļ��أ�ͨ��Htmlunit��Selenium WebDriver��չ�������ʵ�ִ���ҳ������ץȡ��

### ���з�ʽ

������Ŀ���ڹٷ���Apache Nutch 2.3Դ�����֮����Ӳ����������ã����з�ʽ�͹ٷ�ָ�ϱ���һ�£�������ο���http://wiki.apache.org/nutch/

ͬʱ���̴������ύ��Eclipse�Ĺ��������ļ�������ֱ��import Eclipse��Run��Debug���У�Nutch������Ivy�������������ɲ���ANT Build��ʽ������Eclipse IDE��װApache Ivy IDE������й��̱������С�

![snapshot](http://git.oschina.net/xautlx/nutch-ajax/raw/master/snapshot/eclipse-run.jpg)

![snapshot](http://git.oschina.net/xautlx/nutch-ajax/raw/master/snapshot/storage-data.jpg)

![snapshot](http://git.oschina.net/xautlx/nutch-ajax/raw/master/snapshot/parse-data.jpg)

### ��չ���˵��

* **lib-pinyin**: ����parse��index���ת�����ĵ�ƴ���ύsolr����������solr dataimporthandler�������ƴ��ת����transformer��չ���

* **lib-htmlunit**: ����Htmlunit�Ķ��̴߳���������ƣ�����������Ƶ�������չ���

* **protocol-s2jh**: ����Htmlunit��Selenium WebDriverʵ�ֵ�AJAXҳ��Fetcher���

* **parse-s2jh**: ����XPath����ҳ��Ԫ������; �־û��������Ľṹ�����ݣ���MySQL��MongoDB��; ���ڸ���������AJAXҳ�涨���ж�ҳ�������ɵĻص��ж��߼�

* **index-s2jh**: ׷��������Ҫ���⴫�ݸ�SOLR��������������; �趨����Ҫ������ҳ�����;

### ��ϸ�ο��ĵ�

��Ŀ�ṩһ�ݱȽ���ϸ�ġ�����Nutch&Solr����ɼ��������������������ϼ���ָ���ĵ�������ͨ���������ַ�ʽ�鿴�ο��ĵ����ݣ�

* ֱ�ӻ�ȡ��Ŀ���ݺ���documentĿ¼�¸����Լ���Ϥ�ı༭���鿴��Ӧ��md��html��ʽ�ĵ���
* GitHubֱ�ӽ���md�ļ�����������ȷ����ͼƬ���ӣ���˿�ֱ�����߷��� https://github.com/xautlx/nutch-ajax/blob/master/document/Apache_Nutch_Solr_Solution_with_AJAX_support.md 

### ���˵��

* Free Open Source

����Ŀ���д���������Դ���ڱ�����ʶ����Ŀ��Դ��Ϣ�Լ���֤���Ա���Ŀ���з���Ȩ��������Ϊ��ǰ���£����������ⷽʽ�������ʹ�ã���Դ���ǿ�Դ����ҵ������ҵ��

* Charge Support Service

����㻹����Ȥ��Apache Nutch/Solr/Lucene��ϵ�м����Ķ��Ƶ���չʵ��/������ѯ����/��ҵ���ָ��/���ο�����Ŀָ���ȷ���ĺ������򣬿���ϵ E-Mail: s2jh-dev@hotmail.com �� QQ: 2414521719 (��Q��ע����nutch/solr/lucene) Ǣ̸��[������ϵ��ʽˡ��ֱ���ṩ��ѯ��ѯ�ʣ�Ϊ��������Ŀ��Ծ�ȣ�������Ŀ���κμ��������Issue��������ֱ���ύ����Ŀվ�����ʻ�Gitƽ̨��Issue]

### Reference

��ӭ��ע����������Ŀ��

* [Nutch 2.X AJAX Plugins (Active)](https://github.com/xautlx/nutch-ajax) -  ����Apache Nutch 2.3��Htmlunit, Selenium WebDriver�������չ��ʵ�ֶ���AJAX��������ҳ�������ҳ������ץȡ���Լ��ض�������Ľ���������

* [S2JH4Net (Active)](https://github.com/xautlx/s2jh4net) -  ����Spring MVC+Spring+JPA+Hibernate��������������ҵWebӦ�ÿ������

* [S2JH (Deprecated)](https://github.com/xautlx/s2jh) -  ����Struts2+Spring+JPA+Hibernate��������ҵWebӦ�ÿ������
 
* [Nutch 1.X AJAX Plugins (Deprecated)](https://github.com/xautlx/nutch-htmlunit) -  ����Apache Nutch 1.X��Htmlunit����չʵ��AJAXҳ������ץȡ�������
 
* [12306 Hunter (Deprecated)](https://github.com/xautlx/12306-hunter) - ��������ʧЧ�����ã����������Ե���Swing�������вο�ֻ�ã�Java Swing C/S�汾12306��Ʊ���֣��ô��㶮��
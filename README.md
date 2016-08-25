## Overview

This project implements that fetching/parsing/indexing data from dynamic website and storing data to mongodb based on Apache Nutch 2.3 and Solr 4.10.3.  

## Configure nutch 2.3
* build whole project based on the project of nutch-ajax
* edit mongodb parameters and persist mode

  `gora.properties nutch-site.xml`
* add parse class by extending AbstractHtmlParseFilter
* add urls in seed.txt
* add regular expressions in regex-urlfilter.txt
* edit topN by modifying the value of sizeFetchlist in bin/crawl if choosing to run in command
* Run in command

  `runtime/local/bin/crawl urls indeed 100`

## Configure Solr 4.10.3
* add libs to solr/example/solr-webapp/../WEB-INF/lib

  `mmseg4j-analysis-1.9.1.jar`
  `mmseg4j-core-1.10.0.jar`
  `mmseg4j-solr-2.2.0.jar`

* modify index file
  `solr/example/solr/collection1/conf/schema.xml`

  `change id to _id` 

  `change primary_key`

  `<field name="_ts" type="long" indexed="true" stored="true" />       
   <field name="ns" type="string" indexed="true" stored="true"/>`

  `<fieldType name="text_mmseg4j_complex" class="solr.TextField" positionIncrementGap="100" >  
      <analyzer>  
        <tokenizer class="com.chenlb.mmseg4j.solr.MMSegTokenizerFactory" mode="complex" dicPath="dic"/>  
      </analyzer>  
   </fieldType>`

   `<dynamicField name="positionInfo*" type="text_mmseg4j_complex" indexed="true" stored="true"/>`

* add fuzzy match in schema.xml

  `<analyzer type="index"> ...
   <filter class="solr.NGramFilterFactory" minGramSize="2" maxGramSize="15"/>
   </analyzer>`

* unblock request in solrconfig.xml

  `<requestHandler name="/admin/luke" class="solr.admin.LukeRequestHandler"/>`

* run solr

  `$ cd solr/example/`

  `$ java -jar start.jar`

  `http://localhost:8983/solr/`
* delete index

  `http://localhost:8983/solr/collection1/update?stream.body=<delete><query>*:*</query></delete>&commit=true`


## Mongo-Connector
* install mongo-connector
* run
 
  `mongo-connector -m loclhost:27017 -t http://localhost:8983/solr -d solr_doc_manager -n nutch.crawl_data --auto-commit-interval=0`


## MongoDB 2.4.9
* run in standalone mode(Not be applied to this project)
  
  `$ sudo service mongodb start/stop/status`

* run in replica mode
  
  `mongod --replSet myDevReplSet`


  `$ mongo` 

  `rs.initiate()`

* shell

  `$ mongo`

* Configure remote call

  `/etc/mongod.conf`

  
## Reference

`https://github.com/xautlx/nutch-ajax`

`https://github.com/mongodb-labs/mongo-connector`

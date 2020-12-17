# website-log-analysis
Big data course project using HDFS and MapReduce. 
## Introduction
The problem we are addressing is about how to efficiently count the useful information among the huge amount of data. We mainly choose to analysis the following problems: \
(1)	How do the users distribute according to the region? \
(2)	How is the page view distributed in a different period in one day? \
(3)	What is the page view for different topic id? \
(4)	Count the page view based on different usernames. 
## Data
Link for the data: https://drive.google.com/file/d/1kASvDwX02uDQzDmepp5qcYcs68KxFJJG/view?usp=sharing, the data file should be put in the website-log-analysis/bigdataproject/hadoop-train-v2/input/raw \
One record in the log file contains many attributes separated by space. we extract the attributes we need then count how many times the certain attribute appears in the log file by using Java write the MapReduce program. The problem is to analyze the structure of the log file, decide what should be the input and output key-value pair for the map, and reduce the stage. In this case, the input value should be one record of the log and the output key is the attribute we extracted from the log record (regions, hours, topic id, username, etc.) and the output value of the mapper should be LongWritable value (Writable encapsulation of long type in Hadoop package) one. The output key-value pairs are considered as the input key-value pairs for reducer class. The reduce method sum all the values with the same key as the output value for the reducer. And the output key should be the same as the input key of the reducer.\
Here is one representative example in the log file:
![Picture1.png](https://i.loli.net/2020/12/17/zCBDaejicM96Lro.png)
We can see from the screenshot; one single record contains a lot of information. We analysis the record and find out the information in the record stands for the following attributes in the sequence are ID, URL, referrer, keyword, type, guId, pageId, module, linked, attachedInfo, sessionId, trackerU, trackerType, IP, trackerSrc, cookie, orderCode, trackTime, endUserId, firstLink, sessionViewNo, productid, curMerchantId, provinceId, cityId, fee, edmActivity, edmEmail, edmJobId, ieVersion, platform, internalKeyword, resultSum, currentPage, linkPosition, buttonPosition.
## Approach Description
### Java program
The Java program of the project contains the util classes and the main class for each type of analysis. The util classes play the role of processing the raw data. The main functions of the util classes are extracting the useful information we need and analyzing the IP address to find out the users' regional information. The classes are written to address each of the problems. For each class, we defined our myMpper and myReducer classes which respectively extend the Mapper and Reducer form Hadoop package. In our self-defined class, we override the method map and reduce the method in the super classes. In each method, we set the inputKey, inputValue, outputKey and outputValue. Then we write the main method which plays the role of starting the MapReduce job. To be specific, in the main method, the configuration, the path of the input, and output data are set. After being tested successfully in the local environment, we can package the whole program and run it in the HDFS. We also read the reference paper to find a way to optimize the program. In our original method, all the processing is based on the raw data, which is full of irrelevant data. Under such circumstances, there will be an unnecessary cost, which will increase when the file scale is bigger, to read the content of the log. We implement the ETL stands for Extract-Transform-Load which is the process of cleaning data from the source to the destination. The term ETL is more commonly used but not limited to data warehouses. We consider it should be a good choice to reduce the cost when the MapReduce program is running. So, instead of doing computation on the raw data, we implement some preprocessing on the data to generate the ETL result and doing MapReduce operation on the generated file.
### Result Storage
The program reads the file from HDFS and after finishing the computation operation, the program generates the result files and upload to the HDFS. We copy the result files from HDFS to local put the result in MySQL database.
### Data Visualization
We use python to read the data in the database and use MATLAB API to do the data visualization according to the result we have. \
The histogram of the hour statistic: \
![Picture1.png](https://i.loli.net/2020/12/17/F8VQxRdzOyTwjnJ.png) \
The horizontal axis stands for the 24 hours in one day and the vertical axis stands for the page view for that certain hour. \
The histogram of the page statistic: \
![Picture1.png](https://i.loli.net/2020/12/17/GDcWqBnfhoXmtQP.png) \
The horizontal axis stands for the topic id in the URL and the vertical axis stands for the page view for that certain page. \
The histogram of the page statistic: \
![Picture1.png](https://i.loli.net/2020/12/17/D84braGlFN5WdBI.png) \
The horizontal axis stands for the regions in China and the vertical axis stands for the page view for that certain region.
## Result
The size of the original file is 165 megabytes and after the data after being cleaned is 45 megabytes. Obviously, ETL can improve efficiency when processing the big data file. \
![Picture1.png](https://i.loli.net/2020/12/17/Jx1z2Mo9BPp3SNy.png) \
Figure1: the process of analysis

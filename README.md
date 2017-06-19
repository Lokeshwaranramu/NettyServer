# NettyServer
NettyHTTPServer
Problem: To create a java netty http server that accepts the json object and save to kafka queue.

Procedure: I have installed the netty server in the debian development machine. The kafka is made to run using the tar files provided by apache.

Running Kafta includes following commands in debian: 
*Download the 0.10.2.0 release and un-tar it. 
*> tar -xzf kafka_2.11-0.10.2.0.tgz 
*> cd kafka_2.11-0.10.2.0 *> bin/zookeeper-server-start.sh config/zookeeper.properties 
*> bin/kafka-server-start.sh config/server.properties

Program given in this repository is used to get the data as given and time from the system as nanoseconds. The first three byte of data are taken from the Netty http server and saved into the kafka queue for respective time to data.Use this POM file to give netty server dependecies and to run the project.



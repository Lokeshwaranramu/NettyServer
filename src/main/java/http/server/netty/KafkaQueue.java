package http.server.netty;

import java.util.Properties;

public class KafkaQueue {
 public static void main(String[] args) throws Exception{
    if(args.length == 0){
       System.out.println("Enter topic name");
       return;
    }
    String topicName = args[0].toString();
    Properties props = new Properties();
    props.put("bootstrap.servers","localhost:8080");
    props.put("acks", 0);
    props.put("properties", 0);
    props.put("batch.size", 16384);
    props.put("linger.ms", 1);
    props.put("buffer.memory", 33554432);
    props.put("key.serializer","org.apache.kafka.common.serializa-tion.StringSerializer");
    props.put("value.serializer","org.apache.kafka.common.serializa-tion.StringSerializer");
    System.out.println("Message sent successfully");    
 }
}

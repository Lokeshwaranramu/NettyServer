package http.server.netty;

import java.util.Arrays;
import java.util.Properties;
 
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
 
public class KafkaConsumer implements Runnable 
{
 
  private final KafkaConsumer consumer;
  private final String topic;
 
  public KafkaConsumer(String brokers, String groupId, String topic) 
  {
    Properties prop = createConsumerConfig(brokers, groupId);
    this.consumer = new KafkaConsumer(brokers,groupId,topic);
    this.topic = topic;
  }
 
  private static Properties createConsumerConfig(String brokers, String groupId) 
  {
    Properties props = new Properties();
    props.put("bootstrap.servers", brokers);
    props.put("group.id", groupId);
    props.put("enable.auto.commit", "true");
    props.put("auto.commit.interval.ms", "1000");
    props.put("session.timeout.ms", "30000");
    props.put("auto.offset.reset", "earliest");
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    return props;
  }
  public void run() 
  {
    while (true) 
    {
      ConsumerRecordsrecords = consumer.poll(100);
    }
  }
}

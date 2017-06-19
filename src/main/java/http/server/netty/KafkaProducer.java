package http.server.netty;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
 
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
 
public class KafkaProducer implements Runnable 
{
 
  private final KafkaProducer producer;
  private final String topic;
 
  public KafkaProducer(String brokers, String topic) 
  {
    Properties prop = createProducerConfig(brokers);
    this.producer = new KafkaProducer(brokers, topic);
    this.topic = topic;
  }
 
  private static Properties createProducerConfig(String brokers) {
    Properties props = new Properties();
    props.put("bootstrap.servers", brokers);
    props.put("acks", "all");
    props.put("retries", 0);
    props.put("batch.size", 16384);
    props.put("linger.ms", 1);
    props.put("buffer.memory", 33554432);
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    return props;
  }
  public void run() 
  {
      producer.send(new ProducerRecord(topic),new Callback() 
      {
            public void onCompletion(RecordMetadata metadata, Exception e) 
            {
              if (e != null) 
              {
                e.printStackTrace();
              }
            }
      });
  }
  producer.close();
}
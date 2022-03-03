package com.example.kafka;

import java.util.Properties;
import java.util.Scanner;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaProducerApp{
    public static void main( String[] args ){
    	// java console dan girilen verileri almak icin
    	Scanner read = new Scanner(System.in);
    	    	
    	Properties config = new Properties();
    	config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    	config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, new StringSerializer().getClass().getName());
    	config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, new StringSerializer().getClass().getName());
    	
    	Producer<String, String> producer = new KafkaProducer<String, String>(config);
    	
    	while(true) {
    		System.out.println("Kafkaya gönderilecek data : ");
    		String key = read.nextLine();  // klavyeden gelen deger okunur
    		ProducerRecord<String, String> rec = new ProducerRecord<String, String>("search", key);
            producer.send(rec);
    	}
    	
    }
}

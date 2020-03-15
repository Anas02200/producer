package com.test.pca.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.pca.entities.BankClientEntity;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;


public class JsonPOJOSerializer implements Serializer<BankClientEntity> {
	private final ObjectMapper objectMapper = new ObjectMapper();
	public JsonPOJOSerializer() {
    }
	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	
	}
	@Override
	public byte[] serialize(String topic, BankClientEntity data) {
		if (data == null)
            return null;

        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new SerializationException("Error serializing JSON message", e);
        }
	}
	@Override
	public void close() {
		// TODO Auto-generated method stub
		Serializer.super.close();
	}
	
	
	
	
	

}

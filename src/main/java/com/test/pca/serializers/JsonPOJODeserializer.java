package com.test.pca.serializers;

import java.util.Map;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.pca.entities.UserEntity;


public class JsonPOJODeserializer implements Deserializer<UserEntity> {

	private ObjectMapper objectMapper = new ObjectMapper();
	private Class<UserEntity> tClass;

	public JsonPOJODeserializer() {
	}

	@Override
	public void configure(Map<String, ?> props, boolean isKey) {
		
	}

	@Override
	public UserEntity deserialize(String topic, byte[] bytes) {
		// TODO Auto-generated method stub
		if (bytes == null)
            return null;

        UserEntity data;
        try {
            data = objectMapper.readValue(bytes, tClass);
        } catch (Exception e) {
            throw new SerializationException(e);
        }

        return data;
	}

	@Override
	public void close() {
		
	}

	

}

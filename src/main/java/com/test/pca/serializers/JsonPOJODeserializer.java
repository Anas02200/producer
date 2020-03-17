package com.test.pca.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.pca.dataTransferObject.BankingInfosDto;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;


public class JsonPOJODeserializer implements Deserializer<BankingInfosDto> {

	private ObjectMapper objectMapper = new ObjectMapper();
	private Class<BankingInfosDto> tClass;

	public JsonPOJODeserializer() {
	}

	@Override
	public void configure(Map<String, ?> props, boolean isKey) {
		
	}

	@Override
	public BankingInfosDto deserialize(String topic, byte[] bytes) {
		// TODO Auto-generated method stub
		if (bytes == null)
            return null;

        BankingInfosDto data;
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

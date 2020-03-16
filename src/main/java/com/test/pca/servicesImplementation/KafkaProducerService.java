package com.test.pca.servicesImplementation;

import com.test.pca.dataTransferObject.BankingInfosDto;
import com.test.pca.services.ProducerChannel;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;


@EnableBinding(ProducerChannel.class)
public class KafkaProducerService {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);
    private final MessageChannel consumer;

    public KafkaProducerService(@NotNull ProducerChannel channel) {
        this.consumer = channel.out();
    }


    //@Scheduled(fixedRate = 10000)
    public void send(BankingInfosDto bankingInfosDto) {

        //BankClientEntity user = new BankClientEntity();
        Message<BankingInfosDto> message = MessageBuilder.withPayload(bankingInfosDto).build();
        this.consumer.send(message);
        logger.info(String.format("PRODUCING MESSAGE ==> %s", message));

    }
}

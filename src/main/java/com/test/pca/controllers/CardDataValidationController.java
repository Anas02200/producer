package com.test.pca.controllers;


import com.test.pca.dataTransferObject.BankingInfosDto;
import com.test.pca.repositories.BankClientRepository;
import com.test.pca.services.CardDataValidation;
import com.test.pca.servicesImplementation.KafkaProducerService;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log
@RestController
@RequestMapping(value = "api")
public class CardDataValidationController {
    private final CardDataValidation cardDataValidation;
    private final KafkaProducerService kafkaProducerService;

    public CardDataValidationController(CardDataValidation cardDataValidation,
                                        KafkaProducerService kafkaProducerService,
                                        BankClientRepository bankClientRepository) {
        this.cardDataValidation = cardDataValidation;
        this.kafkaProducerService = kafkaProducerService;
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity validateCardInfos(@RequestParam("bankClientEntity_fullName") String bankClientEntity_fullName,
                                            @RequestParam("cardNumber") String cardNumber,
                                            @RequestParam("cardCCV") int cardCCV) {
        if (cardDataValidation.validateCardInfos(cardNumber, cardCCV, bankClientEntity_fullName)) {
            log.info("validated card");
            BankingInfosDto bankingInfosDto = cardDataValidation
                    .getBankClientFromCardInfos(cardNumber, cardCCV, bankClientEntity_fullName);
            kafkaProducerService.send(bankingInfosDto);
            log.info("processing payment info");
            return ResponseEntity.status(200).body(bankingInfosDto);
        }
        return ResponseEntity.status(404).body("Card data not found ");

    }


}

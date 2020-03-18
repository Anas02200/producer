package com.test.pca.controllers;


import com.test.pca.dataTransferObject.BankingInfosDto;
import com.test.pca.dataTransferObject.TransactionData;
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

    public CardDataValidationController(CardDataValidation cardDataValidation, KafkaProducerService kafkaProducerService) {
        this.cardDataValidation = cardDataValidation;
        this.kafkaProducerService = kafkaProducerService;
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity validateCardInfos(@RequestParam("bankClientEntity_fullName") String bankClientEntity_fullName,
                                            @RequestParam("cardNumber") String cardNumber, @RequestParam("cardCCV") int cardCCV) {
        if (cardDataValidation.validateCardInfos(cardNumber, cardCCV, bankClientEntity_fullName)) {
            log.info("validated card");
            BankingInfosDto bankingInfosDto = cardDataValidation.getBankClientFromCardInfos(cardNumber, cardCCV, bankClientEntity_fullName);
            kafkaProducerService.send(bankingInfosDto);
            log.info("processing payment info");
            return ResponseEntity.status(200).body(bankingInfosDto);
        }
        return ResponseEntity.status(404).body("Card data not found ");

    }

    @RequestMapping(value = "/validate2", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity validateCardInfos2(@RequestParam("bankClientEntity_fullName") String bankClientEntity_fullName,
                                             @RequestParam("cardNumber") String cardNumber, @RequestParam("cardCCV") int cardCCV,
                                             @RequestBody(required = false) TransactionData transactionData) {
        ResponseEntity result;
        if (cardDataValidation.validateCardInfos(cardNumber, cardCCV, bankClientEntity_fullName)) {
            log.info("validated card");
            BankingInfosDto bankingInfosDto = cardDataValidation.getBankClientFromCardInfos(cardNumber, cardCCV, bankClientEntity_fullName);
            bankingInfosDto.setTransactionData(transactionData);
            kafkaProducerService.send(bankingInfosDto);
            log.info("processing payment info");
            result = ResponseEntity.status(200).body(bankingInfosDto);
        } else {
            result = ResponseEntity.status(404).body("Card data not found ");
        }

        return result;
    }


}

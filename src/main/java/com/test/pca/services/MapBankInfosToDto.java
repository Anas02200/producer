package com.test.pca.services;

import com.test.pca.dataTransferObject.BankingInfosDto;
import com.test.pca.entities.BankClientEntity;

public interface MapBankInfosToDto {

    BankingInfosDto BankClientToDto(Class<BankingInfosDto> DtoClass,BankClientEntity bankClientEntity);
}

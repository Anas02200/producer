package com.test.pca.servicesImplementation;

import com.test.pca.dataTransferObject.BankingInfosDto;
import com.test.pca.entities.BankAccountEntity;
import com.test.pca.entities.BankCardEntity;
import com.test.pca.entities.BankClientEntity;
import com.test.pca.services.MapBankInfosToDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapBankInfosToDtoImp implements MapBankInfosToDto {
    private final ModelMapper modelMapper;

    public MapBankInfosToDtoImp(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BankingInfosDto BankClientToDto(Class<BankingInfosDto> DtoClass, BankClientEntity bankClientEntity) {

        BankingInfosDto bankingInfosDto = modelMapper.map(bankClientEntity, DtoClass);
        List<BankAccountEntity> bankAccountEntities = bankClientEntity.getBankAccounts();
        List<BankCardEntity> bankCardEntities = new ArrayList<>();

        bankAccountEntities.stream().map(BankAccountEntity::getBankCardEntities).forEach(bankCardEntities::addAll);

        bankingInfosDto.setBankCardEntities(bankCardEntities);
        return bankingInfosDto;
    }
}

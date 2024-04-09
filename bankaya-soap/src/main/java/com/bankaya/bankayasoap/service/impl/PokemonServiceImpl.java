package com.bankaya.bankayasoap.service.impl;

import com.bankaya.bankayasoap.service.PokemonService;
import com.bankaya.core.aop.WebLogAnnotation;
import com.bankaya.core.api.client.PokemonServiceClient;
import com.bankaya.core.dto.PokemonResponseDTO;
import com.bankaya.core.enums.WebMethodEnum;
import com.bankaya.core.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PokemonServiceImpl implements PokemonService {

    final PokemonServiceClient pokemonServiceClient;
    final LogRepository logRepository;

    @Override
    @WebLogAnnotation(originIp ="[0]",webMethod = WebMethodEnum.abilities)
    public PokemonResponseDTO getPokemonInformation(String name,String ip) {
            return pokemonServiceClient.getPokemon(name);
    }


}

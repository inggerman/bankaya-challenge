package com.bankaya.bankayasoap.service;

import com.bankaya.core.dto.PokemonResponseDTO;

public interface PokemonService {

    PokemonResponseDTO getPokemonInformation(String name, String originIp);

}

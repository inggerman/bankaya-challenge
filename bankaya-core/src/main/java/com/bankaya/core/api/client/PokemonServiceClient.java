package com.bankaya.core.api.client;

import com.bankaya.core.api.repository.PokemonServiceRepository;
import com.bankaya.core.dto.PokemonResponseDTO;
import com.bankaya.core.errors.ErrorCode;
import com.bankaya.core.exeptions.InternalServerErrorException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import retrofit2.Call;
import retrofit2.Response;

@Slf4j
public class PokemonServiceClient {


    private final PokemonServiceRepository pokemonServiceRepository;


    @Autowired
    public PokemonServiceClient(PokemonServiceRepository pokemonServiceRepository) {
        this.pokemonServiceRepository = pokemonServiceRepository;
    }

    public PokemonResponseDTO getPokemon(String pokemonName) {
        return executeCall(pokemonServiceRepository.getPokemonInfo(pokemonName));
    }


    protected <T> T executeCall(Call<T> call) {
        return doExecuteCall(call);
    }

    private <T> T doExecuteCall(Call<T> call) {
        final Response<T> response;
        try {
            response = call.execute();
        } catch (Throwable e) {
            log.error("Error with service API{}", e.getMessage());
            throw new InternalServerErrorException(ErrorCode.API_UNAVAILABLE);
        }
        return response.body();
    }

}

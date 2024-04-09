package com.bankaya.core.api.repository;

import com.bankaya.core.constants.PokemonURIConstants;
import com.bankaya.core.dto.PokemonResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PokemonServiceRepository {

    @GET(PokemonURIConstants.POKEMON_NAME)
    Call<PokemonResponseDTO> getPokemonInfo(@Path("name")  String name);

}

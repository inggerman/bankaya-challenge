package com.bankaya.bankayasoap.config;

import com.bankaya.core.api.client.AbstractBaseRetrofitConfig;
import com.bankaya.core.api.client.PokemonServiceClient;
import com.bankaya.core.api.repository.PokemonServiceRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

@Configuration
public class RetrofitConfig extends AbstractBaseRetrofitConfig {

    @Value("${api.bankaya.pokemon.timeout}")
    private Long pokemonTimeout;


    @Bean
    public PokemonServiceClient getAccessServiceClient(@Value("${api.bankaya-services.pokemon-service}") String pokemonServiceBaseUrl) throws NoSuchAlgorithmException, KeyManagementException {
        return new PokemonServiceClient(retrofitRepositoryBuilder.build(pokemonServiceBaseUrl, PokemonServiceRepository.class, pokemonTimeout)) ;
    }

}

package com.bankaya.bankayasoap.service.impl

import com.bankaya.bankayasoap.constants.TestConstans
import com.bankaya.bankayasoap.service.PokemonService
import com.bankaya.bankayasoap.testUtils.TestBuilder
import com.bankaya.core.api.client.PokemonServiceClient
import com.bankaya.core.repository.LogRepository
import spock.lang.Specification
import spock.lang.Subject

class PokemonServiceImplSpock extends Specification {

    PokemonServiceClient pokemonServiceClient = Mock(PokemonServiceClient)
    LogRepository logRepository = Mock(LogRepository)

    @Subject
    PokemonService pokemonService = new PokemonServiceImpl(pokemonServiceClient, logRepository)

    def "GetPokemonInformation"() {

        given:
        def abilitiesSize = 10;

        when:
        def res = pokemonService.getPokemonInformation(TestConstans.DEFAULT_POKEMON_NAME, "1.1.1.1")

        then:
        1 * pokemonServiceClient.getPokemon(TestConstans.DEFAULT_POKEMON_NAME) >> TestBuilder.buildPokemonResponseDTO(abilitiesSize)

        res.abilities.size() == abilitiesSize
        res.abilities.get(0).ability.name == TestConstans.DEFAULT_ABILITY_NAME
        res.baseExperience == TestConstans.DEFAULT_BASED_EXPERIENCE
        res.name == TestConstans.DEFAULT_POKEMON_NAME
        res.heldItemDTOS == null
        res.heldItemDTOS <= 0
    }


    def "GetPokemonInformation when exception was ocurred"() {

        when:
        def res = pokemonService.getPokemonInformation(TestConstans.DEFAULT_POKEMON_NAME, "1.1.1.1")

        then:
        1 * pokemonServiceClient.getPokemon(TestConstans.DEFAULT_POKEMON_NAME) >> { throw new NullPointerException("Error null") }

        def ex = thrown(NullPointerException)

        ex.message == "Error null"
    }

}

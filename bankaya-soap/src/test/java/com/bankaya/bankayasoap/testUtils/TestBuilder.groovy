package com.bankaya.bankayasoap.testUtils

import com.bankaya.bankayasoap.constants.TestConstans
import com.bankaya.bankayasoap.jaxb.AbilitiesRequest
import com.bankaya.core.dto.AbilityBaseDTO
import com.bankaya.core.dto.AbilityDTO
import com.bankaya.core.dto.PokemonResponseDTO

class TestBuilder {

    static AbilitiesRequest buildAbilitiesRequest() {
        AbilitiesRequest req = new AbilitiesRequest();
        req.setPokemon("pikachu");
        return req
    }

    static List<AbilityBaseDTO> buildAbilityBases(int count) {
        List<AbilityBaseDTO> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(buildAbilityBase());
        }
        return list
    }

    static AbilityBaseDTO buildAbilityBase() {
        AbilityBaseDTO abilityBase = new AbilityBaseDTO();
        abilityBase.setAbility(buildAbility());
        return abilityBase
    }

    static AbilityDTO buildAbility() {
        AbilityDTO ability = new AbilityDTO();
        ability.setName(TestConstans.DEFAULT_ABILITY_NAME);
        ability.setUrl(TestConstans.DEFAULT_ABILITY_URL);
        return ability
    }

    static PokemonResponseDTO buildPokemonResponseDTO(Integer index) {
        return PokemonResponseDTO.builder()
                .abilities(buildAbilityBases(index))
                .name(TestConstans.DEFAULT_POKEMON_NAME)
                .id(TestConstans.DEFAULT_POKEMON_ID)
                .locationAreaEncounters(TestConstans.DEFAULT_LOCATION_AREA_ENCOUNTER)
                .baseExperience(TestConstans.DEFAULT_BASED_EXPERIENCE)
                .build();
    }
}

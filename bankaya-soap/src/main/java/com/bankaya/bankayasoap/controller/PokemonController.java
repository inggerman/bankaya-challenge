package com.bankaya.bankayasoap.controller;


import com.bankaya.bankayasoap.jaxb.*;
import com.bankaya.bankayasoap.parsers.PokemonParser;
import com.bankaya.bankayasoap.service.PokemonService;
import com.bankaya.bankayasoap.utils.HttpUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigInteger;

@Slf4j
@Endpoint
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PokemonController {

    private static final String NAMESPACE_URI = "http://www.german.com/springsoap/gen";

    private final PokemonService pokemonService;



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "abilitiesRequest")
    @ResponsePayload
    public AbilitiesResponse getAbilities(@RequestPayload AbilitiesRequest abilities) {
        AbilitiesResponse response = new AbilitiesResponse();
        response.getAbilitiesBase().addAll(PokemonParser.INSTANCE.parseToAbilitiesBase(pokemonService.getPokemonInformation(abilities.getPokemon(), HttpUtils.getClientIpAddressIfServletRequestExist()).getAbilities()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "baseExperienceRequest")
    @ResponsePayload
    public BaseExperienceResponse getBaseExperience(@RequestPayload BaseExperienceRequest baseExperienceRequest) {
        BaseExperienceResponse response = new BaseExperienceResponse();
        response.setBaseExperience(new BigInteger(pokemonService.getPokemonInformation(baseExperienceRequest.getPokemon(), HttpUtils.getClientIpAddressIfServletRequestExist()).getBaseExperience()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "heldItemsRequest")
    @ResponsePayload
    public HeldItemsResponse getHeldItems(@RequestPayload HeldItemsRequest heldItemsRequest) {
        HeldItemsResponse response = new HeldItemsResponse();
        response.getHeldItems().addAll(PokemonParser.INSTANCE.parseToHeldItems(pokemonService.getPokemonInformation(heldItemsRequest.getPokemon(), HttpUtils.getClientIpAddressIfServletRequestExist()).getHeldItemDTOS()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "idRequest")
    @ResponsePayload
    public IdResponse getIdItems(@RequestPayload IdRequest idRequest) {
        IdResponse response = new IdResponse();

        response.setId(new BigInteger(pokemonService.getPokemonInformation(idRequest.getPokemon(), HttpUtils.getClientIpAddressIfServletRequestExist()).getId()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "nameRequest")
    @ResponsePayload
    public NameResponse getName(@RequestPayload NameRequest nameRequest) {
        NameResponse response = new NameResponse();
        response.setName(nameRequest.getPokemon());
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "locationAreaEncountersRequest")
    @ResponsePayload
    public LocationAreaEncountersResponse getLocationAreaEncounters(@RequestPayload LocationAreaEncountersRequest locationAreaEncountersRequest) {
        LocationAreaEncountersResponse response = new LocationAreaEncountersResponse();

        response.setLocationAreaEncounters(pokemonService.getPokemonInformation(locationAreaEncountersRequest.getPokemon(), HttpUtils.getClientIpAddressIfServletRequestExist()).getLocationAreaEncounters());
        return response;
    }


}

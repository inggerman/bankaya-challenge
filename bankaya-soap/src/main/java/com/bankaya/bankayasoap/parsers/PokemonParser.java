package com.bankaya.bankayasoap.parsers;

import com.bankaya.bankayasoap.jaxb.*;
import com.bankaya.core.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PokemonParser {

    PokemonParser INSTANCE = Mappers.getMapper(PokemonParser.class);


    List<AbilityBase> parseToAbilitiesBase(List<AbilityBaseDTO> abilities);

    @Mapping(target = "ability",source = "ability.ability")
    @Mapping(target = "isHidden",source = "ability.hidden")
    @Mapping(target = "slot",source = "ability.slot")
    AbilityBase parseToAbilityBase(AbilityBaseDTO ability);

    List<HeldItem> parseToHeldItems(List<HeldItemDTO> heldItemDTOList);

    @Mapping(target = "item",source = "heldItemDTO.itemDTO")
    @Mapping(target = "versionDetails",source = "heldItemDTO.versionDetailDTOS")
    HeldItem parseToHeldItem(HeldItemDTO heldItemDTO);

    Item parseToItem(ItemDTO itemDTO);

    VersionDetail parseToVersionDetail(VersionDetailDTO versionDetailDTO);

    Version parseToVersion(VersionDTO versionDTO);

}

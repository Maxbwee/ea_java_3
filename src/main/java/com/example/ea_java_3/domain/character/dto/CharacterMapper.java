package com.example.ea_java_3.domain.character.dto;

import com.example.ea_java_3.domain.character.model.Character;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CharacterMapper {

    CharacterDTO toCharacterDto(Character character);

    Character toCharacter(CharacterDTO characterDTO);
}

package com.game.utils;

import com.game.dto.armor.ArmorDTO;
import com.game.repository.armor.Armor;
import org.springframework.stereotype.Component;

@Component
public class ArmorDTOConverter {

    public ArmorDTO convertToDto(Armor armor) {
        return new ArmorDTO(armor.getArmorID(), armor.getOwner(), armor.getArmorClass(), armor.getDurability(), armor.getPhysicalDefense(),
                armor.getMagicalDefense());
    }

}


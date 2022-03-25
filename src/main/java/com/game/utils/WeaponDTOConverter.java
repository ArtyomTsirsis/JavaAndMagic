package com.game.utils;

import com.game.dto.weapon.WeaponDTO;
import com.game.repository.weapon.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeaponDTOConverter {

    @Autowired
    private StringToSkillsCrypter converter;

    public WeaponDTO convertToDto(Weapon weapon) {
        return new WeaponDTO(weapon.getId(), weapon.getWeaponType(), weapon.getWhoCanUse(), weapon.getDurability(),
                weapon.getPhysicalDamage(), weapon.getMagicalDamage(), weapon.getLevel(), weapon.getCriticalHitChance());
    }

}


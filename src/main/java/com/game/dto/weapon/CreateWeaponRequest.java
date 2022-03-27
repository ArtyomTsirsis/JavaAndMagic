package com.game.dto.weapon;

import com.game.dto.hero.HeroDTO;
import com.game.repository.weapon.WeaponType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateWeaponRequest {

    private WeaponType weaponType;
    private HeroDTO hero;

}

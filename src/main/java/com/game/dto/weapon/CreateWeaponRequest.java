package com.game.dto.weapon;

import com.game.dto.hero.HeroDTO;
import com.game.domain.weapon.WeaponType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateWeaponRequest {

    @NotNull
    private WeaponType weaponType;
    private HeroDTO hero;

}

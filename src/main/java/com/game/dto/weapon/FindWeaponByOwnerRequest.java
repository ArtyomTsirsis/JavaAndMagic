package com.game.dto.weapon;

import com.game.dto.hero.HeroDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindWeaponByOwnerRequest {

    private HeroDTO hero;

}

package com.game.dto.weapon;

import com.game.repository.hero.HeroClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateWeaponRequest {

    private HeroClass heroClass;
    private String name;

}

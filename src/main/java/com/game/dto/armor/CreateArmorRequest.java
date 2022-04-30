package com.game.dto.armor;

import com.game.dto.hero.HeroDTO;
import com.game.repository.armor.ArmorClass;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateArmorRequest {

    private ArmorClass armorClass;
    private HeroDTO hero;

}

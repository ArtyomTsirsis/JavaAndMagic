package com.game.dto.armor;

import com.game.dto.hero.HeroDTO;
import com.game.repository.armor.ArmorClass;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class CreateArmorRequest {

    @NotNull
    private ArmorClass armorClass;
    private HeroDTO hero;

}

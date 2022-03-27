package com.game.dto.armor;

import com.game.dto.hero.HeroDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindArmorByOwnerRequest {

    private HeroDTO hero;

}

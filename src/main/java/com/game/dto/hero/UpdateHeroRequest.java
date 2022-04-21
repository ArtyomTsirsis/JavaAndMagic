package com.game.dto.hero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateHeroRequest {

    private HeroDTO updatedHeroDTO;

}

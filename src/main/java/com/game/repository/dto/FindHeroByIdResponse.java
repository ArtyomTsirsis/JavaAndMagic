package com.game.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindHeroByIdResponse {

    private HeroDTO hero;

}

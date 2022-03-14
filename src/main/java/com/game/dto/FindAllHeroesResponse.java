package com.game.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FindAllHeroesResponse {

    private List<HeroDTO> heroes;

}

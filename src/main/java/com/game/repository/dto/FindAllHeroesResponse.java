package com.game.repository.dto;

import lombok.Data;

import java.util.List;

@Data
public class FindAllHeroesResponse {

    private List<HeroDTO> heroes;

}

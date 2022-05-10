package com.game.core;

import com.game.dto.hero.HeroDTO;
import com.game.repository.enemy.Enemy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdventureRequest {

    private HeroDTO hero;
    private String move;
    private Boolean fightChoice;
    private Enemy enemy;

}

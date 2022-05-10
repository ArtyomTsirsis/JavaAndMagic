package com.game.dto.battle;

import com.game.dto.hero.HeroDTO;
import com.game.repository.enemy.Enemy;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BattleResponse {

    private HeroDTO hero;
    private Enemy enemy;
    private String heroSkillStatus;
    private String enemySkillStatus;
}

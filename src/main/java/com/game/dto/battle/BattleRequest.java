package com.game.dto.battle;

import com.game.dto.hero.HeroDTO;
import com.game.domain.enemy.Enemy;
import com.game.skills.enemy.EnemySkill;
import com.game.skills.hero.HeroSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BattleRequest {

    private HeroDTO hero;
    private Enemy enemy;
    private HeroSkill heroSkill;
    private EnemySkill enemySkill;

}

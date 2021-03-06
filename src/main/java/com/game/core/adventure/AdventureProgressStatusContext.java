package com.game.core.adventure;

import com.game.dto.hero.HeroDTO;
import com.game.domain.enemy.Enemy;
import com.game.skills.enemy.EnemySkill;
import com.game.skills.hero.HeroSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdventureProgressStatusContext {

    private HeroDTO hero;
    private String move;
    private Boolean fightChoice;
    private Enemy enemy;
    private HeroSkill heroSkill;
    private EnemySkill enemySkill;

}

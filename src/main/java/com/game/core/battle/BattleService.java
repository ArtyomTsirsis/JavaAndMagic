package com.game.core.battle;

import com.game.dto.battle.BattleRequest;
import com.game.dto.battle.BattleResponse;
import org.springframework.stereotype.Service;

@Service
public class BattleService {

    public BattleResponse startBattle(BattleRequest request) {
        var hero = request.getHero();
        var enemy = request.getEnemy();
        var heroSkill = request.getHeroSkill();
        var heroSkillStatus = heroSkill.execute(hero, enemy);
        var enemySkill = request.getEnemySkill();
        var enemySkillStatus = enemySkill.execute(hero, enemy);
        return new BattleResponse(hero, enemy, heroSkillStatus, enemySkillStatus);
    }


}

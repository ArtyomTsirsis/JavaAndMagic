package com.game.core.adventure;

import com.game.dto.battle.BattleRequest;
import com.game.dto.battle.BattleResponse;
import com.game.core.battle.BattleService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class AdventureServiceCollectorsDataAndMakeABattle {

    @Autowired
    private AdventureProgressStatusService adventureProgressStatusService;

    @Autowired
    private BattleService battleService;

    public BattleResponse battleStart() {
        var request = new BattleRequest();
        request.setHero(adventureProgressStatusService.getHero());
        request.setEnemy(adventureProgressStatusService.getEnemy());
        request.setHeroSkill(adventureProgressStatusService.getHeroSkill());
        request.setEnemySkill(adventureProgressStatusService.getEnemySkill());
        System.out.println("BATTLE BEGIN!");
        return battleService.startBattle(request);
    }
}

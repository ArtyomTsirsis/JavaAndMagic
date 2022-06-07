package com.game.core.adventure;

import com.game.core.battle.BattleService;
import com.game.dto.adventure.AdventureRequest;
import com.game.dto.battle.BattleRequest;
import com.game.dto.battle.BattleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdventureServiceCollectorsDataAndMakeABattle {

    private final BattleService battleService;

    public BattleResponse battleStart(AdventureRequest request) {
        return battleService.startBattle(battleRequestMaker(request));
    }

    private BattleRequest battleRequestMaker(AdventureRequest request) {
        var battleRequest = new BattleRequest();
        battleRequest.setHero(request.getHero());
        battleRequest.setEnemy(request.getEnemy());
        battleRequest.setHeroSkill(request.getHeroSkill());
        battleRequest.setEnemySkill(request.getEnemySkill());
        return battleRequest;
    }

}

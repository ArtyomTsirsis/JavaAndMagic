package com.game.core.adventure;

import com.game.core.battle.BattleService;
import com.game.dto.adventure.AdventureRequest;
import com.game.dto.adventure.AdventureResponse;
import com.game.dto.battle.BattleRequest;
import com.game.dto.battle.BattleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Chapter4 {

    private final BattleService battleService;

    public AdventureResponse startAdventure(AdventureRequest request) {
        if (fightChoiceCheck(request)) {
            var battle = battleService.startBattle(battleRequestMaker(request));
            return adventureResponseFromBattleResponse(battle);
        }
        return adventureResponseFromAdventureRequest(request);
    }

    private boolean fightChoiceCheck(AdventureRequest request) {
        return request.getFightChoice();
    }

    private BattleRequest battleRequestMaker(AdventureRequest request) {
        var battleRequest = new BattleRequest();
        battleRequest.setHero(request.getHero());
        battleRequest.setEnemy(request.getEnemy());
        battleRequest.setHeroSkill(request.getHeroSkill());
        battleRequest.setEnemySkill(request.getEnemySkill());
        return battleRequest;
    }

    private AdventureResponse adventureResponseFromBattleResponse(BattleResponse response) {
        var adventureResponse = new AdventureResponse();
        adventureResponse.setHero(response.getHero());
        adventureResponse.setEnemy(response.getEnemy());
        adventureResponse.setHeroSkillStatus(response.getHeroSkillStatus());
        adventureResponse.setEnemySkillStatus(response.getEnemySkillStatus());
        adventureResponse.setAdventureDescription("A " + response.getHero().getName() + " chose to fight the enemy!");
        return adventureResponse;
    }

    private AdventureResponse adventureResponseFromAdventureRequest(AdventureRequest request) {
        var response = new AdventureResponse();
        response.setHero(request.getHero());
        response.setMove(request.getMove());
        response.setFightChoice(request.getFightChoice());
        response.setEnemy(request.getEnemy());
        response.setHeroSkill(request.getHeroSkill());
        response.setEnemySkill(request.getEnemySkill());
        response.setAdventureDescription("A " + request.getHero().getName() + " avoids the enemy and continues on his path!");
        return response;

    }


}

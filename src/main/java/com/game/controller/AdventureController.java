package com.game.controller;

import com.game.core.AdventureRequest;
import com.game.core.AdventureResponse;
import com.game.core.AdventureServiceCollectorsDataAndMakeABattle;
import com.game.core.StartAdventureService;
import com.game.dto.battle.BattleResponse;
import com.game.reposervices.battle.BattleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/adventure")
@RequiredArgsConstructor
public class AdventureController {

    @Autowired
    private StartAdventureService startAdventureService;
    @Autowired
    private BattleService battleService;
    @Autowired
    private AdventureServiceCollectorsDataAndMakeABattle adventureServiceCollectorsDataAndMakeABattle;

    @PutMapping("/chapter/{id}")
    public AdventureResponse startAdventureChapter1(@PathVariable("id") Integer id, @RequestBody AdventureRequest request) {
        var chapterId = id;
        switch (chapterId) {
            case 1 -> startAdventureService.startAdventureChapter1(request);
            case 2 -> startAdventureService.startAdventureChapter2(request);
            case 3 -> startAdventureService.startAdventureChapter3(request);
            case 4 -> startAdventureService.startAdventureChapter4(request);
        }
        var response = new AdventureResponse();
        response.setHero(request.getHero());
        response.setMove(request.getMove());
        response.setFightChoice(request.getFightChoice());
        response.setEnemy(request.getEnemy());
        response.setHeroSkill(request.getHeroSkill());
        response.setEnemySkill(request.getEnemySkill());
        return response;
    }

    @PutMapping("/chapter5TheFight")
    public BattleResponse startAdventureChapter5() {
        return adventureServiceCollectorsDataAndMakeABattle.battleStart();
    }
}

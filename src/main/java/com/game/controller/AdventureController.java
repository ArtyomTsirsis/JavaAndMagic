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

    @PutMapping("/chapter1")
    public AdventureResponse startAdventureChapter1(@RequestBody AdventureRequest request) {
        return startAdventureService.startAdventureChapter1(request);
    }

    @PutMapping("/chapter2")
    public AdventureResponse startAdventureChapter2(@RequestBody AdventureRequest request) {
        return startAdventureService.startAdventureChapter2(request);
    }

    @PutMapping("/chapter3")
    public AdventureResponse startAdventureChapter3(@RequestBody AdventureRequest request) {
        return startAdventureService.startAdventureChapter3(request);
    }

    @PutMapping("/chapter4")
    public AdventureResponse startAdventureChapter4(@RequestBody AdventureRequest request) {
        return startAdventureService.startAdventureChapter4(request);
    }

    @PutMapping("/chapter5TheFight")
    public BattleResponse startAdventureChapter5() {
        return adventureServiceCollectorsDataAndMakeABattle.battleStart();
    }
}

package com.game.controller;

import com.game.dto.adventure.AdventureRequest;
import com.game.dto.adventure.AdventureResponse;
import com.game.core.adventure.AdventureServiceCollectorsDataAndMakeABattle;
import com.game.core.adventure.ChapterSelectorService;
import com.game.dto.battle.BattleResponse;
import com.game.core.battle.BattleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adventure")
@RequiredArgsConstructor
public class AdventureController {

    @Autowired
    private ChapterSelectorService chapterSelectorService;
    @Autowired
    private BattleService battleService;
    @Autowired
    private AdventureServiceCollectorsDataAndMakeABattle adventureServiceCollectorsDataAndMakeABattle;

    @PutMapping("/chapter/{id}")
    public AdventureResponse startAdventure(@PathVariable("id") Integer id, @RequestBody AdventureRequest request) {
        return chapterSelectorService.selector(id, request);
    }

    @PutMapping("/chapter5TheFight")
    public BattleResponse startAdventureChapter5() {
        return adventureServiceCollectorsDataAndMakeABattle.battleStart();
    }

}

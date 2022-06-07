package com.game.controller;

import com.game.core.adventure.AdventureServiceCollectorsDataAndMakeABattle;
import com.game.core.adventure.ChapterSelectorService;
import com.game.dto.adventure.AdventureRequest;
import com.game.dto.adventure.AdventureResponse;
import com.game.dto.battle.BattleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adventure")
@RequiredArgsConstructor
public class AdventureController {


    private final ChapterSelectorService chapterSelectorService;

    private final AdventureServiceCollectorsDataAndMakeABattle adventureServiceCollectorsDataAndMakeABattle;

    @PutMapping("/chapter/{id}")
    public AdventureResponse startAdventure(@PathVariable("id") Integer id, @RequestBody AdventureRequest request) {
        return chapterSelectorService.selector(id, request);
    }

    @PutMapping("/chapter5TheFight")
    public BattleResponse startAdventureChapter5(@RequestBody AdventureRequest request) {
        return adventureServiceCollectorsDataAndMakeABattle.battleStart(request);
    }

}

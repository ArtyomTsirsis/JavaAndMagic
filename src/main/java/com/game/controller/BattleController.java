package com.game.controller;

import com.game.dto.battle.BattleRequest;
import com.game.dto.battle.BattleResponse;
import com.game.dto.battle.CreateEnemyResponse;
import com.game.core.battle.BattleService;
import com.game.core.battle.RandomEnemyGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/battle")
@RequiredArgsConstructor
public class BattleController {

    private final BattleService battleService;
    private final RandomEnemyGeneratorService enemyGeneratorService;

    @PutMapping
    public BattleResponse startBattle(@RequestBody BattleRequest request) {
        return battleService.startBattle(request);
    }

    @GetMapping(value = "/enemy")
    public CreateEnemyResponse generateEnemy() {
        return new CreateEnemyResponse(enemyGeneratorService.generateEnemy());
    }

}

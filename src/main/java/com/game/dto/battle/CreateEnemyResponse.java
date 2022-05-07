package com.game.dto.battle;

import com.game.repository.enemy.Enemy;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateEnemyResponse {

    private Enemy enemy;
}

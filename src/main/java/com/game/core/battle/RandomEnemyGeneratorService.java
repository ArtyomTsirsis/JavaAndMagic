package com.game.core.battle;

import com.game.domain.enemy.Enemy;
import com.game.domain.enemy.EnemyFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

import static com.game.domain.enemy.EnemyClass.*;

@Service
public class RandomEnemyGeneratorService {

    private final Random random = new Random();

    public Enemy generateEnemy() {
        var randomEnemy = random.nextInt(3);
        return switch (randomEnemy) {
            case 1 -> EnemyFactory.createEnemy(ORC);
            case 2 -> EnemyFactory.createEnemy(SKELETON);
            default -> EnemyFactory.createEnemy(SPIDER);
        };
    }

}

package com.game.reposervices.battle;

import com.game.repository.enemy.Enemy;
import com.game.repository.enemy.EnemyFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

import static com.game.repository.enemy.EnemyClass.*;

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

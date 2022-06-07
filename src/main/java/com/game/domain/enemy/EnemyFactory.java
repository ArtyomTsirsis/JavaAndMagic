package com.game.domain.enemy;

public class EnemyFactory {

    public static Enemy createEnemy(EnemyClass enemyClass) {
        return switch (enemyClass) {
            case ORC -> new Orc();
            case SKELETON -> new Skeleton();
            case SPIDER -> new Spider();
            default -> null;
        };
    }

}

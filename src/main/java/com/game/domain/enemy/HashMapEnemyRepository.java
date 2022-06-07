package com.game.domain.enemy;

import java.util.HashMap;
import java.util.Map;

public class HashMapEnemyRepository implements EnemyRepository {

    private final static Map<EnemyClass, Enemy> enemyRepo = new HashMap<>();

    @Override
    public void save(Enemy enemy) {
        enemyRepo.put(enemy.getEnemyClass(), enemy);
    }

    @Override
    public Enemy findById(EnemyClass enemyClass) {
        return enemyRepo.get(enemyClass);
    }

    @Override
    public Iterable<Enemy> findAll() {
        return enemyRepo.values();
    }

    @Override
    public void deleteById(EnemyClass enemyClass) {
        enemyRepo.remove(enemyClass);
    }

}

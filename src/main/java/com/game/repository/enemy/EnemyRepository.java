package com.game.repository.enemy;

public interface EnemyRepository {

    public void save(Enemy enemy);
    public Enemy findById(EnemyClass enemyClass);
    public Iterable<Enemy> findAll();
    public void deleteById(EnemyClass enemyClass);

}

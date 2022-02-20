package repository.enemy;

import java.util.HashMap;
import java.util.Map;

public class EnemyRepository {

    private final static Map<EnemyClass, Enemy> enemyRepo = new HashMap<>();

    //    Create Heroes in Factory and put them to Map.
    public void save(EnemyClass enemyClass) {
        enemyRepo.put(enemyClass, EnemyFactory.createEnemy(enemyClass));
    }

    //    Find hero by id
    public Enemy findById(EnemyClass enemyClass) {
        return enemyRepo.get(enemyClass);
    }

    //    Find all heroes
    public Iterable<Enemy> findAll() {
        return enemyRepo.values();
    }

    //    Delete Hero by id
    public void deleteById(EnemyClass enemyClass) {
        enemyRepo.remove(enemyClass);
    }

}

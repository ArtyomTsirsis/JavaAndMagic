package enemy;

public class EnemyFactory {

    public static Enemy getEnemy(EnemyClass enemyClass) {
        Enemy toReturn;
        switch (enemyClass) {
            case ORC:
                toReturn = new Orc();
                break;
            case SKELETON:
                toReturn = new Skeleton();
                break;
            case SPIDER:
                toReturn = new Spider();
                break;
            default:
                toReturn = null;
        }
        return toReturn;
    }

}

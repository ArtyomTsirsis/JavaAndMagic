package skills;

import enemy.Enemy;
import hero.Hero;

public class Context {

    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Pair executeStrategy(Hero hero, Enemy enemy) {
        return strategy.execute(hero, enemy);
    }

}

class Pair {
    private final Hero hero;
    private final Enemy enemy;

    public Pair(Hero hero, Enemy enemy) {
        this.hero = hero;
        this.enemy = enemy;
    }

    Hero getHero() {
        return hero;
    }

    Enemy getEnemy() {
        return enemy;
    }

}
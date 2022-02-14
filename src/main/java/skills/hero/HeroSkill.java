package skills.hero;

import repository.enemy.Enemy;
import repository.hero.Hero;

public interface HeroSkill {

    String execute(Hero hero, Enemy enemy);

}


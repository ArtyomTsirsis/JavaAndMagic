package skills.hero;

import lombok.Data;
import repository.enemy.Enemy;
import repository.hero.Hero;

@Data
public class ConcreteHeroSkillHealing implements HeroSkill {

    private String name = "Лечение";

    @Override
    public String execute(Hero hero, Enemy enemy) {

        return "";
    }

}

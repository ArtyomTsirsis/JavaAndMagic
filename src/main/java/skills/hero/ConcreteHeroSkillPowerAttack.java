package skills.hero;

import lombok.Data;
import repository.enemy.Enemy;
import repository.hero.Hero;

@Data
public class ConcreteHeroSkillPowerAttack implements HeroSkill {

    private String name = "Мощная атака";

    @Override
    public String execute(Hero hero, Enemy enemy) {

        return "";
    }

}

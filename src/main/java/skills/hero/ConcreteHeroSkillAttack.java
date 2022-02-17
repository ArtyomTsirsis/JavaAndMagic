package skills.hero;

import lombok.Data;
import repository.enemy.Enemy;
import repository.hero.Hero;

@Data
public class ConcreteHeroSkillAttack implements HeroSkill {

    private String name = "Быстрая атака";

    @Override
    public String execute(Hero hero, Enemy enemy) {

        return "";
    }

}

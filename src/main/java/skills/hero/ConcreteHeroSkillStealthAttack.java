package skills.hero;

import lombok.Data;
import repository.enemy.Enemy;
import repository.hero.Hero;

@Data
public class ConcreteHeroSkillStealthAttack implements HeroSkill {

    private String name = "Скрытная атака";

    @Override
    public String execute(Hero hero, Enemy enemy) {

        return "";
    }

}

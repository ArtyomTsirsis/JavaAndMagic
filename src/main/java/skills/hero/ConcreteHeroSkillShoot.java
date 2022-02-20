package skills.hero;

import lombok.Data;
import repository.enemy.Enemy;
import repository.hero.Hero;

@Data
public class ConcreteHeroSkillShoot implements HeroSkill {

    private String name = "Стрельба";

    @Override
    public String execute(Hero hero, Enemy enemy) {

        return "Попадание. Вы нанесли урон Х";
    }

}

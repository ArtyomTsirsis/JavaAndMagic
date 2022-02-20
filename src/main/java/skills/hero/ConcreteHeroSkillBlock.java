package skills.hero;

import lombok.Data;
import repository.enemy.Enemy;
import repository.hero.Hero;

@Data
public class ConcreteHeroSkillBlock implements HeroSkill {

    private String name = "Блокирование";

    @Override
    public String execute(Hero hero, Enemy enemy) {

        return "Это хрень потом будет чем-то другим";
    }

}

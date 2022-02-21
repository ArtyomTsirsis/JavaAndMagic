package skills.hero;

import lombok.Data;
import repository.enemy.Enemy;
import repository.hero.Hero;

@Data
public class ConcreteHeroSkillHealing implements HeroSkill {

    private static final CriticalHitOrMissCalculatorContext CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT = new CriticalHitOrMissCalculatorContext();
    private final String name = "Лечение";
    private int criticalHitChance = 0;
    private int missChance = 0;

    @Override
    public String execute(Hero hero, Enemy enemy) {
        int heal = 10 * hero.getLevel() + 50;
        hero.setHealth(hero.getHealth() + heal);
        return "Вы восстановили " + heal + " ОЗ.";
    }

}

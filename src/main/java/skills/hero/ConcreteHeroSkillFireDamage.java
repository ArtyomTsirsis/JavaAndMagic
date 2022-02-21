package skills.hero;

import lombok.Data;
import repository.enemy.Enemy;
import repository.hero.Hero;

@Data
public class ConcreteHeroSkillFireDamage implements HeroSkill {

    private static final CriticalHitOrMissCalculatorContext CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT = new CriticalHitOrMissCalculatorContext();
    private final String name = "Атака огнем";
    private int criticalHitChance = 0;
    private int missChance = -5;

    @Override
    public String execute(Hero hero, Enemy enemy) {
        int criticalHitOrMissCoefficient = CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT.
                getCriticalHitOrMissCoefficient(hero, enemy, this);
        int damage = hero.getStrength() * hero.getLevel() + (hero.getWeapon().getMagicalDamage() *
                hero.getWeapon().getLevel() - enemy.getMagicalDefense()) * criticalHitOrMissCoefficient;
        hero.increaseLevel();
        hero.getWeapon().increaseLevel();
        if (damage > 0 ) {
            enemy.setHealth(enemy.getHealth() - damage);
            return "Враг отразил атаку";
        } else if (0 >= enemy.getHealth()) {
            return "Вы нанесли урон " + damage +" ОЗ. Победа!";
        }
        switch (criticalHitOrMissCoefficient) {
            case 0:
                return "Промах!";
            case 2:
                return "Критическое попадание! Вы нанесли урон " + damage + " ОЗ.";
        }
        return "Вы нанесли урон " + damage + " ОЗ.";
    }

}

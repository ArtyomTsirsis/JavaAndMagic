package skills.hero;

import lombok.Data;
import repository.enemy.Enemy;
import repository.hero.Hero;

@Data
public class ConcreteHeroSkillPowerAttack implements HeroSkill {

    private static final HeroCriticalHitOrMissCalculator CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT = new HeroCriticalHitOrMissCalculator();
    private final String name = "Мощная атака";
    private int criticalHitChance = 7;
    private int missChance = 10;

    @Override
    public String execute(Hero hero, Enemy enemy) {
        int criticalHitOrMissCoefficient = CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT.
                getCriticalHitOrMissCoefficient(hero, enemy, this);
        int damage = ((hero.getStrength() * hero.getLevel() + (hero.getWeapon().getPhysicalDamage() *
                hero.getWeapon().getLevel() - enemy.getPhysicalDefense()) + (hero.getWeapon().getMagicalDamage() *
                hero.getWeapon().getLevel() - enemy.getMagicalDefense()))) * criticalHitOrMissCoefficient * 2;
        hero.increaseLevel();
        hero.getWeapon().increaseLevel();
        if (0 >= damage) {
            return "Враг отразил атаку";
        } else if (damage >= enemy.getHealth()) {
            return "Вы нанесли урон " + damage +" ОЗ. Победа!";
        }
        enemy.setHealth(enemy.getHealth() - damage);
        switch (criticalHitOrMissCoefficient) {
            case 0:
                return "Промах!";
            case 2:
                return "Критическое попадание! Вы нанесли урон " + damage + " ОЗ.";
        }
        return "Вы нанесли урон " + damage + " ОЗ.";
    }

}

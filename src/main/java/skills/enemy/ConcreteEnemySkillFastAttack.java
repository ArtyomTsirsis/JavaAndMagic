package skills.enemy;

import lombok.Data;
import repository.enemy.Enemy;
import repository.hero.Hero;

@Data
public class ConcreteEnemySkillFastAttack implements EnemySkill {

    private static final EnemyCriticalHitOrMissCalculator CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT = new EnemyCriticalHitOrMissCalculator();
    private final String name = "Быстрая атака";
    private int criticalHitChance = 0;
    private int missChance = 0;

    @Override
    public String execute(Hero hero, Enemy enemy) {
        int criticalHitOrMissCoefficient = CRITICAL_HIT_OR_MISS_CALCULATOR_CONTEXT
                .getCriticalHitOrMissCoefficient(hero, enemy, this);
        int damage = ((enemy.getPhysicalDamage() - hero.getArmor().getPhysicalDefense()) +
                (enemy.getMagicalDamage() - hero.getArmor().getMagicalDefense())) * criticalHitOrMissCoefficient;
        hero.increaseLevel();
        if (0 >= damage) {
            return "Вы отразили атаку";
        } else if (damage >= enemy.getHealth()) {
            return "Вы получили урон " + damage +" ОЗ. Поражение!";
        }
        hero.setHealth(hero.getHealth() - damage);
        switch (criticalHitOrMissCoefficient) {
            case 0:
                return "Промах!";
            case 2:
                return "Критическое попадание! Вы получили урон " + damage + " ОЗ.";
        }
        return "Вы получили урон " + damage + " ОЗ.";
    }

}

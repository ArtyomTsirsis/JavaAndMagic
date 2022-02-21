package skills.hero;

import lombok.Data;
import repository.enemy.Enemy;
import repository.hero.Hero;

@Data
public class ConcreteHeroSkillAttack implements HeroSkill {

    private static final CriticalHitOrMissCalculatorContext criticalHitOrMissCalculatorContext = new CriticalHitOrMissCalculatorContext();
    private String name = "Быстрая атака";

    @Override
    public String execute(Hero hero, Enemy enemy) {
        int criticalHitOrMissCoefficient = criticalHitOrMissCalculatorContext.getCriticalHitOrMissCoefficient(hero, enemy);
        int damage = enemy.getHealth() - (hero.getStrength() * hero.getLevel() + hero.getWeapon().getPhysicalDamage() *
                hero.getWeapon().getLevel() - enemy.getPhysicalDefense() + hero.getWeapon().getMagicalDamage() +
                hero.getWeapon().getLevel() - enemy.getMagicalDefense()) * criticalHitOrMissCoefficient;
        enemy.setHealth(enemy.getHealth() - damage);
        hero.increaseLevel();
        hero.getWeapon().increaseLevel();
        if (0 >= enemy.getHealth()) {
            return "Вы нанесли урон " + damage +" ОЗ быстрой атакой. Победа!";
        }
        switch (criticalHitOrMissCoefficient) {
            case 0:
                return "Промах!";
            case 1:
                return "Критическое попадание! Вы нанесли урон " + damage + " ОЗ быстрой атакой.";
        }
        return "Вы нанесли урон " + damage + " ОЗ быстрой атакой.";
    }

}

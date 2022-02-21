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
        int damage = enemy.getHealth() - (hero.getStrength() * hero.getLevel() + hero.getWeapon().getPhysicalDamage() *
                hero.getWeapon().getLevel() - enemy.getPhysicalDefense() + hero.getWeapon().getMagicalDamage() +
                hero.getWeapon().getLevel() - enemy.getMagicalDefense()) *
                criticalHitOrMissCalculatorContext.getCriticalHitOrMissCoefficient(hero, enemy);
        enemy.setHealth(enemy.getHealth() - damage);
        hero.increaseLevel();
        hero.getWeapon().increaseLevel();
        return "Быстрая атака. Вы нанесли урон " + damage;
    }

}

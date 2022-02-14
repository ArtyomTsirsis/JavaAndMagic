package skills.hero;

import repository.enemy.Enemy;
import repository.hero.Hero;

public class HeroSkillContext {

    private HeroSkill heroSkill;

    public void setHeroSkill(HeroSkill heroSkill) {
        this.heroSkill = heroSkill;
    }

    public String useSkill(Hero hero, Enemy enemy) {
        return heroSkill.execute(hero, enemy);
    }

}
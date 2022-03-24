package com.game.skills.hero;

import org.springframework.stereotype.Component;

@Component
public class HeroSkillFactory {

    public static HeroSkill createSkill(String skill) {
        HeroSkill toReturn;
        switch (skill) {
            case "AttackWOWeapon":
                toReturn = new ConcreteHeroSkillAttackWOWeapon();
                break;
            case "FastAttack":
                toReturn = new ConcreteHeroSkillFastAttack();
                break;
            case "FireDamage":
                toReturn = new ConcreteHeroSkillFireDamage();
                break;
            case "Healing":
                toReturn = new ConcreteHeroSkillHealing();
                break;
            case "PowerAttack":
                toReturn = new ConcreteHeroSkillPowerAttack();
                break;
            case "Shoot":
                toReturn = new ConcreteHeroSkillShoot();
                break;
            case "StealthAttack":
                toReturn = new ConcreteHeroSkillStealthAttack();
                break;
            default:
                toReturn = null;
        }
        return toReturn;
    }

}

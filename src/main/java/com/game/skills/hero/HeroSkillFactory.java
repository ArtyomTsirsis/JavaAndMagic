package com.game.skills.hero;

import org.springframework.stereotype.Component;

@Component
public class HeroSkillFactory {

    public static HeroSkill createSkill(String skill) {
        return switch (skill) {
            case "AttackWOWeapon" -> new ConcreteHeroSkillAttackWOWeapon();
            case "FastAttack" -> new ConcreteHeroSkillFastAttack();
            case "FireDamage" -> new ConcreteHeroSkillFireDamage();
            case "Healing" -> new ConcreteHeroSkillHealing();
            case "PowerAttack" -> new ConcreteHeroSkillPowerAttack();
            case "Shoot" -> new ConcreteHeroSkillShoot();
            case "StealthAttack" -> new ConcreteHeroSkillStealthAttack();
            default -> null;
        };
    }

}

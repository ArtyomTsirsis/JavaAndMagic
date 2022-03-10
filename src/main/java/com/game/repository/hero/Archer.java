package com.game.repository.hero;

import com.game.repository.armor.Armor;
import com.game.repository.armor.ArmorClass;
import com.game.repository.armor.ArmorFactory;
import com.game.repository.weapon.Weapon;
import com.game.repository.weapon.WeaponFactory;
import com.game.repository.weapon.WeaponType;
import com.game.skills.hero.ConcreteHeroSkillAttackWOWeapon;
import com.game.skills.hero.ConcreteHeroSkillHealing;
import com.game.skills.hero.ConcreteHeroSkillShoot;
import com.game.skills.hero.HeroSkill;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class Archer implements Hero {

    private final static HeroClass HERO_CLASS = HeroClass.ARCHER;
    @NonNull
    private String name;
    private Integer health = 150;
    private Integer strength = 10;
    private Integer level = 1;
    private Integer dexterity = 12;
    private Armor armor = ArmorFactory.createArmor(ArmorClass.LEATHER_ARMOR);
    private Weapon weapon = WeaponFactory.createWeapon(WeaponType.BOW);
    private List<HeroSkill> skills = List.of(new ConcreteHeroSkillAttackWOWeapon(), new ConcreteHeroSkillShoot(), new ConcreteHeroSkillHealing());

    @Override
    public HeroClass getHeroClass() {
        return HERO_CLASS;
    }

    @Override
    public void setHealth(Integer health) {
        this.health = health;
    }

    @Override
    public void increaseLevel() {
        level++;
    }

}
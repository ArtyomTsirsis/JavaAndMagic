package com.game.repository.hero;

import com.game.repository.armor.Armor;
import com.game.repository.armor.ArmorClass;
import com.game.repository.armor.ArmorFactory;
import com.game.repository.weapon.Weapon;
import com.game.repository.weapon.WeaponFactory;
import com.game.repository.weapon.WeaponType;
import com.game.skills.hero.ConcreteHeroSkillAttackWOWeapon;
import com.game.skills.hero.ConcreteHeroSkillFireDamage;
import com.game.skills.hero.ConcreteHeroSkillHealing;
import com.game.skills.hero.HeroSkill;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class Wizard implements Hero {

    private final static HeroClass HERO_CLASS = HeroClass.WIZARD;
    @NonNull
    private String name;
    private Integer health = 200;
    private Integer strength = 15;
    private Integer level = 1;
    private Integer dexterity = 8;
    private Armor armor = ArmorFactory.createArmor(ArmorClass.MAGICAL_SHIELD);
    private Weapon weapon = WeaponFactory.createWeapon(WeaponType.MAGIC_STAFF);
    private List<HeroSkill> skills = List.of(new ConcreteHeroSkillAttackWOWeapon(), new ConcreteHeroSkillFireDamage(), new ConcreteHeroSkillHealing());

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

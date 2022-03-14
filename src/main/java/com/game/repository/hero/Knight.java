package com.game.repository.hero;

import com.game.repository.armor.Armor;
import com.game.repository.armor.ArmorClass;
import com.game.repository.armor.ArmorFactory;
import com.game.repository.weapon.Weapon;
import com.game.repository.weapon.WeaponFactory;
import com.game.repository.weapon.WeaponType;
import com.game.skills.hero.ConcreteHeroSkillFastAttack;
import com.game.skills.hero.ConcreteHeroSkillHealing;
import com.game.skills.hero.ConcreteHeroSkillPowerAttack;
import com.game.skills.hero.HeroSkill;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class Knight implements Hero {

    private final static HeroClass HERO_CLASS = HeroClass.KNIGHT;
    @NonNull
    private String name;
    private Integer health = 400;
    private Integer strength = 20;
    private Integer level = 1;
    private Integer dexterity = 10;
    private Armor armor = ArmorFactory.createArmor(ArmorClass.SHIELD);
    private Weapon weapon = WeaponFactory.createWeapon(WeaponType.SWORD);
    private List<HeroSkill> skills = List.of(new ConcreteHeroSkillFastAttack(), new ConcreteHeroSkillPowerAttack(), new ConcreteHeroSkillHealing());
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

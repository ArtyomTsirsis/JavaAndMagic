package com.game.repository.hero;

import com.game.repository.armor.Armor;
import com.game.repository.armor.ArmorClass;
import com.game.repository.armor.ArmorFactory;
import com.game.repository.weapon.Weapon;
import com.game.repository.weapon.WeaponFactory;
import com.game.repository.weapon.WeaponType;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

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
    private Armor armor = ArmorFactory.createArmor(ArmorClass.WITHOUT_ARMOR);
    private Weapon weapon = WeaponFactory.createWeapon(WeaponType.WITHOUT_WEAPON);
    private String skills = "AttackWOWeapon, Shoot, Healing";

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
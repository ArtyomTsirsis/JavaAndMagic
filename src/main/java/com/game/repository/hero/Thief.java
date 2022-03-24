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
public class Thief implements Hero {

    private final static HeroClass HERO_CLASS = HeroClass.THIEF;
    @NonNull
    private String name;
    private Integer health = 250;
    private Integer strength = 15;
    private Integer level = 1;
    private Integer dexterity = 20;
    private Armor armor = ArmorFactory.createArmor(ArmorClass.WITHOUT_ARMOR);
    private Weapon weapon = WeaponFactory.createWeapon(WeaponType.WITHOUT_WEAPON);
    private String skills = "FastAttack, StealthAttack, Healing";

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
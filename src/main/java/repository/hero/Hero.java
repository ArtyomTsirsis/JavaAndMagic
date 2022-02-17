package repository.hero;

import repository.armor.Armor;
import repository.weapon.Weapon;
import skills.hero.HeroSkill;

import java.util.List;

public interface Hero {

    HeroClass getHeroClass();
    String getName();
    Integer getHealth();
    void setHealth(Integer health);
    Integer getStrength();
    Integer getLevel();
    void setLevel(Integer level);
    Integer getDexterity();
    Armor getArmor();
    Weapon getWeapon();
    List<HeroSkill> getSkills();
    String toString();

}
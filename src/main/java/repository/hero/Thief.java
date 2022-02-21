package repository.hero;

import repository.armor.Armor;
import repository.armor.ArmorClass;
import repository.armor.ArmorFactory;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import repository.weapon.Weapon;
import repository.weapon.WeaponFactory;
import repository.weapon.WeaponType;
import skills.hero.*;

import java.util.List;

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
    private Armor armor = ArmorFactory.createArmor(ArmorClass.LEATHER_ARMOR);
    private Weapon weapon = WeaponFactory.createWeapon(WeaponType.LANCE);
    private List<HeroSkill> skills = List.of(new ConcreteHeroSkillAttack(), new ConcreteHeroSkillStealthAttack(), new ConcreteHeroSkillHealing());

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

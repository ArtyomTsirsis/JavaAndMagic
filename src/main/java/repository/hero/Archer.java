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

@RequiredArgsConstructor
@Data
public class Archer implements Hero {

    private final static HeroClass HERO_CLASS = HeroClass.ARCHER;
    @NonNull
    private String name;
    private Integer health = 150;
    private Integer strength = 10;
    private Integer level = 1;
    private Integer dexterity = 35;
    private Armor armor = ArmorFactory.createArmor(ArmorClass.LEATHER_ARMOR);
    private Weapon weapon = WeaponFactory.createWeapon(WeaponType.BOW);

    @Override
    public HeroClass getHeroClass() {
        return HERO_CLASS;
    }

    @Override
    public void setHealth(Integer health) {
        this.health = health;
    }

    @Override
    public void setLevel(Integer level) {
        this.level = level;
    }

}
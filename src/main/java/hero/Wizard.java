package hero;

import armor.Armor;
import armor.ArmorClass;
import armor.ArmorFactory;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import weapon.Weapon;
import weapon.WeaponFactory;
import weapon.WeaponType;

@RequiredArgsConstructor
@Data
public class Wizard implements Hero {

    private final static HeroClass HERO_CLASS = HeroClass.WIZARD;
    @NonNull
    private String name;
    private Integer health = 200;
    private Integer strength = 15;
    private Integer level = 1;
    private Integer dexterity = 25;
    private Armor armor = ArmorFactory.createArmor(ArmorClass.MAGICAL_SHIELD);
    private Weapon weapon = WeaponFactory.createWeapon(WeaponType.MAGIC_STAFF);

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

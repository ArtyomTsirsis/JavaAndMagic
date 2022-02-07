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
public class Knight implements Hero {

    private final static HeroClass HERO_CLASS = HeroClass.KNIGHT;
    @NonNull
    private String name;
    private Integer health = 400;
    private Integer strength = 20;
    private Integer level = 1;
    private Integer dexterity = 20;
    private Armor armor = ArmorFactory.createArmor(ArmorClass.SHIELD);
    private Weapon weapon = WeaponFactory.createWeapon(WeaponType.SWORD);

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

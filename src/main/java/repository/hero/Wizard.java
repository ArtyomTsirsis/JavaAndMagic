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
    private List<HeroSkill> skills = List.of(new ConcreteHeroSkillAttack(), new ConcreteHeroSkillFireDamage(), new ConcreteHeroSkillHealing());

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

package com.game.repository.hero;

import com.game.repository.armor.Armor;
import com.game.repository.weapon.Weapon;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name="hero")
@Table(name="heroes")
public class Hero {

    @Id
    private String name;
    @Column(name = "hero_class", columnDefinition = "ENUM('ARCHER', 'KNIGHT', 'THIEF', 'WIZARD')")
    @Enumerated(EnumType.STRING)
    private HeroClass heroClass;
    @Column
    private Integer health;
    @Column
    private Integer strength;
    @Column
    private Integer level;
    @Column
    private Integer dexterity;
    @OneToOne
    @JoinColumn(name = "armorID", referencedColumnName = "armorID")
    private Armor armor;
    @OneToOne
    @JoinColumn(name = "weaponID", referencedColumnName = "weaponID")
    private Weapon weapon;
    @Column(name = "skill_book")
    private String skillBook;

    public Hero(Hero hero) {
        this.name = hero.getName();
        this.heroClass = hero.getHeroClass();
        this.health = hero.getHealth();
        this.strength = hero.getStrength();
        this.level = hero.getLevel();
        this.dexterity = hero.getDexterity();
        this.skillBook = hero.getSkillBook();
        this.weapon = hero.getWeapon();
        this.armor = hero.getArmor();
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Hero hero = (Hero) o;
        return heroClass != null && Objects.equals(heroClass, hero.heroClass);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
package com.game.repository.hero;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="heroes")
public class Hero {

    @Id
    private String name;
    @Column(columnDefinition = "ENUM('ARCHER', 'KNIGHT', 'THIEF', 'WIZARD')")
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
    @Column
    private Integer armorID;
    @Column
    private Integer weaponID;
    @Column
    private String skillBook;

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public void increaseLevel() {
        level++;
    }

    public boolean isAlive() {
        return 0 < this.health;
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
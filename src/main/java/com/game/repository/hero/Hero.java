package com.game.repository.hero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="heroes")
public class Hero {

    @Id
    private HeroClass heroClass;
    @Column
    private String name;
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

}
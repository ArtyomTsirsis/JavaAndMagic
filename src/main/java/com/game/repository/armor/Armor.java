package com.game.repository.armor;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="armor")
public class Armor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer armorID;
    @Column
    private String owner;
    @Column(columnDefinition="ENUM('WITHOUT_ARMOR', 'ARMOR_SUIT', 'LEATHER_ARMOR', 'MAGICAL_SHIELD', 'SHIELD')")
    @Enumerated(EnumType.STRING)
    private ArmorClass armorClass;
    @Column
    private Integer durability;
    @Column
    private Integer physicalDefense;
    @Column
    private Integer magicalDefense;

    public Armor(Armor armor) {
        this.armorID = armor.getArmorID();
        this.owner = armor.getOwner();
        this.armorClass = armor.getArmorClass();
        this.durability = armor.getDurability();
        this.physicalDefense = armor.getPhysicalDefense();
        this.magicalDefense = armor.getMagicalDefense();
    }

    public void decreaseDurability() {
        this.durability--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Armor armor = (Armor) o;
        return armorID != null && Objects.equals(armorID, armor.armorID);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}

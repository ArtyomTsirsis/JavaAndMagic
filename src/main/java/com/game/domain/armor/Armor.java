package com.game.domain.armor;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="armor")
@Table(name="armor")
public class Armor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer armorID;
    @Column
    private String owner;
    @Column(name = "armor_class", columnDefinition = "ENUM('WITHOUT_ARMOR', 'ARMOR_SUIT', 'LEATHER_ARMOR', 'MAGICAL_SHIELD', 'SHIELD')")
    @Enumerated(EnumType.STRING)
    private ArmorClass armorClass;
    @Column
    private Integer durability;
    @Column(name = "physical_defense")
    private Integer physicalDefense;
    @Column(name = "magical_defense")
    private Integer magicalDefense;

    public Armor(Armor armor) {
        this.armorID = armor.getArmorID();
        this.owner = armor.getOwner();
        this.armorClass = armor.getArmorClass();
        this.durability = armor.getDurability();
        this.physicalDefense = armor.getPhysicalDefense();
        this.magicalDefense = armor.getMagicalDefense();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Armor armor)) return false;
        return Objects.equals(getArmorID(), armor.getArmorID()) && Objects.equals(getOwner(), armor.getOwner()) && getArmorClass() == armor.getArmorClass() && Objects.equals(getDurability(), armor.getDurability()) && Objects.equals(getPhysicalDefense(), armor.getPhysicalDefense()) && Objects.equals(getMagicalDefense(), armor.getMagicalDefense());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArmorID(), getOwner(), getArmorClass(), getDurability(), getPhysicalDefense(), getMagicalDefense());
    }

}

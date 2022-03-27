package com.game.repository.armor;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LeatherArmor implements Armor {

    private Integer id;
    private String owner;
    private ArmorClass armorClass = ArmorClass.LEATHER_ARMOR;
    private Integer durability = 20;
    private Integer physicalDefense = 30;
    private Integer magicalDefense = 0;

    @Override
    public void decreaseDurability() {
        this.durability--;
    }

    @Override
    public void setOwner(String owner) {
        this.owner = owner;
    }

}

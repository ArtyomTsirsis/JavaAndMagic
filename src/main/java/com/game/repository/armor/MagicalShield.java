package com.game.repository.armor;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MagicalShield implements Armor {

    private Integer id;
    private ArmorClass armorClass = ArmorClass.MAGICAL_SHIELD;
    private Integer durability = 150;
    private Integer physicalDefense = 0;
    private Integer magicalDefense = 15;

    @Override
    public void decreaseDurability() {
        this.durability--;
    }

}

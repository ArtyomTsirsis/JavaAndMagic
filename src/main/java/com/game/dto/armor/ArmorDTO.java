package com.game.dto.armor;

import com.game.repository.armor.ArmorClass;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArmorDTO {

    private Integer id;
    private String owner;
    private ArmorClass armorClass;
    private Integer durability;
    private Integer physicalDefense;
    private Integer magicalDefense;

    public void decreaseDurability() {
        this.durability--;
    }

    public boolean isBroken() {
        return 1 > durability;
    }

}

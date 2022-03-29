package com.game.repository.armor.templates;

import com.game.repository.armor.Armor;
import com.game.repository.armor.ArmorClass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class WOArmor extends Armor {

    private Integer armorID = -1;
    private String owner = "all";
    private ArmorClass armorClass = ArmorClass.WITHOUT_ARMOR;
    private Integer durability = 1;
    private Integer physicalDefense = 0;
    private Integer magicalDefense = 0;

    @Override
    public void decreaseDurability() {
    }

}

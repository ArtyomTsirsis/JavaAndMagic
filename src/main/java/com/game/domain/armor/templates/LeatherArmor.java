package com.game.domain.armor.templates;

import com.game.domain.armor.Armor;
import com.game.domain.armor.ArmorClass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LeatherArmor extends Armor {

    private Integer armorID;
    private String owner;
    private ArmorClass armorClass = ArmorClass.LEATHER_ARMOR;
    private Integer durability = 20;
    private Integer physicalDefense = 30;
    private Integer magicalDefense = 0;

}

package com.game.domain.armor.templates;

import com.game.domain.armor.Armor;
import com.game.domain.armor.ArmorClass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class WOArmor extends Armor {

    private Integer armorID;
    private String owner;
    private ArmorClass armorClass = ArmorClass.WITHOUT_ARMOR;
    private Integer durability = Integer.MAX_VALUE;
    private Integer physicalDefense = 0;
    private Integer magicalDefense = 0;

}

package com.game.domain.armor.templates;

import com.game.domain.armor.Armor;
import com.game.domain.armor.ArmorClass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Shield extends Armor {

    private Integer armorID;
    private String owner;
    private ArmorClass armorClass = ArmorClass.SHIELD;
    private Integer durability = 30;
    private Integer physicalDefense = 70;
    private Integer magicalDefense = 0;

}

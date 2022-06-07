package com.game.domain.armor.templates;

import com.game.domain.armor.Armor;
import com.game.domain.armor.ArmorClass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MagicalShield extends Armor {

    private Integer armorID;
    private String owner;
    private ArmorClass armorClass = ArmorClass.MAGICAL_SHIELD;
    private Integer durability = 150;
    private Integer physicalDefense = 0;
    private Integer magicalDefense = 15;

}

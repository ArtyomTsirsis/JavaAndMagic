package com.game.repository.armor.templates;

import com.game.repository.armor.Armor;
import com.game.repository.armor.ArmorClass;
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

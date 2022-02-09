package armor;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ArmorSuit implements Armor {

    private ArmorClass armorClass = ArmorClass.ARMOR_SUIT;
    private Integer durability = 100;
    private Integer physicalDefense = 30;
    private Integer magicalDefense = 0;

}
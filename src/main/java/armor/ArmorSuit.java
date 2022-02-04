package armor;

public class ArmorSuit extends Armor {

    private final static ArmorClass armorClass = ArmorClass.ArmorSuit;

    public ArmorSuit(ArmorClass name, Integer durability, Integer physicalDefense, Integer magicalDefense) {
        super(name, durability, physicalDefense, magicalDefense);
    }

}

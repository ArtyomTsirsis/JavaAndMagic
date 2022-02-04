package armor;

public class MagicalShield extends Armor {

    private final static ArmorClass armorClass = ArmorClass.MagicalShield;

    public MagicalShield(ArmorClass name, Integer durability, Integer physicalDefense, Integer magicalDefense) {
        super(name, durability, physicalDefense, magicalDefense);
    }

}

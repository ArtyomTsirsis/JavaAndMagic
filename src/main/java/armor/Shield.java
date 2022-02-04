package armor;

public class Shield extends Armor {

    private final static ArmorClass armorClass = ArmorClass.Shield;

    public Shield(ArmorClass name, Integer durability, Integer physicalDefense, Integer magicalDefense) {
        super(name, durability, physicalDefense, magicalDefense);
    }

}

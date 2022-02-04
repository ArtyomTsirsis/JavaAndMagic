package armor;

//@AllArgsConstructor
public class Armor {

    private ArmorClass name;
    private Integer durability;
    private Integer physicalDefense;
    private Integer magicalDefense;

    public Armor(ArmorClass name, Integer durability, Integer physicalDefense, Integer magicalDefense) {
        this.name = name;
        this.durability = durability;
        this.physicalDefense = physicalDefense;
        this.magicalDefense = magicalDefense;
    }

    @Override
    public String toString() {
        return "Armor{" +
                "name=" + name +
                ", durability=" + durability +
                ", physicalDefense=" + physicalDefense +
                ", magicalDefense=" + magicalDefense +
                '}';
    }

}

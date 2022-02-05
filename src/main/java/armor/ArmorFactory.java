package armor;

public class ArmorFactory {

    public static Armor getArmor(ArmorClass armorClass) {
        Armor toReturn;
        switch (armorClass) {
            case ArmorSuit:
                toReturn = new ArmorSuit();
                break;
            case MagicalShield:
                toReturn = new MagicalShield();
                break;
            case Shield:
                toReturn = new Shield();
                break;
            default:
                toReturn = null;
        }
        return toReturn;
    }

}

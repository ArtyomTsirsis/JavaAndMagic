package repository.armor;

public class ArmorFactory {

    public static Armor createArmor(ArmorClass armorClass) {
        Armor toReturn;
        switch (armorClass) {
            case ARMOR_SUIT:
                toReturn = new ArmorSuit();
                break;
            case LEATHER_ARMOR:
                toReturn = new LeatherArmor();
                break;
            case MAGICAL_SHIELD:
                toReturn = new MagicalShield();
                break;
            case SHIELD:
                toReturn = new Shield();
                break;
            default:
                toReturn = null;
        }
        return toReturn;
    }

}

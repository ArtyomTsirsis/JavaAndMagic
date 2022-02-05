package weapon;

public class WeaponFactory {

    public static Weapon getWeapon(WeaponType weaponType) {
        Weapon toReturn;
        switch (weaponType) {
            case Axe:
                toReturn = new Axe();
                break;
            case Bow:
                toReturn = new Bow();
                break;
            case Lance:
                toReturn = new Lance();
                break;
            case MagicStaff:
                toReturn = new MagicStaff();
                break;
            case Sword:
                toReturn = new Sword();
                break;
            default:
                toReturn = null;
        }
        return toReturn;
    }

}

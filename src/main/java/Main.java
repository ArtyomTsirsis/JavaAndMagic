import armor.Armor;
import armor.ArmorClass;
import armor.ArmorRepository;
import hero.HeroClass;
import hero.HeroRepository;
import hero.Knight;
import menu.MainMenu;
import weapon.PhysicalWeapon;
import weapon.WeaponRepository;
import weapon.WeaponType;

public class Main {

    public static void main(String[] args) {

        WeaponRepository.weaponRepo.put(WeaponType.Sword, new PhysicalWeapon(WeaponType.Sword,30, 100, 0, 1));
        ArmorRepository.armorRepo.put(ArmorClass.Shield, new Armor(ArmorClass.Shield, 10, 50, 0));
        HeroRepository.heroRepo.put(HeroClass.Knight, new Knight("Arthur", 500, 30, 1, 30,
                ArmorRepository.armorRepo.get(ArmorClass.Shield), (PhysicalWeapon) WeaponRepository.weaponRepo.get(WeaponType.Sword)));
        System.out.println("Welcome you, adventurer!");
        System.out.println(HeroRepository.heroRepo.get(HeroClass.Knight));
        new MainMenu().openMenu();

    }

}

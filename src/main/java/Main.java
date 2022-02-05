import armor.ArmorClass;
import armor.ArmorFactory;
import armor.ArmorRepository;
import hero.HeroClass;
import hero.HeroRepository;
import hero.Knight;
import menu.MainMenu;
import weapon.Sword;
import weapon.WeaponFactory;
import weapon.WeaponRepository;
import weapon.WeaponType;

public class Main {

    public static void main(String[] args) {

        WeaponRepository.weaponRepo.put(WeaponType.Sword, WeaponFactory.getWeapon(WeaponType.Sword));
        ArmorRepository.armorRepo.put(ArmorClass.Shield, ArmorFactory.getArmor(ArmorClass.Shield));
        HeroRepository.heroRepo.put(HeroClass.Knight, new Knight("Arthur", 500, 30, 1, 30,
                ArmorRepository.armorRepo.get(ArmorClass.Shield), (Sword) WeaponRepository.weaponRepo.get(WeaponType.Sword)));
        System.out.println("Welcome you, adventurer!");
        System.out.println(HeroRepository.heroRepo.get(HeroClass.Knight));
        new MainMenu().openMenu();

    }

}

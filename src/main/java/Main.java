import hero.HeroClass;
import hero.HeroRepository;
import hero.Knight;
import menu.MainMenu;

public class Main {

    public static void main(String[] args) {

        HeroRepository.heroRepo.put(HeroClass.KNIGHT, new Knight("Arthur"));
        System.out.println("Welcome you, adventurer!");
        System.out.println(HeroRepository.heroRepo.get(HeroClass.KNIGHT));
        new MainMenu().openMenu();

    }

}

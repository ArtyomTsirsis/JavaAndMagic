package GameDemo;
public class JavaAndMagic {

    public static void main(String[] args) {
        HeroRepository repository = new DataBaseHeroRepository();
        MainMenu game = new MainMenu(repository);
        game.run();
    }
}

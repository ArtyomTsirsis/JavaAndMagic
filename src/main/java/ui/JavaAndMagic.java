package ui;

import com.game.repository.hero.HeroRepository;

public class JavaAndMagic {

    public static void main(String[] args) {
        HeroRepository repository = new HeroRepository();
        MainMenu game = new MainMenu(repository);
        game.run();
    }

}

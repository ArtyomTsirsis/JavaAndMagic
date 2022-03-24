package com.game.ui;

import com.game.repository.hero.HashMapHeroRepository;

public class JavaAndMagic {

    public static void main(String[] args) {
        HashMapHeroRepository repository = new HashMapHeroRepository();
        MainMenu game = new MainMenu(repository);
        game.run();
    }

}

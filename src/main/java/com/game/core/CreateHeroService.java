package com.game.core;


import com.game.repository.hero.Hero;
import com.game.repository.hero.HashMapHeroRepository;

public class CreateHeroService {

    private final HashMapHeroRepository repository;

    public CreateHeroService(HashMapHeroRepository repository) {
        this.repository = repository;
    }

    public void create(Hero hero) {
        if (null == repository.findById(hero.getName())) {
            repository.save(hero);

            System.out.println("**************************************");
            System.out.println("Hero successfully made!");
        } else {
            System.out.println("**************************************");
            System.out.println("Hero with this name already exist!");
        }
    }

}

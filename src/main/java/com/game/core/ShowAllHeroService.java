package com.game.core;

import com.game.repository.hero.Hero;
import com.game.repository.hero.HeroRepository;

public class ShowAllHeroService {

    private final HeroRepository repository;

    public ShowAllHeroService(HeroRepository repository) {
        this.repository = repository;
    }

    public Iterable<Hero> findAll() {
        return repository.findAll();
    }

}

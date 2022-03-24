package com.game.core;

import com.game.repository.hero.Hero;
import com.game.repository.hero.HashMapHeroRepository;

public class ShowAllHeroService {

    private final HashMapHeroRepository repository;

    public ShowAllHeroService(HashMapHeroRepository repository) {
        this.repository = repository;
    }

    public Iterable<Hero> findAll() {
        return repository.findAll();
    }

}

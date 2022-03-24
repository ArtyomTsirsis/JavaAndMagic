package com.game.core;

import com.game.repository.hero.HashMapHeroRepository;

public class DeleteByIdService {

    private final HashMapHeroRepository repository;

    public DeleteByIdService(HashMapHeroRepository repository) {
        this.repository = repository;
    }

    public void delete(String heroName) {
        if (repository.findById(heroName) != null) {
            repository.deleteById(heroName);
            System.out.println("**************************************");
            System.out.println("Hero successfully removed!");
        } else {
            System.out.println("**************************************");
            System.out.println("Hero with this name doesn't exist!");
        }
    }

}

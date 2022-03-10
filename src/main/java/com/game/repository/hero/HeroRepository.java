package com.game.repository.hero;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class HeroRepository {

    private final static Map<String, Hero> heroRepo = new HashMap<>();

//    Create Heroes in Factory and put them to Map.
    public void save(Hero hero) {
        heroRepo.put(hero.getName(), hero);
    }

//    Find hero by id
    public Hero findById(String heroName) {
        return heroRepo.get(heroName);
    }

//    Find all heroes
    public Iterable<Hero> findAll() {
        return heroRepo.values();
    }

//    Delete Hero by id
    public void deleteById(String heroName) {
        heroRepo.remove(heroName);
    }

}
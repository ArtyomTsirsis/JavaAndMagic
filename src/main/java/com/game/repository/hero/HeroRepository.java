package com.game.repository.hero;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HeroRepository {

    private final static Map<String, Hero> heroRepo = new HashMap<>();

    public void save(Hero hero) {
        heroRepo.put(hero.getName(), hero);
    }

    public Hero findById(String heroName) {
        return heroRepo.get(heroName);
    }

    public List<Hero> findAll() {
        return heroRepo.values().stream().toList();
    }

    public void deleteById(String heroName) {
        heroRepo.remove(heroName);
    }

}
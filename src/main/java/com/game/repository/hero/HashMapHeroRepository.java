package com.game.repository.hero;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Repository
public class HashMapHeroRepository implements HeroRepository {

    private final static Map<String, Hero> heroRepo = new HashMap<>();

    @Override
    public void save(Hero hero) {
        heroRepo.put(hero.getName(), hero);
    }

    @Override
    public Hero findById(String heroName) {
        return heroRepo.get(heroName);
    }

    @Override
    public List<Hero> findAll() {
        return heroRepo.values().stream().toList();
    }

    @Override
    public void deleteById(String heroName) {
        heroRepo.remove(heroName);
    }

}
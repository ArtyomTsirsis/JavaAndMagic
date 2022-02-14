package repository.hero;

import java.util.*;

public class HeroRepository {

    private final static Map<String, Hero> heroRepo = new HashMap<>();

//    Create Heroes in Factory and put them to Map.
    public Hero save(HeroClass heroClass, String heroName) {
        Hero toReturn = HeroFactory.createHero(heroClass, heroName);
        heroRepo.put(heroName, toReturn);
        return toReturn;
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
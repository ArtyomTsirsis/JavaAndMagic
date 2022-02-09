package hero;

import java.util.*;

public class HeroRepository {

    private final static Map<String, Hero> heroRepo = new HashMap<>();
    private final static List<Hero> heroRepo2 = new ArrayList<>();

//    Create Heroes in Factory and put them to Map.
    public static Hero save(HeroClass heroClass, String heroName) {
        Hero toReturn = HeroFactory.createHero(heroClass, heroName);
        heroRepo.put(heroName, toReturn);
        return toReturn;
    }

//    Find hero by id
    public static Hero findById(String heroName) {
        return heroRepo.get(heroName);
    }

//    Find all heroes
    public static Iterable<Hero> findAll() {
        return heroRepo.values();
    }

//    Delete Hero by id
    public static void deleteById(String heroName) {
        heroRepo.remove(heroName);
    }

//    Check, if name already exists
    public boolean validateName(String heroName) {
        return heroRepo.containsKey(heroName);
    }

//    Create Heroes in Factory and put them to List.
    public static Hero save2(HeroClass heroClass, String heroName) {
        Hero toReturn = HeroFactory.createHero(heroClass, heroName);
        heroRepo2.add(toReturn);
        return toReturn;
    }

//        Find hero by id
    public static Optional<Hero> findById2(String heroName) {
        return heroRepo2.stream().filter(o -> heroName.equals(o.getName())).findFirst();
    }

    //    Find all heroes
    public static List<Hero> findAll2() {
        return heroRepo2;
    }

    //    Delete Hero by id
    public static void deleteById2(String heroName) {
        heroRepo2.remove(heroRepo2.stream().filter(o -> heroName.equals(o.getName())).findFirst().get());
    }

//        Check, if name already exists
    public boolean validateName2(String heroName) {
        return heroRepo2.stream().anyMatch(o -> heroName.equals(o.getName()));
    }






}
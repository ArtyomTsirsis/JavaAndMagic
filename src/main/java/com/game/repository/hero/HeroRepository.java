package com.game.repository.hero;

import java.util.List;
import java.util.Optional;

public interface HeroRepository {

    void save(Hero hero);
    Optional<Hero> findById(String heroName);
    List<Hero> findAll();
    void deleteById(String heroName);

}

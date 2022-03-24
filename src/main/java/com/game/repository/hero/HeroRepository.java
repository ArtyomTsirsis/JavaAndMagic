package com.game.repository.hero;

import java.util.List;

public interface HeroRepository {

    public void save(Hero hero);
    public Hero findById(String heroName);
    public List<Hero> findAll();
    public void deleteById(String heroName);

}

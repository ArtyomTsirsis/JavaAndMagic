package core;

import repository.hero.Hero;
import repository.hero.HeroRepository;

public class ShowAllHeroService {

    private final HeroRepository repository;

    public ShowAllHeroService(HeroRepository repository) {
        this.repository = repository;
    }

    public Iterable<Hero> findAll() {
        return repository.findAll();
    }

}

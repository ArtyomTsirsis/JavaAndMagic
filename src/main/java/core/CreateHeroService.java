package core;


import repository.hero.Hero;
import repository.hero.HeroRepository;

public class CreateHeroService {

    private final HeroRepository repository;

    public CreateHeroService(HeroRepository repository) {
        this.repository = repository;
    }

    public void create(Hero hero) {
        if (null == repository.findById(hero.getName())) {
            repository.save(hero);
            System.out.println("**************************************");
            System.out.println("Hero successfully made!");
        } else {
            System.out.println("**************************************");
            System.out.println("Hero with this name already exist!");
        }
    }
}

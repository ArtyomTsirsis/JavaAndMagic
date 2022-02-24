package core;

import repository.hero.HeroRepository;

public class DeleteByIdService {

    private final HeroRepository repository;

    public DeleteByIdService(HeroRepository repository) {
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

package ui;
import repository.hero.Hero;
import repository.hero.HeroRepository;

public class ShowAllHeroUIAction implements UIAction {

    private HeroRepository heroRepo;

    public ShowAllHeroUIAction(HeroRepository repository) {
        this.heroRepo = repository;
    }

    public void execute() {

        System.out.println("\033[H\033[2J");
        System.out.flush();

        // поиск всех героев в базе данных:

        Iterable<Hero> result = heroRepo.findAll();
        System.out.println(result);


        // выводим на консоль результаты поиска

        System.out.println("**************************************");

    }

}

package ui;
import hero.HeroRepository;

public class ShowAllHeroUIAction implements UIAction {

    private HeroRepository heroRepo;

    public ShowAllHeroUIAction(HeroRepository repository) {
        this.heroRepo = repository;
    }

    public void execute() {

        System.out.println("\033[H\033[2J");
        System.out.flush();

        // поиск всех героев в базе данных:



        // выводим на консоль результаты поиска

        System.out.println("**************************************");

    }

}

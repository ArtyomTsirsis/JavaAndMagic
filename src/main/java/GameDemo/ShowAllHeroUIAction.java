package GameDemo;
public class ShowAllHeroUIAction implements UIAction {

    private HeroRepository repository;

    public ShowAllHeroUIAction(HeroRepository repository) {
        this.repository = repository;
    }

    public void execute() {

        // поиск всех героев в базе данных:
        String result = repository.index();

        // выводим на консоль результаты поиска
        System.out.println(result);
        System.out.println("**************************************");

    }

}

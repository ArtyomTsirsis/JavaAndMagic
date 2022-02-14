package ui;
import java.util.Scanner;

import repository.hero.Hero;
import repository.hero.HeroRepository;

public class DeleteByIdUIAction implements UIAction {

    private HeroRepository heroRepo;
//    Long id; надо переделать на ИД
    String heroName;

    public DeleteByIdUIAction(HeroRepository repository) {
        this.heroRepo = repository;
    }

    public void execute() {

        System.out.println("\033[H\033[2J");
        System.out.flush();

        // вывод всех героев из базы данных:
        Iterable<Hero> result = heroRepo.findAll();
        System.out.println(result);

        // запрашиваем имя героя с консоли у пользолвателя
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите имя героя, которого хотите удалить: ");
        heroName = sc.nextLine();

        // поиск героя в базе данных и удаление:
        heroRepo.deleteById(heroName);

        System.out.println("Герой удалён");
        System.out.println("**************************************");

    }




}

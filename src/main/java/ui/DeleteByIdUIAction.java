package ui;

import java.util.Scanner;

import core.DeleteByIdService;
import core.ShowAllHeroService;

public class DeleteByIdUIAction implements UIAction {

    private ShowAllHeroService showAllHeroService;
    private final DeleteByIdService deleteByIdService;
    String heroName;

    public DeleteByIdUIAction(ShowAllHeroService showAllHeroService, DeleteByIdService deleteByIdService) {
        this.showAllHeroService = showAllHeroService;
        this.deleteByIdService = deleteByIdService;
    }

    public void execute() {

        System.out.println("\033[H\033[2J");
        System.out.flush();

        // вывод всех героев из базы данных:
        showAllHeroService.findAll().forEach(hero -> {
            System.out.println("Hero name: " + hero.getName());
        });

        // запрашиваем имя героя с консоли у пользолвателя
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter hero name, what you want to remove: ");
        heroName = sc.nextLine();

        // поиск героя в базе данных и удаление:
        deleteByIdService.delete(heroName);

        System.out.println("**************************************");

    }


}

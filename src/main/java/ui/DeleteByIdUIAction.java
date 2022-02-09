package ui;
import java.util.Scanner;
import hero.HeroRepository;

public class DeleteByIdUIAction implements UIAction {

    private HeroRepository heroRepo;
    Long id;

    public DeleteByIdUIAction(HeroRepository repository) {
        this.heroRepo = repository;
    }

    public void execute() {

        System.out.println("\033[H\033[2J");
        System.out.flush();

        // вывод всех героев из базы данных:


        // запрашиваем id героя с консоли у пользолвателя
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите ID героя, которого хотите удалить: ");
        id = sc.nextLong();

        // поиск героя в базе данных и удаление:

        System.out.println("Герой удалён");
        System.out.println("**************************************");

    }




}

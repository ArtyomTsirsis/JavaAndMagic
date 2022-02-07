package ui;
import java.util.Scanner;

public class CreateHeroUIAction implements UIAction {

    private HeroRepository repository;
    String name;

    public CreateHeroUIAction(HeroRepository repository) {
        this.repository = repository;
    }

    public void execute() {
        // запрашиваем данные о герое с консоли у пользолвателя (пока только имя =))
        Scanner sc = new Scanner(System.in);
        System.out.print("Пожалуйста, введите имя героя: ");
        name = sc.nextLine();

        // создаём экземпляр класса GameDemo.Hero (не указывая поле id, его присвоит сама база данных)
        Hero hero1 = new Hero(name);

        // сохранение его в базу данных
        repository.save(hero1);
    }
}

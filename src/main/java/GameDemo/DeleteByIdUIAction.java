package GameDemo;

import java.util.Scanner;

class DeleteByIdUIAction implements UIAction {

    private HeroRepository repository;
    Long id;

    public DeleteByIdUIAction(HeroRepository repository) {
        this.repository = repository;
    }

    public void execute() {

        // вывод всех героев из базы данных:
        String result = repository.index();
        System.out.println(result);

        // запрашиваем id героя с консоли у пользолвателя
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите ID героя, которого хотите удалить: ");
        id = sc.nextLong();

        // поиск героя в базе данных и удаление:
        repository.deleteById(id);
        System.out.println("Герой удалён");
        System.out.println("**************************************");

    }


}

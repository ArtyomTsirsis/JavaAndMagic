package ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import repository.hero.HeroRepository;

public class MainMenu {

    private Map<Integer, UIAction> menuNumberToActionMap;
    private HeroRepository repository;

    public MainMenu(HeroRepository repository) {
        this.repository = repository;

        menuNumberToActionMap = new HashMap();
        menuNumberToActionMap.put(1, new CreateHeroUIAction(repository));
        menuNumberToActionMap.put(2, new ShowAllHeroUIAction(repository));
        menuNumberToActionMap.put(3, new DeleteByIdUIAction(repository));


    }

    public void run() {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\033[H\033[2J");
            System.out.flush();

            System.out.println("1) Создаём героя.");
            System.out.println("2) Вывести всех героев.");
            System.out.println("3) Удаляем героя.");
            System.out.println("0) Завершаем программу.");
            System.out.println("**************************************");
            System.out.print("Пожалуйста, введите число: ");
            int userSelectedMenuNumber = Integer.parseInt(sc.nextLine());
            if (userSelectedMenuNumber == 0) {
                System.out.println("Удачного дня! Заходите ещё!");
                break;
            } else {
                executeUIAction(userSelectedMenuNumber);
            }
        }
    }

    private void executeUIAction(int userSelectedMenuNumber) {
        UIAction uiAction = menuNumberToActionMap.get(userSelectedMenuNumber);
        if (uiAction != null) {
            uiAction.execute();
        } else {
            System.out.println("Нужно выбирать действия из списка, а не как вы: " + userSelectedMenuNumber);
        }
    }

}


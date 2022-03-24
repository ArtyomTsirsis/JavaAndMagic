package com.game.ui;

import com.game.core.CreateHeroService;
import com.game.core.DeleteByIdService;
import com.game.core.ShowAllHeroService;
import com.game.core.StartAdventureService;
import com.game.repository.hero.HashMapHeroRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {

    private Map<Integer, UIAction> menuNumberToActionMap;
    private HashMapHeroRepository repository;

    public MainMenu(HashMapHeroRepository repository) {
        this.repository = repository;

        var createHeroService = new CreateHeroService(repository);
        var showAllHeroService = new ShowAllHeroService(repository);
        var deleteByIdService = new DeleteByIdService(repository);
        var startAdventureService = new StartAdventureService(repository);

        menuNumberToActionMap = new HashMap();
        menuNumberToActionMap.put(1, new CreateHeroUIAction(createHeroService));
        menuNumberToActionMap.put(2, new StartAdventureUIAction(startAdventureService, showAllHeroService));
        menuNumberToActionMap.put(3, new ShowAllHeroUIAction(showAllHeroService));
        menuNumberToActionMap.put(4, new DeleteByIdUIAction(showAllHeroService, deleteByIdService));


    }

    public void run() {


        System.out.println("       █████                                      █████████                  █████    ██████   ██████                     ███          \n" +
                "      ░░███                                      ███░░░░░███                ░░███    ░░██████ ██████                     ░░░           \n" +
                "       ░███   ██████   █████ █████  ██████      ░███    ░███  ████████    ███████     ░███░█████░███   ██████    ███████ ████   ██████ \n" +
                "       ░███  ░░░░░███ ░░███ ░░███  ░░░░░███     ░███████████ ░░███░░███  ███░░███     ░███░░███ ░███  ░░░░░███  ███░░███░░███  ███░░███\n" +
                "       ░███   ███████  ░███  ░███   ███████     ░███░░░░░███  ░███ ░███ ░███ ░███     ░███ ░░░  ░███   ███████ ░███ ░███ ░███ ░███ ░░░ \n" +
                " ███   ░███  ███░░███  ░░███ ███   ███░░███     ░███    ░███  ░███ ░███ ░███ ░███     ░███      ░███  ███░░███ ░███ ░███ ░███ ░███  ███\n" +
                "░░████████  ░░████████  ░░█████   ░░████████    █████   █████ ████ █████░░████████    █████     █████░░████████░░███████ █████░░██████ \n" +
                " ░░░░░░░░    ░░░░░░░░    ░░░░░     ░░░░░░░░    ░░░░░   ░░░░░ ░░░░ ░░░░░  ░░░░░░░░    ░░░░░     ░░░░░  ░░░░░░░░  ░░░░░███░░░░░  ░░░░░░  \n" +
                "                                                                                                                ███ ░███               \n" +
                "                                             Console microgame by ComboBreakers team.                          ░░██████                \n" +
                "                                                                                                                ░░░░░░                 ");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\033[H\033[2J");
            System.out.flush();

            System.out.println();
            System.out.println("1) Create hero.");
            System.out.println("2) Start adventure.");
            System.out.println("3) Show all heroes.");
            System.out.println("4) Remove hero.");
            System.out.println("0) Exit.");
            System.out.println("**************************************");
            System.out.print("Please select actions from the list: ");
            int userSelectedMenuNumber = Integer.parseInt(sc.nextLine());
            if (userSelectedMenuNumber == 0) {
                System.out.println("**************************************");
                System.out.println("Have a nice day! Comeback later!");
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
            System.out.println("Please select actions from the list, not like you: " + userSelectedMenuNumber);
        }
    }


}


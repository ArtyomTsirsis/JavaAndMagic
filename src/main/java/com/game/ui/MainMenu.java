package com.game.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Component
public class MainMenu {

    private Map<Integer, UIAction> menuNumberToActionMap;
    @Autowired
    private CreateHeroUIAction createHeroUIAction;
    @Autowired
    private StartAdventureUIAction startAdventureUIAction;
    @Autowired
    private ShowAllHeroUIAction showAllHeroUIAction;
    @Autowired
    private DeleteByIdUIAction deleteByIdUIAction;


    public void run() {

        menuNumberToActionMap = new HashMap();
        menuNumberToActionMap.put(1, createHeroUIAction);
        menuNumberToActionMap.put(2, startAdventureUIAction);
        menuNumberToActionMap.put(3, showAllHeroUIAction);
        menuNumberToActionMap.put(4, deleteByIdUIAction);


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


package com.game.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Component
public class MainMenu {

    // UI Dependency
    @Autowired
    private CreateHeroUIAction createHeroUIAction;
    @Autowired
    private StartAdventureUIAction startAdventureUIAction;
    @Autowired
    private ShowAllHeroUIAction showAllHeroUIAction;
    @Autowired
    private DeleteByIdUIAction deleteByIdUIAction;


    public void run() {

        var scanner = new Scanner(System.in);


        while (true) {
            try {

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

                System.out.println("\033[H\033[2J");
                System.out.flush();

                System.out.println("======================================================================================================================================");
                System.out.println("|                                                           MAIN MENU                                                                |");
                System.out.println("======================================================================================================================================");
                System.out.println("|                                                       1. Create Hero.                                                              |");
                System.out.println("|                                                       2. Start Adventure.                                                          |");
                System.out.println("|                                                       3. Show all Heroes.                                                          |");
                System.out.println("|                                                       4. Remove Hero.                                                              |");
                System.out.println("|                                                       0. Exit.                                                                     |");
                System.out.println("|                                                                                                                                    |");
                System.out.println("======================================================================================================================================");
                System.out.print("Please make a choice: ");

                int selector = Integer.parseInt(scanner.nextLine());

                if (selector == 0) {
                    System.out.println("**************************************");
                    System.out.println("Have a nice day! Comeback later!");
                    break;
                } else {
                    executeUIAction(selector);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void executeUIAction(int selector) {
        if (selector != 0) {
            switch (selector) {
                case 1:
                    createHeroUIAction.execute();
                    break;
                case 2:
                    startAdventureUIAction.execute();
                    break;
                case 3:
                    showAllHeroUIAction.execute();
                    break;
                case 4:
                    deleteByIdUIAction.execute();
                    break;
            }
        } else {
            System.out.println("Please select actions from the list, not like you: " + selector);
        }
    }


}


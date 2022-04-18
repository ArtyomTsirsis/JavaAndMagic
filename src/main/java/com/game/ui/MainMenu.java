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
    private StartAdventureUIAction startAdventureUIAction;

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

                System.out.println();
                System.out.println("======================================================================================================================================");
                System.out.println("|                                                          MAIN MENU                                                                 |");
                System.out.println("======================================================================================================================================");
                System.out.println("|                                                                                                                                    |");
                System.out.println("|                                                       1. Start Adventure.                                                          |");
                System.out.println("|                                                       0. Exit.                                                                     |");
                System.out.println("|                                                                                                                                    |");
                System.out.println("======================================================================================================================================");
                System.out.print("Please make a choice ⮞ ");

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
                    startAdventureUIAction.execute();
                    break;
            }
        } else {
            System.out.println("Please select actions from the list, not like you: " + selector);
        }
    }
}


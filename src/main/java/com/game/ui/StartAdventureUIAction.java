package com.game.ui;

import com.game.core.StartAdventureService;
import com.game.reposervices.hero.FindAllHeroesService;
import com.game.repository.hero.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Scanner;

@Component
public class StartAdventureUIAction implements UIAction {

    // UI Dependency
    @Autowired
    private CreateHeroUIAction createHeroUIAction;
    @Autowired
    private MainMenu mainMenu;
    @Autowired
    private ShowAllHeroUIAction showAllHeroUIAction;
    @Autowired
    private DeleteByIdUIAction deleteByIdUIAction;

    @Override
    public void execute() {

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
                System.out.println("|                                                        START ADVENTURE                                                             |");
                System.out.println("======================================================================================================================================");
                System.out.println("|                                                                                                                                    |");
                System.out.println("|                                                       1. Create Hero.                                                              |");
                System.out.println("|                                                       2. Show all Heroes.                                                          |");
                System.out.println("|                                                       3. Remove Hero.                                                              |");
                System.out.println("|                                                       0. BACK                                                                      |");
                System.out.println("|                                                                                                                                    |");
                System.out.println("======================================================================================================================================");
                System.out.print("Please make a choice ⮞ ");

                int selector = Integer.parseInt(scanner.nextLine());

                if (selector == 0) {
                    System.out.println("**************************************");
                    System.out.println("Back to MAIN MENU...");
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
                    showAllHeroUIAction.execute();
                    break;
                case 3:
                    deleteByIdUIAction.execute();
                    break;
                case 4:
                    mainMenu.run();
                    break;
            }
        } else {
            System.out.println("Please select actions from the list, not like you: " + selector);
        }
    }

}



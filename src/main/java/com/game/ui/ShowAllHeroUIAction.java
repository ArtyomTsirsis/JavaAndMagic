package com.game.ui;

import com.game.reposervices.hero.CreateHeroService;
import com.game.reposervices.hero.FindAllHeroesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ShowAllHeroUIAction implements UIAction {

    // UI Dependency
    @Autowired
    private FindAllHeroesService findAllHeroesService;
    @Autowired
    private CreateHeroUIAction createHeroUIAction;

    public void execute() {

        var findAll = findAllHeroesService.findAll();
        if (findAll.getHeroes().isEmpty()) {
            emptyList();
        } else {
            getList();
        }
    }

    public void emptyList() {

        var scanner = new Scanner(System.in);


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
        System.out.println("|                                                          ALL HEROES                                                                |");
        System.out.println("======================================================================================================================================");
        System.out.println("|`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,``,`,`,`,`,`,`,`,`,`,`,`|");
        System.out.println("|`,`                                                                                                                              `,`|");
        System.out.println("|`,`                                                                             .-.                                              `,`|");
        System.out.println("|`,`                                                      NO ONE IS HERE,       (o o) boo!                                        `,`|");
        System.out.println("|`,`                                                    HMM VERY STRANGE...     | O \\                                             `,`|");
        System.out.println("|`,`                                                                             \\   \\                                            `,`|");
        System.out.println("|`,`                                                                              `~~~'                                           `,`|");
        System.out.println("|`,`                                                                                                                              `,`|");
        System.out.println("|`,`                                                       1. Create Hero.                                                        `,`|");
        System.out.println("|`,`                                                       0. BACK                                                                `,`|");
        System.out.println("|`,`                                                                                                                              `,`|");
        System.out.println("|`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,``,`,`,`,`,`,`,`,`,`,`,`|");
        System.out.println("======================================================================================================================================");
        System.out.print("Please make a choice ⮞ ");

        int selector = Integer.parseInt(scanner.nextLine());

        if (selector == 0) {
            System.out.println("**************************************");
            System.out.println("Back to START ADVENTURE MENU...");
        } else {
            executeUIAction(selector);
        }

    }

    private void executeUIAction(int selector) {
        if (selector != 0) {
            switch (selector) {
                case 1:
                    createHeroUIAction.execute();
                    break;
            }
        } else {
            System.out.println("Please select actions from the list, not like you: " + selector);
        }
    }

    public void getList() {

        var border = new String(" ");
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
                System.out.println("|                                                        ALL HEROES                                                                  |");
                System.out.println("======================================================================================================================================");
                System.out.println("|`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,``,`,`,`,`,`,`,`,`,`,`,`|");
                System.out.println("|`,`                                                                                                                              `,`|");
                var response = findAllHeroesService.findAll();
                response.getHeroes().forEach(heroDTO -> System.out.println("|`,`                                                   Hero name: " + heroDTO.getName() + String
                        .format("%1$" + (64 - heroDTO.getName().length()) + "s", border) + "`,`|"));
                System.out.println("|`,`                                                                                                                              `,`|");
                System.out.println("|`,`                                                       0. BACK                                                                `,`|");
                System.out.println("|`,`                                                                                                                              `,`|");
                System.out.println("|`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,``,`,`,`,`,`,`,`,`,`,`,`|");
                System.out.println("======================================================================================================================================");
                System.out.print("Please make a choice ⮞ ");

                int selector = Integer.parseInt(scanner.nextLine());

                if (selector == 0) {
                    System.out.println("**************************************");
                    System.out.println("Back to START ADVENTURE MENU...");
                    break;
                } else {
                    System.out.println("Please select actions from the list, not like you: " + selector);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}

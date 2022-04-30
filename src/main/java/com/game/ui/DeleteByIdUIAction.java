package com.game.ui;

import java.rmi.NoSuchObjectException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.game.reposervices.hero.DeleteHeroByNameService;
import com.game.reposervices.hero.FindAllHeroesService;
import com.game.reposervices.hero.FindHeroByNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.stream.IntStream;

@Component
public class DeleteByIdUIAction implements UIAction {

    // UI Dependency
    @Autowired
    private FindAllHeroesService findAllHeroesService;
    @Autowired
    private CreateHeroUIAction createHeroUIAction;
    @Autowired
    private DeleteHeroByNameService deleteHeroByNameService;

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


        while (true) {

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
            System.out.println("|                                                          REMOVE HERO                                                               |");
            System.out.println("======================================================================================================================================");
            System.out.println("|`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,``,`,`,`,`,`,`,`,`,`,`,`|");
            System.out.println("|`,`                 __.-/|                                                                                                       `,`|");
            System.out.println("|`,`                 \\`o_O'                                                                                                       `,`|");
            System.out.println("|`,`                  =( )=  +----------------------------+                                                                       `,`|");
            System.out.println("|`,`                    U|   | OOOUPS...NOTHING TO REMOVE |                                                                       `,`|");
            System.out.println("|`,`         / \\ / \\   / |   +----------------------------+                                                                       `,`|");
            System.out.println("|`,`         ) /^\\) ^\\/ _)\\     |                                                                                                 `,`|");
            System.out.println("|`,`         )   /^\\/   _) \\    |                                                                                                 `,`|");
            System.out.println("|`,`         )   _ /  / _)  \\___|_                                                                                                `,`|");
            System.out.println("|`,`    / \\  )/\\/ ||  | )_)\\___,|))                                                                                               `,`|");
            System.out.println("|`,`   <  >      |(,,) )__)    |                                                                                                  `,`|");
            System.out.println("|`,`    ||      /    \\)___)\\                                                                                                      `,`|");
            System.out.println("|`,`    | \\____(      )___) )____                           0. BACK                                                               `,`|");
            System.out.println("|`,`     \\______(_______;;;)__;;;)                                                                                                `,`|");
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
        }

    }


    public void getList() {

        var border = new String(" ");
        var scanner = new Scanner(System.in);

        while (true) {
            try {

                var response = findAllHeroesService.findAll();
                var heroList = response.getHeroes().toArray();
                int length = heroList.length;
                if (length == 0) {
                    emptyList();
                    break;
                } else {
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
                    System.out.println("|                                                        REMOVE HERO                                                                 |");
                    System.out.println("======================================================================================================================================");
                    System.out.println("|`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,``,`,`,`,`,`,`,`,`,`,`,`|");
                    System.out.println("|`,`                                                                                                                              `,`|");
                    System.out.println("|`,`                                            ENTER NUMBER TO REMOVE A HERO:                                                    `,`|");
                    System.out.println("|`,`                                                                                                                              `,`|");
                    IntStream.range(0, length)
                            .forEach(index -> System.out.println("|`,`                                                   Hero name: " + (index + 1) + " is "
                                    + response.getHeroes().get(index).getName()
                                    + String.format("%1$" + (59 - response.getHeroes().get(index).getName().length()) + "s", border) + "`,`|"));
                    System.out.println("|`,`                                                                                                                              `,`|");
                    System.out.println("|`,`                                                       0. BACK                                                                `,`|");
                    System.out.println("|`,`                                                                                                                              `,`|");
                    System.out.println("|`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,`,``,`,`,`,`,`,`,`,`,`,`,`|");
                    System.out.println("======================================================================================================================================");
                    System.out.print("Please make a choice ⮞ ");
                }

                int selector = Integer.parseInt(scanner.nextLine());

                if (selector == 0) {
                    System.out.println("**************************************");
                    System.out.println("Back to START ADVENTURE MENU...");
                    break;
                } else {
                    var removedHero = response.getHeroes().get(selector - 1).getName();
                    deleteHeroByNameService.deleteByName(removedHero);
                    System.out.println("Received response: " + removedHero + " successfully removed!");
                }
            } catch (Exception e) {
                System.out.println("Please select actions from the list!");
            }
        }
    }
}


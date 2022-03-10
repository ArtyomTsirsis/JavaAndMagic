package ui;

import core.ShowAllHeroService;
import core.StartAdventureService;
import repository.hero.Hero;


import java.util.Scanner;

public class StartAdventureUIAction implements UIAction {


    private StartAdventureService startAdventureService;
    private ShowAllHeroService showAllHeroService;
    private Hero hero;

    public StartAdventureUIAction(StartAdventureService startAdventureService, ShowAllHeroService showAllHeroService) {
        this.startAdventureService = startAdventureService;
        this.showAllHeroService = showAllHeroService;
    }

    @Override
    public void execute() {

        System.out.println("\033[H\033[2J");
        System.out.flush();

        System.out.println("       ,/`|;V\\.;\n" +
                "     ,\\;`~\\,;\\;`\\,\n" +
                "    /;|\\_|,\\~/`,\\/;,\n" +
                "   `\\`/;`\\,`;`|;\\`\\'\n" +
                "   ;|V`,;'|'/'`/'/|\\\n" +
                "   `/;'|`\\V'/;\\,\\_V/\n" +
                "    `;|\\, |;`,_|_,'\n" +
                "       `,`\\_\\/;'\n" +
                "          \\;`/     _____________\n" +
                "         \\\\| |    |  WARNING!   |\n" +
                "        _oo| |    | UNSAFE AREA!|\n" +
                "        `\\.| |    |_____________|\n" +
                " ---....__/  `\\,____  |    |\n" +
                "      _,-'     `-   \"\"|---.|...\n" +
                "                                   ");


        System.out.print("                Now I am ready for that dragon!\n" +
                "                      I have a horse and armour!\n" +
                "             ,      ,  /\n" +
                "        ____/~\\    ~O\n" +
                "    ,;~( )_  )'' /~()'-{---\n" +
                "       )/  |(     /~)\n" +
                "       ~    ~     ~ ~");

        System.out.println("\033[H\033[2J");
        System.out.flush();

        Scanner sc = new Scanner(System.in);
        System.out.println("**************************************");
        System.out.println("Available heroes: ");
        showAllHeroService.findAll().forEach(hero -> {
            System.out.println("----> " + hero.getName() + " (" + hero.getHeroClass() + ")");
        });
        System.out.println();
        System.out.print("Please type a name: ");
        String name = sc.nextLine();
        // Спрашиваем направление у пользователя
        System.out.println("**************************************");

        System.out.println("Where we go " + name + "?: ");
        System.out.println();
        System.out.println("1) Only forward - adventure awaits!");
        System.out.println("2) Turn left - looks quieter.");
        System.out.println("3) Turn right - a large mountain is in sight.");
        System.out.println();
        System.out.print("What's your choice?: ");

        int input = Integer.parseInt(sc.nextLine());
        switch (input) {
            case 1 -> startAdventureService.moveForward(name);
            case 2 -> startAdventureService.moveLeft(name);
            case 3 -> startAdventureService.moveRight(name);

            default -> System.out.println("Please make a choice between 1 and 3.");
        }

    }

}



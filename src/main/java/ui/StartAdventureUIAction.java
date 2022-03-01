package ui;

import core.CreateHeroService;
import core.StartAdventureService;
import repository.hero.Hero;
import repository.hero.HeroClass;
import repository.hero.HeroFactory;

import java.util.Scanner;

public class StartAdventureUIAction implements UIAction {


    private StartAdventureService startAdventureService;
    private Hero hero;

    public StartAdventureUIAction(StartAdventureService startAdventureService) {
        this.startAdventureService = startAdventureService;
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
        System.out.println("Каким героем отправимся в путь?:");
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
            case 1 -> startAdventureService.startAdventure(name);

            default -> {
            }
        }

    }

}

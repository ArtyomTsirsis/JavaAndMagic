package com.game.ui;

import com.game.dto.hero.CreateHeroRequest;
import com.game.reposervices.hero.CreateHeroService;
import com.game.repository.hero.HeroClass;
import com.game.repository.hero.HeroFactory;
import org.springframework.stereotype.Component;


import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.Scanner;

@Component
public class CreateHeroUIAction implements UIAction {

    private CreateHeroService createHeroService;
    private HeroClass heroClass;
    private String heroName;

    public CreateHeroUIAction(CreateHeroService createHeroService) {
        this.createHeroService = createHeroService;
    }

    public void execute() {

        System.out.println("\033[H\033[2J");
        System.out.flush();
        // запрашиваем данные о герое с консоли у пользолвателя (пока только имя и класс =))
        Scanner sc = new Scanner(System.in);
        System.out.print("Please, enter Hero name: ");
        heroName = sc.nextLine();

        System.out.println("**************************************");
        System.out.println("We made a simple four classes!");
        System.out.println();
        System.out.println("1) Archer. (accurate shooter, use a bow like a main weapon.)");
        System.out.println("2) Knight. (Dressed in shiny armor, with a two-handed sword.)");
        System.out.println("3) Wizard. (A hooded robe hides his 'dark' eyes as night.)");
        System.out.println("4) Thief. (Thunderstorm marketplaces, take care of your wallets! Armed with 2 daggers.)");
        System.out.println();
        System.out.print("What your choice?: ");


        int selector = Integer.parseInt(sc.nextLine());
        switch (selector) {
            case 1 -> heroClass = HeroClass.ARCHER;
            case 2 -> heroClass = HeroClass.KNIGHT;
            case 3 -> heroClass = HeroClass.WIZARD;
            case 4 -> heroClass = HeroClass.THIEF;
            default -> System.out.println("Please make a choice between 1 and 4.");
        }

        // сохранение его в базу данных

        var request = new CreateHeroRequest();
        request.setHeroClass(heroClass);
        request.setName(heroName);
        try {
            var response = createHeroService.createHero(request);
            System.out.println("Received response: " + response.getHero().getName() + " Successfully created.");
        } catch (KeyAlreadyExistsException ex) {
            System.out.println("Received response: Hero with this name already exist!");
        }
    }

}

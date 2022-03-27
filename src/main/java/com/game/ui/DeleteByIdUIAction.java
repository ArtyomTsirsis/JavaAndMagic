package com.game.ui;

import java.util.Scanner;

import com.game.reposervices.hero.DeleteHeroByNameService;
import com.game.reposervices.hero.FindAllHeroesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteByIdUIAction implements UIAction {

    @Autowired
    private FindAllHeroesService showAllHeroService;
    @Autowired
    private DeleteHeroByNameService deleteByIdService;
    String heroName;

    public void execute() {

        System.out.println("\033[H\033[2J");
        System.out.flush();

        // вывод всех героев из базы данных:
        showAllHeroService.findAll();

        // запрашиваем имя героя с консоли у пользолвателя
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter hero name, what you want to remove: ");
        heroName = sc.nextLine();

        // поиск героя в базе данных и удаление:
        deleteByIdService.deleteByName(heroName);

        System.out.println("**************************************");

    }



}

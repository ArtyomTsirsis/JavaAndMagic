package com.game.ui;

import java.rmi.NoSuchObjectException;
import java.util.Scanner;

import com.game.reposervices.hero.DeleteHeroByNameService;
import com.game.reposervices.hero.FindAllHeroesService;
import com.game.reposervices.hero.FindHeroByNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.openmbean.KeyAlreadyExistsException;

@Component
public class DeleteByIdUIAction implements UIAction {

    @Autowired
    private FindAllHeroesService findAllHeroesService;
    @Autowired
    private FindHeroByNameService findHeroByNameService;
    @Autowired
    private DeleteHeroByNameService deleteByIdService;
    String heroName;

    public void execute() {

        System.out.println("\033[H\033[2J");
        System.out.flush();

        // вывод всех героев из базы данных:
        var response = findAllHeroesService.findAll();
        response.getHeroes().forEach(heroDTO -> System.out.println("Hero name: " + heroDTO.getName()));
        System.out.println("**************************************");

        // запрашиваем имя героя с консоли у пользолвателя
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter hero name, what you want to remove: ");
        heroName = sc.nextLine();

        // поиск героя в базе данных и удаление:
        try {
            var checkIfHeroExist = findHeroByNameService.findByName(heroName);
            deleteByIdService.deleteByName(heroName);
            System.out.println("Received response: " + checkIfHeroExist.getHero().getName() + " Successfully removed!");
        } catch (NoSuchObjectException ex) {
            System.out.println("Received response: Hero with this name doesn't exist!");
        }
        System.out.println("**************************************");

    }



}

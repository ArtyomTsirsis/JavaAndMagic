package com.game.ui;

import com.game.reposervices.hero.FindAllHeroesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShowAllHeroUIAction implements UIAction {

    @Autowired
    private FindAllHeroesService findAllHeroesService;

    public void execute() {

        System.out.println("\033[H\033[2J");
        System.out.flush();

        // выводим на консоль результаты поиска

        var response = findAllHeroesService.findAll();
        response.getHeroes().forEach(heroDTO -> System.out.println("Hero name: " + heroDTO.getName()));
        System.out.println("**************************************");



    }


}

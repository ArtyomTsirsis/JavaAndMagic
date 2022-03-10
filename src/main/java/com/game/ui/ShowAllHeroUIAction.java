package com.game.ui;

import com.game.core.ShowAllHeroService;

public class ShowAllHeroUIAction implements UIAction {

    private ShowAllHeroService showAllHeroService;

    public ShowAllHeroUIAction(ShowAllHeroService showAllHeroService) {
        this.showAllHeroService = showAllHeroService;
    }

    public void execute() {

        System.out.println("\033[H\033[2J");
        System.out.flush();

        // выводим на консоль результаты поиска

        showAllHeroService.findAll().forEach(System.out::println);

        System.out.println("**************************************");

    }


}

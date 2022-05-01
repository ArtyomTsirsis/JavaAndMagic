package com.game.core;

import com.game.dto.hero.HeroDTO;
import com.game.repository.enemy.Orc;
import org.springframework.stereotype.Service;

@Service
public class StartAdventureService {

    private HeroDTO startAdventureHero;
    private Boolean choice;

    public HeroDTO setHero(HeroDTO hero) {
        startAdventureHero = hero;
        return hero;
    }

    public String start() {
        var orc = new Orc();
        choice = false;
        if (choice == true) {
            return "You are coward! Comeback!";
        } else {
            //var result = battleService.start(startAdventureHero,orc);
            return "Nice PvE! ";
        }

    }


}

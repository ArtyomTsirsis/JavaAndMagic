package com.game.core.adventure;

import com.game.dto.hero.HeroDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class Chapter1 {

    @Autowired
    AdventureProgressStatusService adventureProgressStatusService;

    private HeroDTO hero;

    public AdventureResponse startAdventure(AdventureRequest request) {
        if (startAdventureHeroIsEmpty()) {
            System.out.println("YOU ARE CONTINUE THE ADVENTURE");
            var response = new AdventureResponse();
            response.setHero(adventureProgressStatusService.getHero());
            return response;
        } else {
            System.out.println("NEW ADVENTURE BEGIN!");
            var response = new AdventureResponse();
            hero = request.getHero();
            adventureProgressStatusService.setHero(hero);
            response.setHero(hero);
            return response;
        }
    }

    private boolean startAdventureHeroIsEmpty() {
        if (adventureProgressStatusService.getHero() != null) {
            return true;
        } else {
            return false;
        }
    }

}

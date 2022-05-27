package com.game.core.adventure;

import com.game.dto.adventure.AdventureRequest;
import com.game.dto.adventure.AdventureResponse;
import com.game.dto.hero.HeroDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class Chapter2 {

    @Autowired
    AdventureProgressStatusContext adventureProgressStatusContext;

    private HeroDTO hero;
    private String move;

    public AdventureResponse startAdventure(AdventureRequest request) {
        if (startAdventureHeroIsEmpty() && startAdventureSelectedMoveIsEmpty()) {
            System.out.println("YOU ARE CONTINUE THE CHAPTER2");
            var response = new AdventureResponse();
            response.setHero(adventureProgressStatusContext.getHero());
            response.setMove(adventureProgressStatusContext.getMove());
            return response;
        } else {
            System.out.println("CHAPTER2 BEGIN!");
            var response = new AdventureResponse();
            move = request.getMove();
            hero = request.getHero();
            adventureProgressStatusContext.setHero(hero);
            adventureProgressStatusContext.setMove(move);
            response.setHero(hero);
            response.setMove(move);
            return response;
        }
    }

    private boolean startAdventureHeroIsEmpty() {
        if (adventureProgressStatusContext.getHero() != null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean startAdventureSelectedMoveIsEmpty() {
        if (adventureProgressStatusContext.getMove() != null) {
            return true;
        } else {
            return false;
        }
    }
}

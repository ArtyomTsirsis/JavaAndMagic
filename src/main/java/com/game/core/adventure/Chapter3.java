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
public class Chapter3 {

    @Autowired
    AdventureProgressStatusContext adventureProgressStatusContext;

    private HeroDTO hero;
    private String move;
    private Boolean fightChoice;

    public AdventureResponse startAdventure(AdventureRequest request) {
        if (startAdventureHeroIsEmpty() && startAdventureSelectedMoveIsEmpty() && startAdventureFightChoiceIsEmpty()) {
            System.out.println("YOU ARE CONTINUE THE CHAPTER3");
            var response = new AdventureResponse();
            response.setHero(adventureProgressStatusContext.getHero());
            response.setMove(adventureProgressStatusContext.getMove());
            response.setFightChoice(adventureProgressStatusContext.getFightChoice());
            return response;
        } else {
            System.out.println("CHAPTER3 BEGIN!");
            var response = new AdventureResponse();
            move = request.getMove();
            hero = request.getHero();
            fightChoice = request.getFightChoice();
            adventureProgressStatusContext.setHero(hero);
            adventureProgressStatusContext.setMove(move);
            adventureProgressStatusContext.setFightChoice(fightChoice);
            response.setHero(hero);
            response.setMove(move);
            response.setFightChoice(fightChoice);
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

    private boolean startAdventureFightChoiceIsEmpty() {
        if (adventureProgressStatusContext.getFightChoice() != null) {
            return true;
        } else {
            return false;
        }
    }

}

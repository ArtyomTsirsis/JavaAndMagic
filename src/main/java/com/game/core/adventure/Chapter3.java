package com.game.core.adventure;

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
    AdventureProgressStatusService adventureProgressStatusService;

    private HeroDTO hero;
    private String move;
    private Boolean fightChoice;

    public AdventureResponse startAdventure(AdventureRequest request) {
        if (startAdventureHeroIsEmpty() && startAdventureSelectedMoveIsEmpty() && startAdventureFightChoiceIsEmpty()) {
            System.out.println("YOU ARE CONTINUE THE CHAPTER3");
            var response = new AdventureResponse();
            response.setHero(adventureProgressStatusService.getHero());
            response.setMove(adventureProgressStatusService.getMove());
            response.setFightChoice(adventureProgressStatusService.getFightChoice());
            return response;
        } else {
            System.out.println("CHAPTER3 BEGIN!");
            var response = new AdventureResponse();
            move = request.getMove();
            hero = request.getHero();
            fightChoice = request.getFightChoice();
            adventureProgressStatusService.setHero(hero);
            adventureProgressStatusService.setMove(move);
            adventureProgressStatusService.setFightChoice(fightChoice);
            response.setHero(hero);
            response.setMove(move);
            response.setFightChoice(fightChoice);
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

    private boolean startAdventureSelectedMoveIsEmpty() {
        if (adventureProgressStatusService.getMove() != null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean startAdventureFightChoiceIsEmpty() {
        if (adventureProgressStatusService.getFightChoice() != null) {
            return true;
        } else {
            return false;
        }
    }

}

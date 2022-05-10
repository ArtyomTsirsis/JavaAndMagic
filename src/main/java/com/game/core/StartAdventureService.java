package com.game.core;

import com.game.dto.hero.HeroDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class StartAdventureService {

    @Autowired
    AdventureProgressStatusService adventureProgressStatusService;

    private HeroDTO hero;
    private String move;
    private Boolean fightChoice;

    public AdventureResponse startAdventureChapter1 (AdventureRequest request) {
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

    public AdventureResponse startAdventureChapter2 (AdventureRequest request) {
        if (startAdventureHeroIsEmpty() && startAdventureSelectedMoveIsEmpty()) {
            System.out.println("YOU ARE CONTINUE THE CHAPTER2");
            var response = new AdventureResponse();
            response.setHero(adventureProgressStatusService.getHero());
            response.setMove(adventureProgressStatusService.getMove());
            return response;
        } else {
            System.out.println("CHAPTER2 BEGIN!");
            var response = new AdventureResponse();
            move = request.getMove();
            hero = request.getHero();
            adventureProgressStatusService.setHero(hero);
            adventureProgressStatusService.setMove(move);
            response.setHero(hero);
            response.setMove(move);
            return response;
        }
    }

    public AdventureResponse startAdventureChapter3 (AdventureRequest request) {
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

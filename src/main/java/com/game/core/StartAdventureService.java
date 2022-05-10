package com.game.core;

import com.game.dto.hero.HeroDTO;
import com.game.repository.enemy.Enemy;
import com.game.skills.enemy.EnemySkill;
import com.game.skills.hero.HeroSkill;
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
    private Enemy enemy;
    private HeroSkill heroSkill;
    private EnemySkill enemySkill;

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

    public AdventureResponse startAdventureChapter4 (AdventureRequest request) {
        if (startAdventureHeroIsEmpty() && startAdventureSelectedMoveIsEmpty() && startAdventureFightChoiceIsEmpty() && startAdventureEnemyOnTheWayIsEmpty()) {
            System.out.println("YOU ARE CONTINUE THE CHAPTER4");
            var response = new AdventureResponse();
            response.setHero(adventureProgressStatusService.getHero());
            response.setMove(adventureProgressStatusService.getMove());
            response.setFightChoice(adventureProgressStatusService.getFightChoice());
            response.setEnemy(adventureProgressStatusService.getEnemy());
            response.setHeroSkill(adventureProgressStatusService.getHeroSkill());
            response.setEnemySkill(adventureProgressStatusService.getEnemySkill());
            return response;
        } else {
            System.out.println("CHAPTER4 BEGIN!");
            var response = new AdventureResponse();
            move = request.getMove();
            hero = request.getHero();
            enemy = request.getEnemy();
            fightChoice = request.getFightChoice();
            heroSkill = request.getHeroSkill();
            enemySkill = request.getEnemySkill();
            adventureProgressStatusService.setHero(hero);
            adventureProgressStatusService.setMove(move);
            adventureProgressStatusService.setFightChoice(fightChoice);
            adventureProgressStatusService.setEnemy(enemy);
            adventureProgressStatusService.setHeroSkill(heroSkill);
            adventureProgressStatusService.setEnemySkill(enemySkill);
            response.setHero(hero);
            response.setMove(move);
            response.setFightChoice(fightChoice);
            response.setEnemy(enemy);
            response.setHeroSkill(heroSkill);
            response.setEnemySkill(enemySkill);
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

    private boolean startAdventureEnemyOnTheWayIsEmpty() {
        if (adventureProgressStatusService.getEnemy() != null) {
            return true;
        } else {
            return false;
        }
    }

}

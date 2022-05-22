package com.game.core;

import com.game.dto.hero.HeroDTO;
import com.game.repository.enemy.Enemy;
import com.game.skills.enemy.EnemySkill;
import com.game.skills.hero.HeroSkill;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class Chapter4 {

    @Autowired
    AdventureProgressStatusService adventureProgressStatusService;

    private HeroDTO hero;
    private String move;
    private Boolean fightChoice;
    private Enemy enemy;
    private HeroSkill heroSkill;
    private EnemySkill enemySkill;

    public AdventureResponse startAdventure(AdventureRequest request) {
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

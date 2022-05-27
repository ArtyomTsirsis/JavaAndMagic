package com.game.core.adventure;

import com.game.dto.adventure.AdventureRequest;
import com.game.dto.adventure.AdventureResponse;
import com.game.dto.hero.HeroDTO;
import com.game.domain.enemy.Enemy;
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
    AdventureProgressStatusContext adventureProgressStatusContext;

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
            response.setHero(adventureProgressStatusContext.getHero());
            response.setMove(adventureProgressStatusContext.getMove());
            response.setFightChoice(adventureProgressStatusContext.getFightChoice());
            response.setEnemy(adventureProgressStatusContext.getEnemy());
            response.setHeroSkill(adventureProgressStatusContext.getHeroSkill());
            response.setEnemySkill(adventureProgressStatusContext.getEnemySkill());
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
            adventureProgressStatusContext.setHero(hero);
            adventureProgressStatusContext.setMove(move);
            adventureProgressStatusContext.setFightChoice(fightChoice);
            adventureProgressStatusContext.setEnemy(enemy);
            adventureProgressStatusContext.setHeroSkill(heroSkill);
            adventureProgressStatusContext.setEnemySkill(enemySkill);
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

    private boolean startAdventureEnemyOnTheWayIsEmpty() {
        if (adventureProgressStatusContext.getEnemy() != null) {
            return true;
        } else {
            return false;
        }
    }

}

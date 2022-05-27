package com.game.core.adventure;

import com.game.dto.adventure.AdventureRequest;
import com.game.dto.adventure.AdventureResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ChapterSelectorService {

    @Autowired
    private Chapter1 chapter1;
    @Autowired
    private Chapter2 chapter2;
    @Autowired
    private Chapter3 chapter3;
    @Autowired
    private Chapter4 chapter4;

    public AdventureResponse selector(Integer id, AdventureRequest request) {
        var chapterId = id;
        switch (chapterId) {
            case 1 -> chapter1.startAdventure(request);
            case 2 -> chapter2.startAdventure(request);
            case 3 -> chapter3.startAdventure(request);
            case 4 -> chapter4.startAdventure(request);
        }
        var response = new AdventureResponse();
        response.setHero(request.getHero());
        response.setMove(request.getMove());
        response.setFightChoice(request.getFightChoice());
        response.setEnemy(request.getEnemy());
        response.setHeroSkill(request.getHeroSkill());
        response.setEnemySkill(request.getEnemySkill());
        return response;
    }

}

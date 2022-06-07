package com.game.core.adventure;

import com.game.dto.adventure.AdventureRequest;
import com.game.dto.adventure.AdventureResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Chapter2 {


    public AdventureResponse startAdventure(AdventureRequest request) {
        var response = new AdventureResponse();
        response.setHero(request.getHero());
        response.setMove(request.getMove());
        response.setAdventureDescription("A [ " + request.getHero().getName() + " ] goes to his first quest." +
                " And he chose a that good path [ " + request.getMove() + " ]");
        return response;


    }

}

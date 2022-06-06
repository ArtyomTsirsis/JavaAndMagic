package com.game.core.adventure;

import com.game.dto.adventure.AdventureRequest;
import com.game.dto.adventure.AdventureResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Chapter1 {


    public AdventureResponse startAdventure(AdventureRequest request) {
        var response = new AdventureResponse();
        response.setHero(request.getHero());
        response.setAdventureDescription(" A strong hero " + request.getHero().getName() + " ! You start a Adventure!");
        return response;


    }


}

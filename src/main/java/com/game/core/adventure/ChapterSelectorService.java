package com.game.core.adventure;

import com.game.dto.adventure.AdventureRequest;
import com.game.dto.adventure.AdventureResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChapterSelectorService {


    private final Chapter1 chapter1;

    private final Chapter2 chapter2;

    private final Chapter3 chapter3;

    private final Chapter4 chapter4;

    public AdventureResponse selector(Integer id, AdventureRequest request) {
        return switch (id) {
            case 1 -> chapter1.startAdventure(request);
            case 2 -> chapter2.startAdventure(request);
            case 3 -> chapter3.startAdventure(request);
            case 4 -> chapter4.startAdventure(request);
            default -> chapter1.startAdventure(request);
        };
    }

}

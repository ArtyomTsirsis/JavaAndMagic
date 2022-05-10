package com.game.controller;

import com.game.core.AdventureRequest;
import com.game.core.AdventureResponse;
import com.game.core.StartAdventureService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.NoSuchObjectException;

@RestController
@RequestMapping("/adventure")
@RequiredArgsConstructor
public class AdventureController {

    @Autowired
    private StartAdventureService startAdventureService;

    @PutMapping("/chapter1")
    public AdventureResponse startAdventureChapter1(@RequestBody AdventureRequest request) {
        return startAdventureService.startAdventureChapter1(request);
    }

    @PutMapping("/chapter2")
    public AdventureResponse startAdventureChapter2(@RequestBody AdventureRequest request) {
        return startAdventureService.startAdventureChapter2(request);
    }

    @PutMapping("/chapter3")
    public AdventureResponse startAdventureChapter3(@RequestBody AdventureRequest request) {
        return startAdventureService.startAdventureChapter3(request);
    }


}

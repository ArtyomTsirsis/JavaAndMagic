package com.game.controller;

import com.game.core.StartAdventureService;
import com.game.dto.hero.FindHeroByIdResponse;
import com.game.dto.hero.HeroDTO;
import com.game.reposervices.hero.FindHeroByNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.NoSuchObjectException;

@RestController
@RequestMapping("/adventure")
@RequiredArgsConstructor
public class AdventureController {

    @Autowired
    private FindHeroByNameService findHeroByNameService;
    @Autowired
    private StartAdventureService startAdventureService;

    @GetMapping(value = "/setHero/{name}")
    public HeroDTO getHero(@PathVariable String name) throws NoSuchObjectException {
        var findHero = findHeroByNameService.findByName(name);
        var startAdventureHero = startAdventureService.setHero(findHero.getHero());
        return startAdventureHero;
    }





}

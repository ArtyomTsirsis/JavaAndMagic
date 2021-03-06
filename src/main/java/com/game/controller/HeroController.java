package com.game.controller;

import com.game.core.repo.hero.CreateHeroService;
import com.game.core.repo.hero.DeleteHeroByNameService;
import com.game.core.repo.hero.FindAllHeroesService;
import com.game.core.repo.hero.FindHeroByNameService;
import com.game.dto.hero.CreateHeroRequest;
import com.game.dto.hero.CreateHeroResponse;
import com.game.dto.hero.FindAllHeroesResponse;
import com.game.dto.hero.FindHeroByIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.rmi.NoSuchObjectException;

@RestController
@RequestMapping("/hero")
@RequiredArgsConstructor
public class HeroController {

    private final CreateHeroService createHeroService;
    private final FindHeroByNameService findHeroByNameService;
    private final FindAllHeroesService findAllHeroesService;
    private final DeleteHeroByNameService deleteHeroByNameService;

    @PostMapping(value = "/")
    public CreateHeroResponse createHero(@RequestBody @Valid CreateHeroRequest request) {
        return createHeroService.createHero(request);
    }

    @GetMapping(value = "/{name}")
    public FindHeroByIdResponse getHero(@PathVariable String name) throws NoSuchObjectException {
        return findHeroByNameService.findByName(name);
    }

    @DeleteMapping(value = "/{name}")
    public void deleteHero(@PathVariable String name) throws NoSuchObjectException {
        deleteHeroByNameService.deleteByName(name);
    }

    @GetMapping(value = "/")
    public FindAllHeroesResponse findAllHeroes() {
        return findAllHeroesService.findAll();
    }

}

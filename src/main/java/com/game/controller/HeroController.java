package com.game.controller;

import com.game.dto.armor.CreateArmorRequest;
import com.game.dto.armor.FindArmorByIdResponse;
import com.game.dto.hero.CreateHeroRequest;
import com.game.dto.hero.FindAllHeroesResponse;
import com.game.dto.hero.FindHeroByIdResponse;
import com.game.dto.hero.HeroDTO;
import com.game.reposervices.armor.CreateArmorService;
import com.game.reposervices.armor.FindArmorByIDService;
import com.game.reposervices.hero.CreateHeroService;
import com.game.reposervices.hero.FindAllHeroesService;
import com.game.reposervices.hero.FindHeroByNameService;
import com.game.repository.armor.ArmorClass;
import com.game.repository.hero.HeroClass;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.NoSuchObjectException;

@RestController
@RequestMapping("/hero")
@RequiredArgsConstructor
public class HeroController {

    private final CreateHeroService createHeroService;
    private final FindHeroByNameService findHeroByNameService;
    private final FindAllHeroesService findAllHeroesService;
    private final CreateArmorService createArmorService;
    private final FindArmorByIDService findArmorByIDService;

    @GetMapping(value = "/hero")
    public void createHero() {
        createHeroService.createHero(new CreateHeroRequest(HeroClass.KNIGHT, "Maxwell"));
    }

    @GetMapping(value = "hero/{name}")
    public FindHeroByIdResponse getArthur(@PathVariable String name) throws NoSuchObjectException {
        return findHeroByNameService.findByName(name);
    }

    @GetMapping(value = "heroes")
    public FindAllHeroesResponse findAllHeroes() {
        return findAllHeroesService.findAll();
    }

    @GetMapping(value = "armor")
    public void createArmor() {
        HeroDTO hero = new HeroDTO();
        hero.setName("Arthur");
        createArmorService.createArmor(new CreateArmorRequest(ArmorClass.WITHOUT_ARMOR, new HeroDTO()));
    }

    @GetMapping(value = "armor/{id}")
    public FindArmorByIdResponse getArmor(@PathVariable Integer id) throws NoSuchObjectException {
        return findArmorByIDService.findByID(id);
    }

}

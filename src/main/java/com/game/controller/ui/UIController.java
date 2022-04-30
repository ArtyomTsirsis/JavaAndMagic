package com.game.controller.ui;

import com.game.dto.hero.CreateHeroRequest;
import com.game.reposervices.hero.CreateHeroService;
import com.game.reposervices.hero.DeleteHeroByNameService;
import com.game.reposervices.hero.FindAllHeroesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@AllArgsConstructor
public class UIController {

    @Autowired
    private FindAllHeroesService findAllHeroesService;
    @Autowired
    private DeleteHeroByNameService deleteHeroByNameService;
    @Autowired
    private CreateHeroService createHeroService;

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/allHeroes")
    public String getAllHeroes(Model model) {
        var response = findAllHeroesService.findAll();
        model.addAttribute("heroes", response.getHeroes());
        return "showAllHeroes";
    }

    @GetMapping("/createHero")
    public String createTaskView(Model model) {
        model.addAttribute("hero", new CreateHeroRequest());
        return "createHero";
    }

    @PostMapping("/createHero")
    public String createTask(@ModelAttribute CreateHeroRequest request) {
        createHeroService.createHero(request);
        return "redirect:/allHeroes";
    }

    @GetMapping("/delete")
    public String deleteHero(@RequestParam String name) {
        try {
            deleteHeroByNameService.deleteByName(name);
            return "redirect:/allHeroes";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

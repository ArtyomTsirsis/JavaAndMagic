package com.game.reposervices.hero;

import com.game.repository.hero.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteHeroByNameService {

    @Autowired
    private HeroRepository repository;

    public void deleteByName(String name) {
        repository.deleteById(name);
    }

}

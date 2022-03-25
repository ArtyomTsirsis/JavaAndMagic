package com.game.reposervices.armor;

import com.game.repository.hero.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteArmorByIDService {

    @Autowired
    private HeroRepository repository;

    public void deleteByName(String name) {
        repository.deleteById(name);
    }

}

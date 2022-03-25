package com.game.reposervices.weapon;

import com.game.repository.hero.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteWeaponByIDService {

    @Autowired
    private HeroRepository repository;

    public void deleteByName(String name) {
        repository.deleteById(name);
    }

}

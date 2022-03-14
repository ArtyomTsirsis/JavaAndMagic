package com.game.repository.services;

import com.game.repository.dto.ConverterToDto;
import com.game.repository.dto.CreateHeroRequest;
import com.game.repository.dto.CreateHeroResponse;
import com.game.repository.hero.Hero;
import com.game.repository.hero.HeroFactory;
import com.game.repository.hero.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.openmbean.KeyAlreadyExistsException;

@Component
public class CreateHeroService {

    @Autowired
    private HeroRepository repository;
    @Autowired
    ConverterToDto converter;

    public CreateHeroResponse hero(CreateHeroRequest request) throws KeyAlreadyExistsException {
        if (repository.findById(request.getName()) != null) {
            throw new KeyAlreadyExistsException();
        }
        Hero hero = HeroFactory.createHero(request.getHeroClass(), request.getName());
        repository.save(hero);
        return new CreateHeroResponse(converter.convertToDto(hero));
    }


}

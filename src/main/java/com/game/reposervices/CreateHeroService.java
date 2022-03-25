package com.game.reposervices;

import com.game.utils.ConverterToDto;
import com.game.dto.CreateHeroRequest;
import com.game.dto.CreateHeroResponse;
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

    public CreateHeroResponse createHero(CreateHeroRequest request) throws KeyAlreadyExistsException {
        if (repository.findById(request.getName()).isPresent()) {
            throw new KeyAlreadyExistsException();
        }
        Hero hero = HeroFactory.createHero(request.getHeroClass(), request.getName());
        repository.save(hero);
        return new CreateHeroResponse(converter.convertToDto(hero));
    }


}

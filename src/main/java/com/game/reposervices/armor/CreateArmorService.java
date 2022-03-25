package com.game.reposervices.armor;

import com.game.dto.hero.CreateHeroRequest;
import com.game.dto.hero.CreateHeroResponse;
import com.game.repository.hero.Hero;
import com.game.repository.hero.HeroFactory;
import com.game.repository.hero.HeroRepository;
import com.game.utils.HeroDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.openmbean.KeyAlreadyExistsException;

@Component
public class CreateArmorService {

    @Autowired
    private HeroRepository repository;
    @Autowired
    HeroDTOConverter converter;

    public CreateHeroResponse createHero(CreateHeroRequest request) throws KeyAlreadyExistsException {
        if (repository.findById(request.getName()).isPresent()) {
            throw new KeyAlreadyExistsException();
        }
        Hero hero = HeroFactory.createHero(request.getHeroClass(), request.getName());
        repository.save(hero);
        return new CreateHeroResponse(converter.convertToDto(hero));
    }


}

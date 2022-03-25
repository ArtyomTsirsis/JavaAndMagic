package com.game.reposervices;

import com.game.dto.FindHeroByIdResponse;
import com.game.repository.hero.Hero;
import com.game.repository.hero.HeroRepository;
import com.game.utils.ConverterToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.rmi.NoSuchObjectException;
import java.util.Optional;

@Component
public class FindHeroByNameService {

    @Autowired
    private HeroRepository repository;
    @Autowired
    private ConverterToDto converter;

    public FindHeroByIdResponse findByName(String name) throws NoSuchObjectException {
        Optional<Hero> hero = repository.findById(name);
        if (hero.isEmpty()) {
            throw new NoSuchObjectException(name);

        }
        return new FindHeroByIdResponse(converter.convertToDto(hero.get()));

    }
}

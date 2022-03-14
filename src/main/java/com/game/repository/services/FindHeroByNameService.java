package com.game.repository.services;

import com.game.repository.dto.ConverterToDto;
import com.game.repository.dto.FindHeroByIdResponse;
import com.game.repository.hero.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindHeroByNameService {

    @Autowired
    private HeroRepository repository;
    @Autowired
    private ConverterToDto converter;

    public FindHeroByIdResponse findByName(String name) {
        return new FindHeroByIdResponse(converter.convertToDto(repository.findById(name)));
    }
}

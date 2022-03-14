package com.game.repository.services;

import com.game.repository.dto.ConverterToDto;
import com.game.repository.dto.FindAllHeroesResponse;
import com.game.repository.hero.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAllHeroesService {

    @Autowired
    private HeroRepository repository;
    @Autowired
    private ConverterToDto converter;

    public FindAllHeroesResponse findAll() {
        return new FindAllHeroesResponse(repository.findAll().stream().map(converter::convertToDto).toList());
    }

}

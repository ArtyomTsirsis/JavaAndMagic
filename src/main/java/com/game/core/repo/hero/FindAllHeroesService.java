package com.game.core.repo.hero;

import com.game.dto.hero.FindAllHeroesResponse;
import com.game.repository.HeroRepository;
import com.game.utils.HeroDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindAllHeroesService {

    private final HeroRepository repository;
    private final HeroDTOConverter converter;

    public FindAllHeroesResponse findAll() {
        return new FindAllHeroesResponse(repository.findAll().stream().map(converter::convertToDto).toList());
    }

}

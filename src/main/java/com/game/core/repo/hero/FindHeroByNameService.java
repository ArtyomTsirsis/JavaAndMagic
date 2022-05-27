package com.game.core.repo.hero;

import com.game.dto.hero.FindHeroByIdResponse;
import com.game.domain.hero.Hero;
import com.game.repository.HeroRepository;
import com.game.utils.HeroDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.rmi.NoSuchObjectException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindHeroByNameService {

    private final HeroRepository repository;
    private final HeroDTOConverter converter;

    public FindHeroByIdResponse findByName(String name) throws NoSuchObjectException {
        Optional<Hero> hero = repository.findById(name);
        if (hero.isEmpty()) {
            throw new NoSuchObjectException(name);
        }
        return new FindHeroByIdResponse(converter.convertToDto(hero.get()));
    }
}
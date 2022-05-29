package com.game.core.repo.hero;

import com.game.domain.hero.Hero;
import com.game.dto.hero.HeroDTO;
import com.game.dto.hero.UpdateHeroRequest;
import com.game.repository.HeroRepository;
import com.game.utils.HeroDTOConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateHeroServiceTest {

    @Mock
    private HeroRepository repository;

    @Mock
    private HeroDTOConverter converter;

    @InjectMocks
    private UpdateHeroService heroService;

    @Test
    void shouldFindHeroByName() {
        when(repository.findById("TEST NAME")).thenReturn(Optional.of(hero()));
        when(converter.convertFromDto(heroDTO())).thenReturn(hero());
        heroService.update(request());
        verify(repository).update(hero());
    }

    private UpdateHeroRequest request() {
        var request = new UpdateHeroRequest();
        request.setUpdatedHeroDTO(heroDTO());
        return request;
    }

    private Hero hero() {
        var hero = new Hero();
        hero.setName("TEST NAME");
        return hero;
    }

    private HeroDTO heroDTO() {
        var heroDto = new HeroDTO();
        heroDto.setName("TEST NAME");
        return heroDto;
    }


}
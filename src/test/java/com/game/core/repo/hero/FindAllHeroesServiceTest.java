package com.game.core.repo.hero;

import com.game.domain.hero.Hero;
import com.game.dto.hero.FindAllHeroesResponse;
import com.game.dto.hero.HeroDTO;
import com.game.repository.HeroRepository;
import com.game.utils.HeroDTOConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindAllHeroesServiceTest {

    @Mock
    private HeroRepository repository;

    @Mock
    private HeroDTOConverter converter;

    @InjectMocks
    private FindAllHeroesService heroService;

    @Test
    void shouldFindAllHeroes() {
        when(repository.findAll()).thenReturn(List.of(new Hero()));
        when(converter.convertToDto(any())).thenReturn(new HeroDTO());
        var result = heroService.findAll();
        verify(repository).findAll();
        var expectedResult = new FindAllHeroesResponse(List.of(new HeroDTO()));
        assertEquals(result, expectedResult);
    }

}
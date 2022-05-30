package com.game.core.repo.hero;

import com.game.domain.hero.Hero;
import com.game.dto.hero.FindHeroByIdResponse;
import com.game.dto.hero.HeroDTO;
import com.game.repository.HeroRepository;
import com.game.utils.HeroDTOConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.rmi.NoSuchObjectException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindHeroByNameServiceTest {

    @Mock
    private HeroRepository repository;

    @Mock
    private HeroDTOConverter converter;

    @InjectMocks
    private FindHeroByNameService heroService;

    @Test
    void shouldFindHeroByName() throws NoSuchObjectException {
        when(repository.findById("TEST NAME")).thenReturn(Optional.of(new Hero()));
        when(converter.convertToDto(any())).thenReturn(new HeroDTO());
        var result = heroService.findByName("TEST NAME");
        verify(repository).findById("TEST NAME");
        var expectedResult = new FindHeroByIdResponse(new HeroDTO());
        assertEquals(result, expectedResult);
    }

}
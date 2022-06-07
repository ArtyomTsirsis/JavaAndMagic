package com.game.core.repo.hero;

import com.game.core.repo.armor.DeleteArmorByOwnerService;
import com.game.core.repo.weapon.DeleteWeaponByOwnerService;
import com.game.domain.hero.Hero;
import com.game.repository.HeroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.rmi.NoSuchObjectException;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeleteHeroByNameServiceTest {

    @Mock
    private HeroRepository repository;

    @Mock
    private DeleteArmorByOwnerService armorService;

    @Mock
    private DeleteWeaponByOwnerService weaponService;

    @InjectMocks
    private DeleteHeroByNameService heroService;

    @Test
    void shouldDeleteHeroByName() throws NoSuchObjectException {
        when(repository.findById("ROCK")).thenReturn(Optional.of(new Hero()));
        heroService.deleteByName("ROCK");
        verify(repository).deleteById("ROCK");
        verify(armorService).deleteByOwner("ROCK");
        verify(weaponService).deleteByOwner("ROCK");
    }

}
package com.game.core.repo.weapon;

import com.game.domain.weapon.Weapon;
import com.game.repository.WeaponRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.rmi.NoSuchObjectException;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteWeaponByIDServiceTest {

    @Mock
    private WeaponRepository repository;

    @InjectMocks
    private DeleteWeaponByIDService service;

    @Test
    void shouldDeleteWeaponByID() throws NoSuchObjectException {
        when(repository.findById(1)).thenReturn(Optional.of(new Weapon()));
        service.deleteByID(1);
        verify(repository, times(1)).deleteById(1);

    }

}
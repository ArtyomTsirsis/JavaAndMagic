package com.game.core.repo.weapon;

import com.game.repository.WeaponRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeleteWeaponByOwnerServiceTest {

    @Mock
    private WeaponRepository repository;

    @InjectMocks
    private DeleteWeaponByOwnerService service;

    @Test
    void shouldDeleteWeaponByOwner() {
        service.deleteByOwner("TEST NAME");
        verify(repository, times(1)).deleteByOwner("TEST NAME");
    }


}
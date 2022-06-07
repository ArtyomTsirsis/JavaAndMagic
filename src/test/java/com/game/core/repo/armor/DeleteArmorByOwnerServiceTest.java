package com.game.core.repo.armor;

import com.game.repository.ArmorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeleteArmorByOwnerServiceTest {

    @Mock
    private ArmorRepository repository;

    @InjectMocks
    private DeleteArmorByOwnerService service;

    @Test
    void shouldDeleteArmorByOwner() {
        service.deleteByOwner("TEST NAME");
        verify(repository, times(1)).deleteByOwner("TEST NAME");
    }

}
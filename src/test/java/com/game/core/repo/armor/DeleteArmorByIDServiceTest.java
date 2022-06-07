package com.game.core.repo.armor;

import com.game.domain.armor.Armor;
import com.game.repository.ArmorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.rmi.NoSuchObjectException;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteArmorByIDServiceTest {

    @Mock
    private ArmorRepository repository;

    @InjectMocks
    private DeleteArmorByIDService service;

    @Test
    void shouldDeleteArmorByID() throws NoSuchObjectException {
        when(repository.findById(1)).thenReturn(Optional.of(new Armor()));
        service.deleteByID(1);
        verify(repository, times(1)).deleteById(1);

    }

}
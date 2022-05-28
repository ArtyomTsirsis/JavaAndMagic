package com.game.core.repo.armor;

import com.game.domain.armor.Armor;
import com.game.dto.armor.ArmorDTO;
import com.game.dto.armor.FindArmorByIdResponse;
import com.game.repository.ArmorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.rmi.NoSuchObjectException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindArmorByIDServiceTest {

    @Mock
    private ArmorRepository repository;

    @InjectMocks
    private FindArmorByIDService service;

    @Test
    void shouldFindArmorByID() throws NoSuchObjectException {
        when(repository.findById(1)).thenReturn(Optional.of(new Armor()));
        var result = service.findByID(1);
        var expectedResult = new FindArmorByIdResponse(new ArmorDTO());
        verify(repository, times(1)).findById(1);
        assertEquals(result, expectedResult);
    }

}
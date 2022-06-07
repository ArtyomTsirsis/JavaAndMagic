package com.game.core.repo.armor;

import com.game.domain.armor.Armor;
import com.game.dto.armor.FindArmorByOwnerResponse;
import com.game.repository.ArmorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindArmorByOwnerServiceTest {

    @Mock
    private ArmorRepository repository;

    @InjectMocks
    private FindArmorByOwnerService service;

    @Test
    void shouldFindArmorByOwner() {
        var response = List.of(new Armor());
        when(repository.findByOwner("TEST OWNER")).thenReturn(response);
        var result = service.findByOwner("TEST OWNER");
        var expectedResult = new FindArmorByOwnerResponse(List.of(new Armor()));
        verify(repository, times(1)).findByOwner("TEST OWNER");
        assertEquals(result, expectedResult);
    }

}
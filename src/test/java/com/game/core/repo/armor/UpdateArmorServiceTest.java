package com.game.core.repo.armor;

import com.game.domain.armor.Armor;
import com.game.dto.armor.ArmorDTO;
import com.game.dto.armor.UpdateArmorRequest;
import com.game.repository.ArmorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdateArmorServiceTest {

    @Mock
    private ArmorRepository repository;

    @InjectMocks
    private UpdateArmorService service;

    @Test
    void shouldUpdateArmor() {
        when(repository.findById(any())).thenReturn(Optional.of(new Armor()));
        service.update(request());
        verify(repository, times(1)).update(new Armor());

    }

    private UpdateArmorRequest request() {
        var requestForReturn = new UpdateArmorRequest();
        requestForReturn.setUpdatedArmorDTO(new ArmorDTO());
        return requestForReturn;
    }


}
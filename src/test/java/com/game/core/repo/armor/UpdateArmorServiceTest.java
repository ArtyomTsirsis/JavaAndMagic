package com.game.core.repo.armor;

import com.game.domain.armor.Armor;
import com.game.dto.armor.ArmorDTO;
import com.game.dto.armor.UpdateArmorRequest;
import com.game.repository.ArmorRepository;
import com.game.utils.ArmorDTOConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.game.domain.armor.ArmorClass.LEATHER_ARMOR;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdateArmorServiceTest {

    @Mock
    private ArmorRepository repository;

    @Mock
    private ArmorDTOConverter converter;

    @InjectMocks
    private UpdateArmorService service;

    @Test
    void shouldUpdateArmor() {
        when(converter.convertFromDto(armorDTO(armor()))).thenReturn(armor());
        when(repository.findById(any())).thenReturn(Optional.of(armor()));
        service.update(request());
        verify(repository).update(armor());

    }

    private UpdateArmorRequest request() {
        var requestForReturn = new UpdateArmorRequest();
        requestForReturn.setUpdatedArmorDTO(armorDTO(armor()));
        return requestForReturn;
    }

    private ArmorDTO armorDTO(Armor armor) {
        var armorDTO = new ArmorDTO();
        armorDTO.setArmorClass(armor.getArmorClass());
        armorDTO.setDurability(armor.getDurability());
        armorDTO.setOwner(armor.getOwner());
        armorDTO.setMagicalDefense(armor.getMagicalDefense());
        armorDTO.setPhysicalDefense(armor.getPhysicalDefense());
        armorDTO.setId(armor.getArmorID());
        return armorDTO;
    }

    private Armor armor() {
        var armor = new Armor();
        armor.setArmorClass(LEATHER_ARMOR);
        armor.setDurability(20);
        armor.setOwner("Torr");
        armor.setMagicalDefense(0);
        armor.setPhysicalDefense(30);
        armor.setArmorID(1);
        return armor;

    }


}
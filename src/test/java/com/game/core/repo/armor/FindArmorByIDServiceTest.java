package com.game.core.repo.armor;

import com.game.domain.armor.Armor;
import com.game.domain.armor.ArmorClass;
import com.game.dto.armor.ArmorDTO;
import com.game.dto.armor.FindArmorByIdResponse;
import com.game.repository.ArmorRepository;
import com.game.utils.ArmorDTOConverter;
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

    @Mock
    private ArmorDTOConverter converter;

    @Test
    void shouldFindArmorByID() throws NoSuchObjectException {
        when(converter.convertToDto(entity(any()))).thenReturn(armorDTO(1));
        when(repository.findById(1)).thenReturn(Optional.of(entity(1)));
        var result = service.findByID(1);
        var expectedResult = new FindArmorByIdResponse(armorDTO(1));
        verify(repository, times(1)).findById(1);
        assertEquals(result, expectedResult);
    }

    private Armor entity(Integer armorId) {
        var armor = new Armor();
        armor.setDurability(20);
        armor.setPhysicalDefense(30);
        armor.setMagicalDefense(0);
        armor.setArmorID(armorId);
        armor.setArmorClass(ArmorClass.LEATHER_ARMOR);
        armor.setOwner("TestName");
        return armor;
    }

    private ArmorDTO armorDTO(Integer id) {
        var armorDTO = new ArmorDTO();
        armorDTO.setDurability(20);
        armorDTO.setPhysicalDefense(30);
        armorDTO.setMagicalDefense(0);
        armorDTO.setId(id);
        armorDTO.setArmorClass(ArmorClass.LEATHER_ARMOR);
        armorDTO.setOwner("TestName");
        return armorDTO;

    }

}
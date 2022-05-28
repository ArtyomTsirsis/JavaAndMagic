package com.game.core.repo.armor;

import com.game.domain.armor.Armor;
import com.game.domain.armor.ArmorClass;
import com.game.dto.armor.ArmorDTO;
import com.game.dto.armor.CreateArmorRequest;
import com.game.dto.armor.CreateArmorResponse;
import com.game.dto.hero.HeroDTO;
import com.game.repository.ArmorRepository;
import com.game.utils.ArmorDTOConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateArmorServiceTest {

    @Mock
    private ArmorRepository repository;

    @InjectMocks
    private CreateArmorService service;
    @Mock
    private ArmorDTOConverter converter;

    @Test
    void shouldCreateArmor() {
        when(converter.convertToDto(entity(any()))).thenReturn(armorDTO(1));
        when(repository.save(entity(null))).thenReturn(entity(1));
        var result = service.createArmor(createArmorRequest());
        verify(repository).save(any());
        var expectedResult = new CreateArmorResponse(converter.convertToDto(entity(1)));
        assertEquals(result.getArmor().getId(), expectedResult.getArmor().getId());

    }

    private CreateArmorRequest createArmorRequest() {
        var hero = new HeroDTO();
        hero.setName("TestName");
        return new CreateArmorRequest(ArmorClass.LEATHER_ARMOR, hero);
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
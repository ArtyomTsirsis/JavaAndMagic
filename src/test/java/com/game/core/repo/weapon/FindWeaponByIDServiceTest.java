package com.game.core.repo.weapon;

import com.game.domain.weapon.Weapon;
import com.game.dto.weapon.FindWeaponByIdResponse;
import com.game.dto.weapon.WeaponDTO;
import com.game.repository.WeaponRepository;
import com.game.utils.WeaponDTOConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.rmi.NoSuchObjectException;
import java.util.Optional;

import static com.game.domain.weapon.WeaponType.AXE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindWeaponByIDServiceTest {

    @Mock
    private WeaponRepository repository;

    @Mock
    private WeaponDTOConverter converter;

    @InjectMocks
    private FindWeaponByIDService service;

    @Test
    void shouldFindArmorByID() throws NoSuchObjectException {
        when(converter.convertToDto(entity(any()))).thenReturn(weaponDTO());
        when(repository.findById(1)).thenReturn(Optional.of(entity(1)));
        var result = service.findByID(1);
        var expectedResult = new FindWeaponByIdResponse(weaponDTO());
        verify(repository, times(1)).findById(1);
        assertEquals(result.getWeapon().getId(), expectedResult.getWeapon().getId());
    }

    private Weapon entity(Integer weaponId) {
        var weapon = new Weapon();
        weapon.setDurability(50);
        weapon.setWeaponType(AXE);
        weapon.setCriticalHitChance(2);
        weapon.setWeaponID(weaponId);
        weapon.setLevel(1);
        weapon.setOwner("TestName");
        weapon.setMagicalDamage(0);
        weapon.setPhysicalDamage(100);
        return weapon;
    }

    private WeaponDTO weaponDTO() {
        var weaponDTO = new WeaponDTO();
        weaponDTO.setDurability(50);
        weaponDTO.setWeaponType(AXE);
        weaponDTO.setCriticalHitChance(2);
        weaponDTO.setId(1);
        weaponDTO.setLevel(1);
        weaponDTO.setOwner("TestName");
        weaponDTO.setMagicalDamage(0);
        weaponDTO.setPhysicalDamage(100);
        return weaponDTO;

    }

}
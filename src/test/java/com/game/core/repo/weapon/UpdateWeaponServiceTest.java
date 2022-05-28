package com.game.core.repo.weapon;

import com.game.domain.weapon.Weapon;
import com.game.dto.weapon.UpdateWeaponRequest;
import com.game.dto.weapon.WeaponDTO;
import com.game.repository.WeaponRepository;
import com.game.utils.WeaponDTOConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.game.domain.weapon.WeaponType.AXE;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateWeaponServiceTest {

    @Mock
    private WeaponRepository repository;

    @InjectMocks
    private UpdateWeaponService service;

    @Mock
    private WeaponDTOConverter converter;

    @Test
    void shouldUpdateArmor() {
        when(converter.convertFromDto(weaponDTO())).thenReturn(entity());
        when(repository.findById(any())).thenReturn(Optional.of(entity()));
        service.update(request());
        verify(repository).update(entity());

    }

    private UpdateWeaponRequest request() {
        var requestForReturn = new UpdateWeaponRequest();
        requestForReturn.setUpdatedWeaponDTO(weaponDTO());
        return requestForReturn;
    }


    private Weapon entity() {
        var weapon = new Weapon();
        weapon.setDurability(50);
        weapon.setWeaponType(AXE);
        weapon.setCriticalHitChance(2);
        weapon.setWeaponID(1);
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
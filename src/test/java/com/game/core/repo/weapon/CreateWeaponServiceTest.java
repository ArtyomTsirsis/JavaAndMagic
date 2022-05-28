package com.game.core.repo.weapon;

import com.game.domain.weapon.Weapon;
import com.game.domain.weapon.WeaponType;
import com.game.dto.hero.HeroDTO;
import com.game.dto.weapon.CreateWeaponRequest;
import com.game.dto.weapon.CreateWeaponResponse;
import com.game.dto.weapon.WeaponDTO;
import com.game.repository.WeaponRepository;
import com.game.utils.WeaponDTOConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.game.domain.weapon.WeaponType.AXE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateWeaponServiceTest {

    @Mock
    private WeaponRepository repository;

    @InjectMocks
    private CreateWeaponService service;

    @Mock
    private WeaponDTOConverter converter;


    @Test
    void shouldCreateArmor() {
        when(converter.convertToDto(any())).thenReturn(weaponDTO());
        when(repository.save(entity(null))).thenReturn(entity(1));
        var result = service.createWeapon(createWeaponRequest());
        verify(repository).save(any());
        var expectedResult = new CreateWeaponResponse(converter.convertToDto(entity(1)));
        assertEquals(result.getWeapon().getId(), expectedResult.getWeapon().getId());

    }

    private CreateWeaponRequest createWeaponRequest() {
        var hero = new HeroDTO();
        hero.setName("TestName");
        return new CreateWeaponRequest(WeaponType.AXE, hero);
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
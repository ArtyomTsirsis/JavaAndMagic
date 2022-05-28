package com.game.core.repo.weapon;

import com.game.domain.weapon.Weapon;
import com.game.dto.weapon.FindWeaponByOwnerResponse;
import com.game.repository.WeaponRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindWeaponByOwnerServiceTest {


    @Mock
    private WeaponRepository repository;

    @InjectMocks
    private FindWeaponByOwnerService service;

    @Test
    void shouldFindArmorByOwner() {
        var response = List.of(new Weapon());
        when(repository.findByOwner("TEST OWNER")).thenReturn(response);
        var result = service.findByOwner("TEST OWNER");
        var expectedResult = new FindWeaponByOwnerResponse(List.of(new Weapon()));
        verify(repository, times(1)).findByOwner("TEST OWNER");
        assertEquals(result, expectedResult);
    }


}
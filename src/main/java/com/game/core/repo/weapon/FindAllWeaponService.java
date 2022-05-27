package com.game.core.repo.weapon;

import com.game.dto.weapon.FindAllWeaponResponse;
import com.game.repository.WeaponRepository;
import com.game.utils.WeaponDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindAllWeaponService {

    private final WeaponRepository repository;
    private final WeaponDTOConverter converter;

    public FindAllWeaponResponse findAll() {
        return new FindAllWeaponResponse(repository.findAll().stream().map(converter::convertToDto).toList());
    }

}

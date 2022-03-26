package com.game.reposervices.weapon;

import com.game.dto.weapon.FindAllWeaponResponse;
import com.game.repository.weapon.WeaponRepository;
import com.game.utils.WeaponDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAllWeaponService {

    @Autowired
    private WeaponRepository repository;
    @Autowired
    private WeaponDTOConverter converter;

    public FindAllWeaponResponse findAll() {
        return new FindAllWeaponResponse(repository.findAll().stream().map(converter::convertToDto).toList());
    }

}

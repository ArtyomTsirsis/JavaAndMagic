package com.game.reposervices.weapon;

import com.game.dto.weapon.CreateWeaponRequest;
import com.game.dto.weapon.CreateWeaponResponse;
import com.game.repository.weapon.Weapon;
import com.game.repository.weapon.WeaponFactory;
import com.game.repository.weapon.WeaponRepository;
import com.game.utils.WeaponDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateWeaponService {

    @Autowired
    private WeaponRepository repository;
    @Autowired
    private WeaponDTOConverter converter;

    public CreateWeaponResponse createWeapon(CreateWeaponRequest request) {
        Weapon weapon = WeaponFactory.createWeapon(request.getWeaponType());
        repository.save(weapon);
        return new CreateWeaponResponse(converter.convertToDto(weapon));
    }


}

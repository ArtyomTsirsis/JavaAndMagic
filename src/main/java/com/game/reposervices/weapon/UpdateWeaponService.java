package com.game.reposervices.weapon;

import com.game.dto.weapon.UpdateWeaponRequest;
import com.game.repository.weapon.WeaponRepository;
import com.game.utils.WeaponDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateWeaponService {

    @Autowired
    private WeaponRepository repository;
    @Autowired
    private WeaponDTOConverter converter;

    public void update(UpdateWeaponRequest request) {
        if(repository.findById(request.getUpdatedWeaponDTO().getId()).isPresent()) {
            repository.update(converter.convertFromDto(request.getUpdatedWeaponDTO()));
        }
    }

}

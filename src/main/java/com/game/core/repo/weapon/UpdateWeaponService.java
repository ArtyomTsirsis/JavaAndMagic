package com.game.core.repo.weapon;

import com.game.dto.weapon.UpdateWeaponRequest;
import com.game.repository.WeaponRepository;
import com.game.utils.WeaponDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateWeaponService {

    private final WeaponRepository repository;
    private final WeaponDTOConverter converter;

    public void update(UpdateWeaponRequest request) {
        if(repository.findById(request.getUpdatedWeaponDTO().getId()).isPresent()) {
            repository.update(converter.convertFromDto(request.getUpdatedWeaponDTO()));
        }
    }

}

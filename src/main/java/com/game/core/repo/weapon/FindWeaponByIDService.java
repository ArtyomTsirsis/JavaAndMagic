package com.game.core.repo.weapon;

import com.game.dto.weapon.FindWeaponByIdResponse;
import com.game.domain.weapon.Weapon;
import com.game.repository.WeaponRepository;
import com.game.utils.WeaponDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.rmi.NoSuchObjectException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindWeaponByIDService {

    private final WeaponRepository repository;
    private final WeaponDTOConverter converter;

    public FindWeaponByIdResponse findByID(Integer id) throws NoSuchObjectException {
        Optional<Weapon> weapon = repository.findById(id);
        if (weapon.isEmpty()) {
            throw new NoSuchObjectException(id.toString());

        }
        return new FindWeaponByIdResponse(converter.convertToDto(weapon.get()));
    }
}

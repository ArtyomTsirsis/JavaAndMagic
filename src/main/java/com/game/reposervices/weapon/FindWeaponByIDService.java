package com.game.reposervices.weapon;

import com.game.dto.weapon.FindWeaponByIdResponse;
import com.game.repository.weapon.Weapon;
import com.game.repository.weapon.WeaponRepository;
import com.game.utils.WeaponDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.rmi.NoSuchObjectException;
import java.util.Optional;

@Component
public class FindWeaponByIDService {

    @Autowired
    private WeaponRepository repository;
    @Autowired
    private WeaponDTOConverter converter;

    public FindWeaponByIdResponse findByID(Integer id) throws NoSuchObjectException {
        Optional<Weapon> weapon = repository.findById(id);
        if (weapon.isEmpty()) {
            throw new NoSuchObjectException(id.toString());

        }
        return new FindWeaponByIdResponse(converter.convertToDto(weapon.get()));

    }
}

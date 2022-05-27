package com.game.core.repo.weapon;

import com.game.dto.weapon.FindWeaponByOwnerResponse;
import com.game.repository.WeaponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindWeaponByOwnerService {

    private final WeaponRepository repository;

    public FindWeaponByOwnerResponse findByOwner(String owner) {
        return new FindWeaponByOwnerResponse(repository.findByOwner(owner));
    }

}

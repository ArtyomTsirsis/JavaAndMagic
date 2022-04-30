package com.game.reposervices.weapon;

import com.game.dto.weapon.FindWeaponByOwnerRequest;
import com.game.dto.weapon.FindWeaponByOwnerResponse;
import com.game.repository.weapon.WeaponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindWeaponByOwnerService {

    private final WeaponRepository repository;

    public FindWeaponByOwnerResponse findByOwner(FindWeaponByOwnerRequest request) {
        return new FindWeaponByOwnerResponse(repository.findByOwner(request.getHero().getName()));
    }

}

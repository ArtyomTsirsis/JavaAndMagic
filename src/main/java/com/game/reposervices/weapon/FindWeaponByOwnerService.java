package com.game.reposervices.weapon;

import com.game.dto.weapon.FindWeaponByOwnerRequest;
import com.game.dto.weapon.FindWeaponByOwnerResponse;
import com.game.repository.weapon.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindWeaponByOwnerService {

    @Autowired
    private WeaponRepository repository;

    public FindWeaponByOwnerResponse findByOwner(FindWeaponByOwnerRequest request) {
        return new FindWeaponByOwnerResponse(repository.findByOwner(request.getHero().getName()));
    }

}

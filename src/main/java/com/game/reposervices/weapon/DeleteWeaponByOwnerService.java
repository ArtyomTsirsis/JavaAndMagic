package com.game.reposervices.weapon;

import com.game.repository.weapon.WeaponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteWeaponByOwnerService {

    private final WeaponRepository repository;

    public void deleteByOwner(String name) {
        repository.deleteByOwner(name);
    }

}

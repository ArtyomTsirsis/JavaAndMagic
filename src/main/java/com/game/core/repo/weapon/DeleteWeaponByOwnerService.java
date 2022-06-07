package com.game.core.repo.weapon;

import com.game.repository.WeaponRepository;
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

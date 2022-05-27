package com.game.core.repo.hero;

import com.game.core.repo.armor.DeleteArmorByOwnerService;
import com.game.core.repo.weapon.DeleteWeaponByOwnerService;
import com.game.repository.HeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.NoSuchObjectException;

@Service
@RequiredArgsConstructor
public class DeleteHeroByNameService {

    private final HeroRepository repository;
    private final DeleteArmorByOwnerService deleteArmorByOwnerService;
    private final DeleteWeaponByOwnerService deleteWeaponByOwnerService;

    @Transactional
    public void deleteByName(String name) throws NoSuchObjectException {
        if (repository.findById(name).isEmpty()) {
            throw new NoSuchObjectException(name);
        }
        repository.deleteById(name);
        deleteArmorByOwnerService.deleteByOwner(name);
        deleteWeaponByOwnerService.deleteByOwner(name);
    }

}

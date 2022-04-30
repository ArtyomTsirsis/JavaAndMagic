package com.game.reposervices.hero;

import com.game.reposervices.armor.DeleteArmorByOwnerService;
import com.game.reposervices.weapon.DeleteWeaponByOwnerService;
import com.game.repository.hero.HeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.rmi.NoSuchObjectException;

@Service
@RequiredArgsConstructor
public class DeleteHeroByNameService {

    private final HeroRepository repository;
    private final DeleteArmorByOwnerService deleteArmorByOwnerService;
    private final DeleteWeaponByOwnerService deleteWeaponByOwnerService;

    public void deleteByName(String name) throws NoSuchObjectException {
        if (repository.findById(name).isEmpty()) {
            throw new NoSuchObjectException(name);
        }
        repository.deleteById(name);
        deleteArmorByOwnerService.deleteByOwner(name);
        deleteWeaponByOwnerService.deleteByOwner(name);
    }

}

package com.game.reposervices.hero;

import com.game.reposervices.armor.DeleteArmorByOwnerService;
import com.game.reposervices.weapon.DeleteWeaponByOwnerService;
import com.game.repository.hero.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.rmi.NoSuchObjectException;

@Component
public class DeleteHeroByNameService {

    @Autowired
    private HeroRepository repository;
    @Autowired
    private DeleteArmorByOwnerService deleteArmorByOwnerService;
    @Autowired
    private DeleteWeaponByOwnerService deleteWeaponByOwnerService;

    public void deleteByName(String name) throws NoSuchObjectException {
        if (repository.findById(name).isEmpty()) {
            throw new NoSuchObjectException(name);
        }
        repository.deleteById(name);
        deleteArmorByOwnerService.deleteByOwner(name);
        deleteWeaponByOwnerService.deleteByOwner(name);
    }

}

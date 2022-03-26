package com.game.reposervices.weapon;

import com.game.repository.weapon.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteWeaponByIDService {

    @Autowired
    private WeaponRepository repository;

    public void deleteByID(Integer id) {
        repository.deleteById(id);
    }

}

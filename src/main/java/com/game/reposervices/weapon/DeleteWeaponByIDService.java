package com.game.reposervices.weapon;

import com.game.repository.weapon.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.rmi.NoSuchObjectException;

@Component
public class DeleteWeaponByIDService {

    @Autowired
    private WeaponRepository repository;

    public void deleteByID(Integer id) throws NoSuchObjectException {
        if (repository.findById(id).isEmpty()) {
            throw new NoSuchObjectException(id.toString());
        }
        repository.deleteById(id);
    }

}

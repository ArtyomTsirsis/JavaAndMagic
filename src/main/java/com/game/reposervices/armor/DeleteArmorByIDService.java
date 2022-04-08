package com.game.reposervices.armor;

import com.game.repository.armor.ArmorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.rmi.NoSuchObjectException;

@Component
public class DeleteArmorByIDService {

    @Autowired
    private ArmorRepository repository;

    public void deleteByID(Integer id) throws NoSuchObjectException {
        if (repository.findById(id).isEmpty()) {
            throw new NoSuchObjectException(id.toString());
        }
        repository.deleteById(id);
    }

}

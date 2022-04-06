package com.game.reposervices.armor;

import com.game.repository.armor.ArmorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteArmorByOwnerService {

    @Autowired
    private ArmorRepository repository;

    public void deleteByOwner(String name) {
        repository.deleteByOwner(name);
    }

}

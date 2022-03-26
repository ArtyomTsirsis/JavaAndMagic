package com.game.reposervices.armor;

import com.game.repository.armor.ArmorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteArmorByIDService {

    @Autowired
    private ArmorRepository repository;

    public void deleteByID(Integer id) {
        repository.deleteById(id);
    }

}

package com.game.reposervices.armor;

import com.game.dto.armor.FindAllArmorResponse;
import com.game.repository.armor.ArmorRepository;
import com.game.utils.ArmorDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAllArmorService {

    @Autowired
    private ArmorRepository repository;
    @Autowired
    private ArmorDTOConverter converter;

    public FindAllArmorResponse findAll() {
        return new FindAllArmorResponse(repository.findAll().stream().map(converter::convertToDto).toList());
    }

}

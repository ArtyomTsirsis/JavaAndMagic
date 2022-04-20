package com.game.reposervices.armor;

import com.game.dto.armor.UpdateArmorRequest;
import com.game.repository.armor.ArmorRepository;
import com.game.utils.ArmorDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateArmorService {

    @Autowired
    private ArmorRepository repository;
    @Autowired
    private ArmorDTOConverter converter;

    public void update(UpdateArmorRequest request) {
        if(repository.findById(request.getUpdatedArmorDTO().getId()).isPresent()) {
            repository.update(converter.convertFromDto(request.getUpdatedArmorDTO()));
        }
    }

}

package com.game.reposervices.armor;

import com.game.dto.armor.CreateArmorRequest;
import com.game.dto.armor.CreateArmorResponse;
import com.game.repository.armor.Armor;
import com.game.repository.armor.ArmorFactory;
import com.game.repository.armor.ArmorRepository;
import com.game.utils.ArmorDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateArmorService {

    @Autowired
    private ArmorRepository repository;
    @Autowired
    private ArmorDTOConverter converter;

    public CreateArmorResponse createArmor(CreateArmorRequest request) {
        Armor armor = ArmorFactory.createArmor(request.getArmorClass());
        armor.setOwner(request.getHero().getName());
        repository.save(armor);
        return new CreateArmorResponse(converter.convertToDto(armor));
    }


}

package com.game.reposervices.armor;

import com.game.dto.armor.FindArmorByIdResponse;
import com.game.repository.armor.Armor;
import com.game.repository.armor.ArmorRepository;
import com.game.utils.ArmorDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.rmi.NoSuchObjectException;
import java.util.Optional;

@Component
public class FindArmorByIDService {

    @Autowired
    private ArmorRepository repository;
    @Autowired
    private ArmorDTOConverter converter;

    public FindArmorByIdResponse findByID(Integer id) throws NoSuchObjectException {
        Optional<Armor> armor = repository.findById(id);
        if (armor.isEmpty()) {
            throw new NoSuchObjectException(id.toString());

        }
        return new FindArmorByIdResponse(converter.convertToDto(armor.get()));

    }
}

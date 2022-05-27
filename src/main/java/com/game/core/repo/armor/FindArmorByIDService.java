package com.game.core.repo.armor;

import com.game.dto.armor.FindArmorByIdResponse;
import com.game.domain.armor.Armor;
import com.game.repository.ArmorRepository;
import com.game.utils.ArmorDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.rmi.NoSuchObjectException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindArmorByIDService {

    private final ArmorRepository repository;
    private final ArmorDTOConverter converter;

    public FindArmorByIdResponse findByID(Integer id) throws NoSuchObjectException {
        Optional<Armor> armor = repository.findById(id);
        if (armor.isEmpty()) {
            throw new NoSuchObjectException(id.toString());

        }
        return new FindArmorByIdResponse(converter.convertToDto(armor.get()));

    }
}

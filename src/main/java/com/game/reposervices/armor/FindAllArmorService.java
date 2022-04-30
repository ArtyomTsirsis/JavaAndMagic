package com.game.reposervices.armor;

import com.game.dto.armor.FindAllArmorResponse;
import com.game.repository.armor.ArmorRepository;
import com.game.utils.ArmorDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindAllArmorService {

    private final ArmorRepository repository;
    private final ArmorDTOConverter converter;

    public FindAllArmorResponse findAll() {
        return new FindAllArmorResponse(repository.findAll().stream().map(converter::convertToDto).toList());
    }

}

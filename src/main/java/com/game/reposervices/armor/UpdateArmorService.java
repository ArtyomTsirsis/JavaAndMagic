package com.game.reposervices.armor;

import com.game.dto.armor.UpdateArmorRequest;
import com.game.repository.armor.ArmorRepository;
import com.game.utils.ArmorDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateArmorService {

    private final ArmorRepository repository;
    private final ArmorDTOConverter converter;

    public void update(UpdateArmorRequest request) {
        if(repository.findById(request.getUpdatedArmorDTO().getId()).isPresent()) {
            repository.update(converter.convertFromDto(request.getUpdatedArmorDTO()));
        }
    }

}

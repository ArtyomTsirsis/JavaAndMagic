package com.game.core.repo.armor;

import com.game.dto.armor.FindArmorByOwnerResponse;
import com.game.repository.ArmorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindArmorByOwnerService {

    private final ArmorRepository repository;

    public FindArmorByOwnerResponse findByOwner(String owner) {
        return new FindArmorByOwnerResponse(repository.findByOwner(owner));
    }

}

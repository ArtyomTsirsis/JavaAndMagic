package com.game.reposervices.armor;

import com.game.dto.armor.FindArmorByOwnerRequest;
import com.game.dto.armor.FindArmorByOwnerResponse;
import com.game.repository.armor.ArmorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindArmorByOwnerService {

    private final ArmorRepository repository;

    public FindArmorByOwnerResponse findByOwner(FindArmorByOwnerRequest request) {
        return new FindArmorByOwnerResponse(repository.findByOwner(request.getHero().getName()));
    }

}

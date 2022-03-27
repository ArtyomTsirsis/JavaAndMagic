package com.game.reposervices.armor;

import com.game.dto.armor.FindArmorByOwnerRequest;
import com.game.dto.armor.FindArmorByOwnerResponse;
import com.game.repository.armor.ArmorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindArmorByOwnerService {

    @Autowired
    private ArmorRepository repository;

    public FindArmorByOwnerResponse findByOwner(FindArmorByOwnerRequest request) {
        return new FindArmorByOwnerResponse(repository.findByOwner(request.getHero().getName()));
    }

}

package com.game.reposervices.armor;

import com.game.repository.armor.ArmorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteArmorByOwnerService {

    private final ArmorRepository repository;

    public void deleteByOwner(String name) {
        repository.deleteByOwner(name);
    }

}

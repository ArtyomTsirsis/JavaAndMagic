package com.game.core.repo.armor;

import com.game.repository.ArmorRepository;
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

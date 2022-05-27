package com.game.core.repo.weapon;

import com.game.repository.WeaponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.rmi.NoSuchObjectException;

@Service
@RequiredArgsConstructor
public class DeleteWeaponByIDService {

    private final WeaponRepository repository;

    public void deleteByID(Integer id) throws NoSuchObjectException {
        if (repository.findById(id).isEmpty()) {
            throw new NoSuchObjectException(id.toString());
        }
        repository.deleteById(id);
    }

}

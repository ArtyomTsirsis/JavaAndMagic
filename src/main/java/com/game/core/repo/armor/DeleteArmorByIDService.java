package com.game.core.repo.armor;

import com.game.repository.ArmorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.rmi.NoSuchObjectException;

@Service
@RequiredArgsConstructor
public class DeleteArmorByIDService {

    private final ArmorRepository repository;

    public void deleteByID(Integer id) throws NoSuchObjectException {
        if (repository.findById(id).isEmpty()) {
            throw new NoSuchObjectException(id.toString());
        }
        repository.deleteById(id);
    }

}

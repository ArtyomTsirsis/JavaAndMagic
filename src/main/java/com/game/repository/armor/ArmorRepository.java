package com.game.repository.armor;

import java.util.List;
import java.util.Optional;

public interface ArmorRepository {

    Armor save(Armor armor);
    Optional<Armor> findById(Integer id);
    List<Armor> findByOwner(String owner);
    List<Armor> findAll();
    void deleteById(Integer id);

}

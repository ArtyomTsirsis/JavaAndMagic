package com.game.repository.weapon;

import java.util.List;
import java.util.Optional;

public interface WeaponRepository {

    void save(Weapon weapon);
    Optional<Weapon> findById(Integer id);
    List<Weapon> findByOwner(String owner);
    List<Weapon> findAll();
    void deleteById(Integer id);

}

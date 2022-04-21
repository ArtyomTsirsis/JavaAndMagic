package com.game.repository.weapon;

import java.util.List;
import java.util.Optional;

public interface WeaponRepository {

    Weapon save(Weapon weapon);
    Optional<Weapon> findById(Integer id);
    List<Weapon> findByOwner(String owner);
    List<Weapon> findAll();
    void deleteById(Integer id);
    void deleteByOwner(String name);
    void update(Weapon weapon);

}

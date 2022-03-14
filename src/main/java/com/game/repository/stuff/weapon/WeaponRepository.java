package com.game.repository.stuff.weapon;

import java.util.HashMap;
import java.util.Map;

public class WeaponRepository {

    private final static Map<WeaponType, Weapon> weaponRepo = new HashMap<>();

    //    Create Heroes in Factory and put them to Map.
    public void save(Weapon weapon) {
        weaponRepo.put(weapon.getWeaponType(), weapon);
    }

    //    Find hero by id
    public Weapon findById(WeaponType weaponType) {
        return weaponRepo.get(weaponType);
    }

    //    Find all heroes
    public Iterable<Weapon> findAll() {
        return weaponRepo.values();
    }

    //    Delete Hero by id
    public void deleteById(WeaponType weaponType) {
        weaponRepo.remove(weaponType);
    }

}

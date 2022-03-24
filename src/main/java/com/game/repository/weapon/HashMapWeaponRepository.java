package com.game.repository.weapon;

import java.util.HashMap;
import java.util.Map;

public class HashMapWeaponRepository implements WeaponRepository {

    private final static Map<WeaponType, Weapon> weaponRepo = new HashMap<>();

    @Override
    public void save(Weapon weapon) {
        weaponRepo.put(weapon.getWeaponType(), weapon);
    }

    @Override
    public Weapon findById(WeaponType weaponType) {
        return weaponRepo.get(weaponType);
    }

    @Override
    public Iterable<Weapon> findAll() {
        return weaponRepo.values();
    }

    @Override
    public void deleteById(WeaponType weaponType) {
        weaponRepo.remove(weaponType);
    }

}

package com.game.repository.weapon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class HashMapWeaponRepository implements WeaponRepository {

    private final static Map<Integer, Weapon> weaponRepo = new HashMap<>();

    @Override
    public Weapon save(Weapon weapon) {
        weaponRepo.put(weapon.getWeaponID(), weapon);
        return weapon;
    }

    @Override
    public Optional<Weapon> findById(Integer id) {
        return Optional.ofNullable(weaponRepo.get(id));
    }

    @Override
    public List<Weapon> findByOwner(String owner) {
        return weaponRepo.values().stream().filter(o -> owner.equals(o.getOwner())).toList();
    }

    @Override
    public List<Weapon> findAll() {
        return weaponRepo.values().stream().toList();
    }

    @Override
    public void deleteById(Integer id) {
        weaponRepo.remove(id);
    }

}

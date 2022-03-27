package com.game.repository.armor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class HashMapArmorRepository implements ArmorRepository {

    private final static Map<Integer, Armor> armorRepo = new HashMap<>();

    @Override
    public void save(Armor armor) {
        armorRepo.put(armor.getId(), armor);
    }

    @Override
    public Optional<Armor> findById(Integer id) {
        return Optional.ofNullable(armorRepo.get(id));
    }

    @Override
    public List<Armor> findByOwner(String owner) {
        return armorRepo.values().stream().filter(o -> owner.equals(o.getOwner())).toList();
    }

    @Override
    public List<Armor> findAll() {
        return armorRepo.values().stream().toList();
    }

    @Override
    public void deleteById(Integer id) {
        armorRepo.remove(id);
    }

}

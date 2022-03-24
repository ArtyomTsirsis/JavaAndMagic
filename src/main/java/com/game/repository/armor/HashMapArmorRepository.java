package com.game.repository.armor;

import java.util.HashMap;
import java.util.Map;

public class HashMapArmorRepository implements ArmorRepository {

    private final static Map<ArmorClass, Armor> armorRepo = new HashMap<>();

    @Override
    public void save(Armor armor) {
        armorRepo.put(armor.getArmorClass(), armor);
    }

    @Override
    public Armor findById(ArmorClass armorClass) {
        return armorRepo.get(armorClass);
    }

    @Override
    public Iterable<Armor> findAll() {
        return armorRepo.values();
    }

    @Override
    public void deleteById(ArmorClass armorClass) {
        armorRepo.remove(armorClass);
    }

}

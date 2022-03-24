package com.game.repository.armor;

public interface ArmorRepository {

    public void save(Armor armor);
    public Armor findById(ArmorClass armorClass);
    public Iterable<Armor> findAll();
    public void deleteById(ArmorClass armorClass);

}

package com.game.repository.weapon;

public interface WeaponRepository {

    public void save(Weapon weapon);
    public Weapon findById(WeaponType weaponType);
    public Iterable<Weapon> findAll();
    public void deleteById(WeaponType weaponType);

}

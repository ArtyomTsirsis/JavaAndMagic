package com.game.repository;

import com.game.repository.weapon.Weapon;
import com.game.repository.weapon.WeaponRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class WeaponHibernateRepository implements WeaponRepository {

    @Override
    public Weapon save(Weapon weapon) {
        return null;
    }

    @Override
    public Optional<Weapon> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Weapon> findByOwner(String owner) {
        return null;
    }

    @Override
    public List<Weapon> findAll() {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteByOwner(String name) {

    }

}

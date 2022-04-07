package com.game.repository;

import com.game.repository.armor.Armor;
import com.game.repository.armor.ArmorRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ArmorHibernateRepository implements ArmorRepository {

    @Override
    public Armor save(Armor armor) {
        return null;
    }

    @Override
    public Optional<Armor> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Armor> findByOwner(String owner) {
        return null;
    }

    @Override
    public List<Armor> findAll() {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteByOwner(String name) {

    }

}

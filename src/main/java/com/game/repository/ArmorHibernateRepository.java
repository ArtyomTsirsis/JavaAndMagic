package com.game.repository;

import com.game.repository.armor.Armor;
import com.game.repository.armor.ArmorRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ArmorHibernateRepository implements ArmorRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Armor save(Armor armor) {
        sessionFactory.getCurrentSession().persist(armor);
        return armor;
    }

    @Override
    public Optional<Armor> findById(Integer id) {
        Armor toReturn = sessionFactory.getCurrentSession().get(Armor.class, id);
        return Optional.ofNullable(toReturn);
    }

    @Override
    public List<Armor> findByOwner(String owner) {
        return sessionFactory.getCurrentSession().createQuery("SELECT * FROM armor WHERE owner=" + owner, Armor.class).getResultList();
    }

    @Override
    public List<Armor> findAll() {
        return sessionFactory.getCurrentSession().createQuery("SELECT * FROM armor", Armor.class).getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        sessionFactory.getCurrentSession().remove(findById(id));
    }

    @Override
    public void deleteByOwner(String name) {
        sessionFactory.getCurrentSession().createQuery("DELETE FROM weapon WHERE owner=" + name);
    }

}

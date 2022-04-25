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
        return Optional.ofNullable(sessionFactory.getCurrentSession().get(Armor.class, id));
    }

    @Override
    public List<Armor> findByOwner(String owner) {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT a FROM armor a WHERE a.owner=:param", Armor.class)
                .setParameter("param", owner)
                .getResultList();
    }

    @Override
    public List<Armor> findAll() {
        return sessionFactory.getCurrentSession()
                .createNativeQuery("SELECT * FROM armor", Armor.class)
                .getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        sessionFactory.getCurrentSession().
                createQuery("DELETE armor a WHERE a.armorID=:param")
                .setParameter("param", id)
                .executeUpdate();
    }

    @Override
    public void deleteByOwner(String owner) {
        sessionFactory.getCurrentSession()
                .createQuery("SELECT a FROM armor a WHERE a.owner=:param")
                .setParameter("param", owner)
                .executeUpdate();
    }

    @Override
    public void update(Armor armor) {
        sessionFactory.getCurrentSession().update(armor);
    }

}

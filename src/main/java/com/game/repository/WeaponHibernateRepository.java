package com.game.repository;

import com.game.repository.weapon.Weapon;
import com.game.repository.weapon.WeaponRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class WeaponHibernateRepository implements WeaponRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Weapon save(Weapon weapon) {
        sessionFactory.openSession().persist(weapon);
        return weapon;
    }

    @Override
    public Optional<Weapon> findById(Integer id) {
        return Optional.ofNullable(sessionFactory.openSession().get(Weapon.class, id));
    }

    @Override
    public List<Weapon> findByOwner(String owner) {
        return sessionFactory.openSession()
                .createQuery("SELECT w FROM weapon w WHERE w.owner=:param", Weapon.class)
                .setParameter("param", owner)
                .getResultList();
    }

    @Override
    public List<Weapon> findAll() {
        return sessionFactory.openSession().
                createNativeQuery("SELECT * FROM weapon", Weapon.class)
                .getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        sessionFactory.openSession()
                .createQuery("DELETE weapon w WHERE w.weaponID=:param")
                .setParameter("param", id)
                .executeUpdate();
    }

    @Override
    public void deleteByOwner(String owner) {
        sessionFactory.openSession()
                .createQuery("DELETE weapon w WHERE w.owner=:param")
                .setParameter("param", owner)
                .executeUpdate();
    }

    @Override
    public void update(Weapon weapon) {
        sessionFactory.openSession().update(weapon);
    }

}

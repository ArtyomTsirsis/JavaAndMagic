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
        sessionFactory.getCurrentSession().persist(weapon);
        return weapon;
    }

    @Override
    public Optional<Weapon> findById(Integer id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().get(Weapon.class, id));
    }

    @Override
    public List<Weapon> findByOwner(String owner) {
        return sessionFactory
                .getCurrentSession()
                .createQuery(String.format("SELECT w FROM weapon w WHERE w.owner='%s'", owner), Weapon.class)
                .getResultList();
    }

    @Override
    public List<Weapon> findAll() {
        return sessionFactory.getCurrentSession().
                createNativeQuery("SELECT * FROM weapon", Weapon.class)
                .getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        sessionFactory.getCurrentSession().
                createQuery(String.format("DELETE weapon w WHERE w.weaponID='%s'", id)).
                executeUpdate();
    }

    @Override
    public void deleteByOwner(String owner) {
        sessionFactory.getCurrentSession()
                .createQuery(String.format("DELETE weapon w WHERE w.owner='%s'", owner))
                .executeUpdate();
    }

}

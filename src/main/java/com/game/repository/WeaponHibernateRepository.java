package com.game.repository;

import com.game.repository.weapon.Weapon;
import com.game.repository.weapon.WeaponRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Transactional
public class WeaponHibernateRepository implements WeaponRepository {

    private final SessionFactory sessionFactory;

    @Override
    public Weapon save(Weapon weapon) {
        sessionFactory.getCurrentSession().save(weapon);
        return weapon;
    }

    @Override
    public Optional<Weapon> findById(Integer id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().get(Weapon.class, id));
    }

    @Override
    public List<Weapon> findByOwner(String owner) {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT w FROM weapon w WHERE w.owner=:param", Weapon.class)
                .setParameter("param", owner)
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
        sessionFactory.getCurrentSession()
                .createQuery("DELETE weapon w WHERE w.weaponID=:param")
                .setParameter("param", id)
                .executeUpdate();
    }

    @Override
    public void deleteByOwner(String owner) {
        sessionFactory.getCurrentSession()
                .createQuery("DELETE weapon w WHERE w.owner=:param")
                .setParameter("param", owner)
                .executeUpdate();
    }

    @Override
    public void update(Weapon weapon) {
        sessionFactory.getCurrentSession().update(weapon);
    }

}

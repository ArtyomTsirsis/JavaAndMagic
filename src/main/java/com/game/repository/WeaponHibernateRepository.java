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
        sessionFactory.getCurrentSession().persist(new Weapon(weapon));
        return weapon;
    }

    @Override
    public Optional<Weapon> findById(Integer id) {
        Weapon toReturn = sessionFactory.getCurrentSession().get(Weapon.class, id);
        return Optional.ofNullable(toReturn);
    }

    @Override
    public List<Weapon> findByOwner(String owner) {
        return sessionFactory.getCurrentSession().createQuery("SELECT * FROM weapon WHERE owner=" + owner, Weapon.class).getResultList();
    }

    @Override
    public List<Weapon> findAll() {
        return sessionFactory.getCurrentSession().createNativeQuery("SELECT * FROM weapon", Weapon.class).getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        sessionFactory.getCurrentSession().delete(findById(id).get());
    }

    @Override
    public void deleteByOwner(String name) {
        sessionFactory.getCurrentSession().createQuery("DELETE FROM weapon WHERE owner=" + name);
    }

}

package com.game.repository;

import com.game.repository.hero.Hero;
import com.game.repository.hero.HeroRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Transactional
public class HeroHibernateRepository implements HeroRepository {

    private final SessionFactory sessionFactory;

    @Override
    public Hero save(Hero hero) {
        sessionFactory.getCurrentSession().save(hero);
        return hero;
    }

    @Override
    public Optional<Hero> findById(String heroName) {
        return Optional.ofNullable(sessionFactory
                .getCurrentSession()
                .get(Hero.class, heroName));
    }

    @Override
    public List<Hero> findAll() {
        return sessionFactory.getCurrentSession()
                .createNativeQuery("SELECT * FROM heroes", Hero.class)
                .getResultList();
    }

    @Override
    public void deleteById(String heroName) {
        sessionFactory.getCurrentSession()
                .createQuery("DELETE hero h WHERE h.name=:param")
                .setParameter("param", heroName)
                .executeUpdate();
    }

    @Override
    public void update(Hero hero) {
        sessionFactory.getCurrentSession().update(hero);
    }

}

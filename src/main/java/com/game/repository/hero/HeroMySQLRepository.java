package com.game.repository.hero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

//@Repository
public class HeroMySQLRepository implements HeroRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HeroMySQLRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Hero save(Hero hero) {
        String query = "INSERT INTO heroes(name, heroClass, health, strength, level, dexterity, weaponID, armorID, skillBook) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, hero.getName());
            ps.setString(2, hero.getHeroClass().toString());
            ps.setInt(3, hero.getHealth());
            ps.setInt(4, hero.getStrength());
            ps.setInt(5, hero.getLevel());
            ps.setInt(6, hero.getDexterity());
            ps.setInt(7, hero.getWeaponID());
            ps.setInt(8, hero.getArmorID());
            ps.setString(9, hero.getSkillBook());
            return ps;
        });
        return hero;
    }

    @Override
    public Optional<Hero> findById(String heroName) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * FROM heroes WHERE name=?",
                    new BeanPropertyRowMapper<>(Hero.class), heroName));
        }
        catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Hero> findAll() {
        return jdbcTemplate.query("SELECT * FROM heroes", new BeanPropertyRowMapper<>(Hero.class));
    }

    @Override
    public void deleteById(String heroName) {
        jdbcTemplate.update("DELETE FROM heroes WHERE name=?",  heroName);
    }


}

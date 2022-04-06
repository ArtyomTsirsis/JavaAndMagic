package com.game.repository;

import com.game.repository.weapon.Weapon;
import com.game.repository.weapon.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class WeaponMySQLRepository implements WeaponRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WeaponMySQLRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Weapon save(Weapon weapon) {
        String query = "INSERT INTO weapon(weaponType, owner, durability, physicalDamage, magicalDamage, level, " +
                " criticalHitChance) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, weapon.getWeaponType().toString());
            ps.setString(2, weapon.getOwner());
            ps.setInt(3, weapon.getDurability());
            ps.setInt(4, weapon.getPhysicalDamage());
            ps.setInt(5, weapon.getMagicalDamage());
            ps.setInt(6, weapon.getLevel());
            ps.setInt(7, weapon.getCriticalHitChance());
            return ps;
        }, keyHolder);
        weapon.setWeaponID(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return weapon;
    }

    @Override
    public Optional<Weapon> findById(Integer id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * FROM weapon WHERE weaponID=?",
                    new BeanPropertyRowMapper<>(Weapon.class), id));
        }
        catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Weapon> findByOwner(String owner) {
        return jdbcTemplate.query("SELECT * FROM weapon WHERE owner=?", new BeanPropertyRowMapper<>(Weapon.class), owner);
    }

    @Override
    public List<Weapon> findAll() {
        return jdbcTemplate.query("SELECT * FROM weapon", new BeanPropertyRowMapper<>(Weapon.class));
    }

    @Override
    public void deleteById(Integer id) {
        jdbcTemplate.update("DELETE FROM weapon WHERE weaponType=?",  id);
    }

    @Override
    public void deleteByOwner(String name) {
        jdbcTemplate.update("DELETE FROM weapon WHERE owner=?",  name);
    }

}

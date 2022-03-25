package com.game.repository;

import com.game.repository.weapon.Weapon;
import com.game.repository.weapon.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class WeaponMySQLRepository implements WeaponRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WeaponMySQLRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Weapon weapon) {
        String query = "INSERT INTO weapon(weaponType, whoCanUse, durability, physicalDamage, magicalDamage, level, criticalHitChance) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, weapon.getWeaponType().toString());
            ps.setString(2, Arrays.toString(weapon.getWhoCanUse()));
            ps.setInt(3, weapon.getDurability());
            ps.setInt(4, weapon.getPhysicalDamage());
            ps.setInt(5, weapon.getMagicalDamage());
            ps.setInt(6, weapon.getLevel());
            ps.setInt(7, weapon.getCriticalHitChance());
            return ps;
        });
    }

    @Override
    public Optional<Weapon> findById(Integer id) {
        return Optional.ofNullable(jdbcTemplate.
                queryForObject("SELECT * FROM weapon WHERE name=?",
                        new BeanPropertyRowMapper<>(Weapon.class), id));
    }

    @Override
    public List<Weapon> findAll() {
        return jdbcTemplate.query("SELECT * FROM weapon", new BeanPropertyRowMapper<>(Weapon.class));
    }

    @Override
    public void deleteById(Integer id) {
        jdbcTemplate.update("DELETE FROM weapon WHERE weaponType=?",  id);
    }

}

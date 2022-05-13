package com.game.repository.weapon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface WeaponRepository extends JpaRepository<Weapon, Integer> {

    List<Weapon> findByOwner(String owner);
    void deleteById(Integer id);
    void deleteByOwner(String name);
    @Modifying
    @Query("UPDATE weapon u SET durability = :#{#w.durability}, level = :#{#w.level} WHERE weaponID = :#{#w.weaponID}")
    void update(@Param("w") Weapon weapon);

}

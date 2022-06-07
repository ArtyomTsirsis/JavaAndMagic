package com.game.skills.enemy;

import com.game.dto.armor.ArmorDTO;
import com.game.dto.hero.HeroDTO;
import com.game.dto.weapon.WeaponDTO;
import com.game.domain.armor.ArmorClass;
import com.game.domain.enemy.Enemy;
import com.game.domain.enemy.Orc;
import com.game.domain.hero.HeroClass;
import com.game.domain.weapon.WeaponType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConcreteEnemySkillPowerAttackTest {

    @Mock
    private EnemyCriticalHitOrMissCalculator calculator;

    @InjectMocks
    private ConcreteEnemySkillPowerAttack concreteEnemySkillPowerAttack;

    /*
    * scenario1
    * input:
    * expected output:
     */
    @Test
    void scenario1() {
        ArmorDTO armorInput = new ArmorDTO(1, "Arthur", ArmorClass.WITHOUT_ARMOR, Integer.MAX_VALUE,
                0, 0);
        WeaponDTO weaponInput = new WeaponDTO(1, "Arthur", WeaponType.WITHOUT_WEAPON, Integer.MAX_VALUE,
                0, 0, 1, 0);
        HeroDTO heroInput = new HeroDTO("Arthur", HeroClass.KNIGHT, 400, 20,
                1, 10, armorInput, weaponInput, null);
        Enemy enemyInput = new Orc();
        int criticalHitOrMissInput = 2;
        when(calculator.getCriticalHitOrMissCoefficient(heroInput, enemyInput, new ConcreteEnemySkillPowerAttack()))
                .thenReturn(criticalHitOrMissInput);
        String actualReply = concreteEnemySkillPowerAttack.execute(heroInput, enemyInput);
        String expectedReply = "Промах!";
        assertEquals(expectedReply, actualReply);
    }


}
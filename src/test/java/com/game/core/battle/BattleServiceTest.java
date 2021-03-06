package com.game.core.battle;

import com.game.dto.battle.BattleRequest;
import com.game.dto.hero.HeroDTO;
import com.game.domain.armor.ArmorFactory;
import com.game.domain.enemy.Enemy;
import com.game.domain.enemy.Orc;
import com.game.domain.hero.Hero;
import com.game.domain.hero.HeroFactory;
import com.game.domain.weapon.WeaponFactory;
import com.game.skills.enemy.ConcreteEnemySkillPowerAttack;
import com.game.skills.enemy.EnemySkill;
import com.game.skills.hero.ConcreteHeroSkillFireDamage;
import com.game.skills.hero.HeroSkill;
import com.game.utils.ArmorDTOConverter;
import com.game.utils.HeroDTOConverter;
import com.game.utils.StringToSkillsDecoder;
import com.game.utils.WeaponDTOConverter;
import org.junit.jupiter.api.Test;

import static com.game.domain.armor.ArmorClass.WITHOUT_ARMOR;
import static com.game.domain.hero.HeroClass.WIZARD;
import static com.game.domain.weapon.WeaponType.WITHOUT_WEAPON;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class BattleServiceTest {

    private final BattleService battleService = new BattleService();
    private final HeroDTOConverter heroDTOConverter = new HeroDTOConverter(
            new StringToSkillsDecoder(),
            new ArmorDTOConverter(),
            new WeaponDTOConverter()
    );



    @Test
    void startBattleTest() {
        var hero = heroMaker();
        var battleRequest = battleRequest(heroDTOConverter.convertToDto(hero),
                new Orc(), new ConcreteHeroSkillFireDamage(), new ConcreteEnemySkillPowerAttack());
        var expectedResult = battleRequest(heroDTOConverter.convertToDto(hero),
                new Orc(), new ConcreteHeroSkillFireDamage(), new ConcreteEnemySkillPowerAttack());
        var result = battleService.startBattle(battleRequest);

        assertNotEquals(result.getEnemy().getHealth(), expectedResult.getEnemy().getHealth());

    }

    private BattleRequest battleRequest(HeroDTO hero, Enemy enemy, HeroSkill heroSkill, EnemySkill enemySkill) {
        var request = new BattleRequest();
        request.setHero(hero);
        request.setEnemy(enemy);
        request.setHeroSkill(heroSkill);
        request.setEnemySkill(enemySkill);
        return request;
    }

    private Hero heroMaker () {
        var hero = HeroFactory.createHero(WIZARD, "Rex");
        var armor = ArmorFactory.createArmor(WITHOUT_ARMOR);
        var weapon = WeaponFactory.createWeapon(WITHOUT_WEAPON);
        armor.setOwner(hero.getName());
        hero.setArmor(armor);
        hero.setWeapon(weapon);
        return hero;

    }
}
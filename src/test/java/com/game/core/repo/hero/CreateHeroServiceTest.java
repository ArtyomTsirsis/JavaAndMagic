package com.game.core.repo.hero;

import com.game.core.repo.armor.CreateArmorService;
import com.game.core.repo.weapon.CreateWeaponService;
import com.game.domain.armor.Armor;
import com.game.domain.armor.ArmorClass;
import com.game.domain.armor.ArmorFactory;
import com.game.domain.hero.Hero;
import com.game.domain.hero.HeroClass;
import com.game.domain.weapon.Weapon;
import com.game.domain.weapon.WeaponFactory;
import com.game.domain.weapon.WeaponType;
import com.game.dto.hero.CreateHeroRequest;
import com.game.dto.hero.CreateHeroResponse;
import com.game.dto.hero.HeroDTO;
import com.game.repository.HeroRepository;
import com.game.utils.HeroDTOConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateHeroServiceTest {

    @Mock
    private HeroRepository repository;

    @Mock
    private HeroDTOConverter converter;
    @Mock
    private CreateArmorService createArmorService;
    @Mock
    private CreateWeaponService createWeaponService;

    @InjectMocks
    private CreateHeroService createHeroService;

    @Test
    void shouldCreateHero() {
        when(repository.findById(any())).thenReturn(Optional.empty());
        when(repository.save(heroWithArmorAndWeapon())).thenReturn(heroWithArmorAndWeapon());
        when(createArmorService.createArmor(ArmorClass.WITHOUT_ARMOR, poorHero())).thenReturn(armor(poorHero()));
        when(createWeaponService.createWeapon(WeaponType.WITHOUT_WEAPON, heroWithArmor())).thenReturn(weapon(heroWithArmor()));
        when(converter.convertToDto(any())).thenReturn(heroDTO());
        var result = createHeroService.createHero(createHeroRequest());
        verify(repository).save(any());
        var expectedResult = new CreateHeroResponse(heroDTO());
        assertEquals(result, expectedResult);
    }

    private CreateHeroRequest createHeroRequest() {
        var hero = new HeroDTO();
        hero.setName("TEST NAME");
        return new CreateHeroRequest(HeroClass.KNIGHT, "TEST NAME");
    }

    private HeroDTO heroDTO() {
        var hero = new HeroDTO();
        hero.setHeroClass(HeroClass.KNIGHT);
        hero.setName("TEST NAME");
        return hero;
    }

    private Hero poorHero() {
        var hero = new Hero();
        hero.setName("TEST NAME");
        hero.setHeroClass(HeroClass.KNIGHT);
        hero.setDexterity(10);
        hero.setHealth(400);
        hero.setLevel(1);
        hero.setStrength(20);
        hero.setSkillBook("FastAttack, PowerAttack, Healing");
        return hero;
    }

    private Hero heroWithArmor() {
        var armor = ArmorFactory.createArmor(ArmorClass.WITHOUT_ARMOR);
        armor.setOwner("TEST NAME");
        var hero = new Hero();
        hero.setName("TEST NAME");
        hero.setHeroClass(HeroClass.KNIGHT);
        hero.setDexterity(10);
        hero.setHealth(400);
        hero.setLevel(1);
        hero.setStrength(20);
        hero.setSkillBook("FastAttack, PowerAttack, Healing");
        hero.setArmor(armor);
        return hero;
    }

    private Hero heroWithArmorAndWeapon() {
        var armor = ArmorFactory.createArmor(ArmorClass.WITHOUT_ARMOR);
        armor.setOwner("TEST NAME");
        var weapon = WeaponFactory.createWeapon(WeaponType.WITHOUT_WEAPON);
        weapon.setOwner("TEST NAME");
        var hero = new Hero();
        hero.setName("TEST NAME");
        hero.setHeroClass(HeroClass.KNIGHT);
        hero.setDexterity(10);
        hero.setHealth(400);
        hero.setLevel(1);
        hero.setStrength(20);
        hero.setSkillBook("FastAttack, PowerAttack, Healing");
        hero.setArmor(armor);
        hero.setWeapon(weapon);
        return hero;
    }

    private Armor armor(Hero hero) {
        var armor = ArmorFactory.createArmor(ArmorClass.WITHOUT_ARMOR);
        armor.setOwner(hero.getName());
        return armor;
    }

    private Weapon weapon(Hero hero) {
        var weapon = WeaponFactory.createWeapon(WeaponType.WITHOUT_WEAPON);
        weapon.setOwner(hero.getName());
        return weapon;
    }


}
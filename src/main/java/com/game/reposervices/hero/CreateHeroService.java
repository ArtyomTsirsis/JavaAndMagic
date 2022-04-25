package com.game.reposervices.hero;

import com.game.dto.armor.ArmorDTO;
import com.game.dto.armor.CreateArmorRequest;
import com.game.dto.hero.CreateHeroRequest;
import com.game.dto.hero.CreateHeroResponse;
import com.game.dto.weapon.CreateWeaponRequest;
import com.game.dto.weapon.WeaponDTO;
import com.game.reposervices.armor.CreateArmorService;
import com.game.reposervices.weapon.CreateWeaponService;
import com.game.repository.armor.ArmorClass;
import com.game.repository.hero.Hero;
import com.game.repository.hero.HeroFactory;
import com.game.repository.hero.HeroRepository;
import com.game.repository.weapon.WeaponType;
import com.game.utils.HeroDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.openmbean.KeyAlreadyExistsException;

@Component
public class CreateHeroService {

    @Autowired
    private HeroRepository repository;
    @Autowired
    private HeroDTOConverter converter;
    @Autowired
    private CreateArmorService createArmorService;
    @Autowired
    private CreateWeaponService createWeaponService;

    public CreateHeroResponse createHero(CreateHeroRequest request) throws KeyAlreadyExistsException {
        if (repository.findById(request.getName()).isPresent()) {
            throw new KeyAlreadyExistsException();
        }
        Hero hero = HeroFactory.createHero(request.getHeroClass(), request.getName());
        hero.setArmorID(createDefaultArmor(hero).getId());
        hero.setWeaponID(createDefaultWeapon(hero).getId());
        repository.save(hero);
        return new CreateHeroResponse(converter.convertToDto(hero));
    }

    private ArmorDTO createDefaultArmor(Hero hero) {
        return createArmorService
                .createArmor(new CreateArmorRequest(ArmorClass.WITHOUT_ARMOR, converter.convertToDto(hero)))
                .getArmor();
    }

    private WeaponDTO createDefaultWeapon(Hero hero) {
        return createWeaponService
                .createWeapon(new CreateWeaponRequest(WeaponType.WITHOUT_WEAPON, converter.convertToDto(hero)))
                .getWeapon();
    }

}

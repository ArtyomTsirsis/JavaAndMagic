package com.game.core.repo.hero;

import com.game.core.repo.armor.CreateArmorService;
import com.game.core.repo.weapon.CreateWeaponService;
import com.game.dto.hero.CreateHeroRequest;
import com.game.dto.hero.CreateHeroResponse;
import com.game.domain.armor.ArmorClass;
import com.game.domain.hero.Hero;
import com.game.domain.hero.HeroFactory;
import com.game.repository.HeroRepository;
import com.game.domain.weapon.WeaponType;
import com.game.utils.HeroDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.openmbean.KeyAlreadyExistsException;

@Service
@RequiredArgsConstructor
public class CreateHeroService {

    private final HeroRepository repository;
    private final HeroDTOConverter converter;
    private final CreateArmorService createArmorService;
    private final CreateWeaponService createWeaponService;

    @Transactional
    public CreateHeroResponse createHero(CreateHeroRequest request) throws KeyAlreadyExistsException {
        if (repository.findById(request.getName()).isPresent()) {
            throw new KeyAlreadyExistsException();
        }
        Hero hero = HeroFactory.createHero(request.getHeroClass(), request.getName());
        hero.setArmor(createArmorService.createArmor(ArmorClass.WITHOUT_ARMOR, hero));
        hero.setWeapon(createWeaponService.createWeapon(WeaponType.WITHOUT_WEAPON, hero));
        repository.save(hero);
        return new CreateHeroResponse(converter.convertToDto(hero));
    }

}

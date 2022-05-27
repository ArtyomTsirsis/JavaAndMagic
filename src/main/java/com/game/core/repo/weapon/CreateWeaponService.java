package com.game.core.repo.weapon;

import com.game.dto.weapon.CreateWeaponRequest;
import com.game.dto.weapon.CreateWeaponResponse;
import com.game.domain.hero.Hero;
import com.game.domain.weapon.Weapon;
import com.game.domain.weapon.WeaponFactory;
import com.game.repository.WeaponRepository;
import com.game.domain.weapon.WeaponType;
import com.game.utils.WeaponDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateWeaponService {

    private final WeaponRepository repository;
    private final WeaponDTOConverter converter;

    public CreateWeaponResponse createWeapon(CreateWeaponRequest request) {
        Weapon weapon = WeaponFactory.createWeapon(request.getWeaponType());
        weapon.setOwner(request.getHero().getName());
        return new CreateWeaponResponse(converter.convertToDto(repository.save(weapon)));
    }

    public Weapon createWeapon(WeaponType weaponType, Hero hero) {
        Weapon weapon = WeaponFactory.createWeapon(weaponType);
        weapon.setOwner(hero.getName());
        return repository.save(weapon);
    }

}

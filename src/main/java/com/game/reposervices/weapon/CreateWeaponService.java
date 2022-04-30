package com.game.reposervices.weapon;

import com.game.dto.weapon.CreateWeaponRequest;
import com.game.dto.weapon.CreateWeaponResponse;
import com.game.repository.hero.Hero;
import com.game.repository.weapon.Weapon;
import com.game.repository.weapon.WeaponFactory;
import com.game.repository.weapon.WeaponRepository;
import com.game.repository.weapon.WeaponType;
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

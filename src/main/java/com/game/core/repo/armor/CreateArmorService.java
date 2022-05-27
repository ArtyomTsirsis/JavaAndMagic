package com.game.core.repo.armor;

import com.game.dto.armor.CreateArmorRequest;
import com.game.dto.armor.CreateArmorResponse;
import com.game.domain.armor.Armor;
import com.game.domain.armor.ArmorClass;
import com.game.domain.armor.ArmorFactory;
import com.game.repository.ArmorRepository;
import com.game.domain.hero.Hero;
import com.game.utils.ArmorDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateArmorService {

    private final ArmorRepository repository;
    private final ArmorDTOConverter converter;

    public CreateArmorResponse createArmor(CreateArmorRequest request) {
        Armor armor = ArmorFactory.createArmor(request.getArmorClass());
        armor.setOwner(request.getHero().getName());
        return new CreateArmorResponse(converter.convertToDto(repository.save(armor)));
    }

    public Armor createArmor(ArmorClass armorClass, Hero hero) {
        Armor armor = ArmorFactory.createArmor(armorClass);
        armor.setOwner(hero.getName());
        return repository.save(armor);
    }

}

package com.game.reposervices.hero;

import com.game.core.repo.armor.CreateArmorService;
import com.game.core.repo.hero.CreateHeroService;
import com.game.core.repo.weapon.CreateWeaponService;
import com.game.repository.HeroRepository;
import com.game.utils.HeroDTOConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

    /*
    * scenario1
    * input:
    * expected output:
     */
    @Test
    void scenario1() {

    }
}
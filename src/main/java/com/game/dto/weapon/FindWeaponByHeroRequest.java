package com.game.dto.weapon;

import com.game.dto.hero.HeroDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class FindWeaponByHeroRequest {

    private HeroDTO hero;

}

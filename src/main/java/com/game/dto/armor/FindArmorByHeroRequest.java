package com.game.dto.armor;

import com.game.dto.hero.HeroDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class FindArmorByHeroRequest {

    private HeroDTO hero;

}

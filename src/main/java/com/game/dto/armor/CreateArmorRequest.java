package com.game.dto.armor;

import com.game.repository.hero.HeroClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateArmorRequest {

    private HeroClass heroClass;
    private String name;

}

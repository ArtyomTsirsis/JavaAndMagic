package com.game.dto.hero;

import com.game.repository.hero.HeroClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateHeroRequest {

    private HeroClass heroClass;
    private String name;

}

package com.game.dto.hero;

import com.game.repository.hero.HeroClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateHeroRequest {

    @NotNull
    private HeroClass heroClass;
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

}

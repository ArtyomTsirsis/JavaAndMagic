package com.game.dto.weapon;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FindAllWeaponResponse {

    private List<WeaponDTO> heroes;

}

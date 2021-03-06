package com.game.dto.weapon;

import com.game.domain.weapon.Weapon;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FindWeaponByOwnerResponse {

    private List<Weapon> weapons;

}

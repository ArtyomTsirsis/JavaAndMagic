package com.game.dto.armor;

import com.game.repository.armor.Armor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FindArmorByOwnerResponse {

    private List<Armor> armor;

}

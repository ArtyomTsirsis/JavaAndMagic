package com.game.dto.armor;

import com.game.repository.armor.ArmorClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateArmorRequest {

    private ArmorClass armorClass;

}

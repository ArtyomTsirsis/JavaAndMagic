package com.game.dto.armor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateArmorRequest {

    private ArmorDTO updatedArmorDTO;

}

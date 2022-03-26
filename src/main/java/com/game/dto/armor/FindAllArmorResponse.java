package com.game.dto.armor;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FindAllArmorResponse {

    private List<ArmorDTO> armor;

}

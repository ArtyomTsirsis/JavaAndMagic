package com.game.controller;

import com.game.dto.armor.CreateArmorRequest;
import com.game.dto.armor.FindArmorByOwnerResponse;
import com.game.reposervices.armor.CreateArmorService;
import com.game.reposervices.armor.DeleteArmorByOwnerService;
import com.game.reposervices.armor.FindArmorByOwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/armor")
@RequiredArgsConstructor
public class ArmorController {

    private final CreateArmorService createArmorService;
    private final FindArmorByOwnerService findArmorByOwnerService;
    private final DeleteArmorByOwnerService deleteArmorByOwnerService;

    @PutMapping(value = "/")
    public void createArmor(@RequestBody CreateArmorRequest request) {
        createArmorService.createArmor(request);
    }

    @GetMapping(value = "/{owner}")
    public FindArmorByOwnerResponse getArmor(@PathVariable String owner) {
        return findArmorByOwnerService.findByOwner(owner);
    }

    @DeleteMapping(value = "/{owner}")
    public void deleteArmor(@PathVariable String owner) {
        deleteArmorByOwnerService.deleteByOwner(owner);
    }

}

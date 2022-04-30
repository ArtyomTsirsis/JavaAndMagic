package com.game.controller;

import com.game.dto.weapon.CreateWeaponRequest;
import com.game.dto.weapon.FindWeaponByOwnerResponse;
import com.game.reposervices.weapon.CreateWeaponService;
import com.game.reposervices.weapon.DeleteWeaponByOwnerService;
import com.game.reposervices.weapon.FindWeaponByOwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weapon")
@RequiredArgsConstructor
public class WeaponController {

    private final CreateWeaponService createWeaponService;
    private final FindWeaponByOwnerService findWeaponByOwnerService;
    private final DeleteWeaponByOwnerService deleteWeaponByOwnerService;

    @PutMapping(value = "/")
    public void createArmor(@RequestBody CreateWeaponRequest request) {
        createWeaponService.createWeapon(request);
    }

    @GetMapping(value = "/{owner}")
    public FindWeaponByOwnerResponse getArmor(@PathVariable String owner) {
        return findWeaponByOwnerService.findByOwner(owner);
    }

    @DeleteMapping(value = "/{owner}")
    public void deleteArmor(@PathVariable String owner) {
        deleteWeaponByOwnerService.deleteByOwner(owner);
    }

}

package com.virtual_closet_organizer.controller;


import com.virtual_closet_organizer.dto.ClothesDto;
import com.virtual_closet_organizer.service.ClothesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/clothes")
public class ClothesController {

    private final ClothesService clothesService;

    public ClothesController(ClothesService clothesService) {
        this.clothesService = clothesService;
    }


    @PostMapping("/upload/{username}")
    public ResponseEntity<String> uploadClothes(@RequestBody ClothesDto clothesDto, @PathVariable String username) {

        clothesService.uploadClothes(clothesDto , username.trim());

        return ResponseEntity.ok("Clothes uploaded successfully");

    }
}

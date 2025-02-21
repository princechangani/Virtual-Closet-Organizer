package com.virtual_closet_organizer.controller;


import com.virtual_closet_organizer.service.SimpleEncryptDecryptService;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ened")
public class EncryptDecryptController {
    private final SimpleEncryptDecryptService simpleEncryptDecryptService;

    public EncryptDecryptController(SimpleEncryptDecryptService simpleEncryptDecryptService) {
        this.simpleEncryptDecryptService = simpleEncryptDecryptService;
    }


    /*  @GetMapping("/generateKey")
      public void generateKey(){
          hybridEncryptDecryptService.keyGenerator();
      }*/
    @PostMapping("/encryptData")

    public String encryptData(@RequestBody String plainText) throws Exception {
      return  simpleEncryptDecryptService.base64Encription(plainText);
    }
    @PostMapping("/decryptData")

    public String decryptData(@RequestBody String encryptedData) throws Exception {
       return simpleEncryptDecryptService.base64Decryption(encryptedData);
    }
}

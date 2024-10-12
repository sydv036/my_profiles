package com.example.profiles.core.admin.RestController;

import com.example.profiles.core.admin.service.IAccountService;
import com.example.profiles.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class AccountRestController {

//    @Autowired
//    private IAccountService accountService;
//
//    @GetMapping("/profile")
//    public ResponseEntity<?> getProfile() {
//        try {
//            List<Account> accountList = accountService.getAccounts();
//            return ResponseEntity.status(200).body(accountList);
//        } catch (Exception e) {
//            return ResponseEntity.status(400).body("Error");
//        }
//    }
//
//    @PostMapping("/profile")
//    public ResponseEntity<?> saveProfile(@RequestBody Account account) throws Exception {
//        try {
//            System.out.println(account);
//            return ResponseEntity.status(200).body(account);
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
//    }
}

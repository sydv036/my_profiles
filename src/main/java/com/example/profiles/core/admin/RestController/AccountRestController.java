package com.example.profiles.core.admin.RestController;

import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.service.IAccountService;
import com.example.profiles.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class AccountRestController {

    @Autowired
    private IAccountService accountService;

//    @GetMapping("/update-cv")
//    public ResponseEntity<?> getProfile() {
//        try {
//            List<Account> accountList = accountService.getAccounts();
//            return ResponseEntity.status(200).body(accountList);
//        } catch (Exception e) {
//            return ResponseEntity.status(400).body("Error");
//        }
//    }
//
    @PostMapping("/upd-cv")
    public ResponseEntity<?> saveProfile(@RequestBody DataRequest dataRequest) throws Exception {
        try {
            accountService.saveOrUpdate(dataRequest);
            return ResponseEntity.status(200).body("oke");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

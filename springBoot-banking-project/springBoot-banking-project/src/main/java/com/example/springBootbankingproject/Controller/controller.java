package com.example.springBootbankingproject.Controller;

import com.example.springBootbankingproject.Dto.AccountDto;
import com.example.springBootbankingproject.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/banking")
@AllArgsConstructor
public class controller {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> create_user(@RequestBody AccountDto accountDto)
    {
        AccountDto accnt = accountService.createAccount(accountDto);
        
        return new ResponseEntity<>(accnt, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<AccountDto> get_account(@RequestParam Long id)
    {
        return new ResponseEntity<>(accountService.retrieveAccount(id), CREATED);
    }

    @PutMapping
    public ResponseEntity<AccountDto> deposit(@RequestParam Long id,@RequestParam double amt)
    {
        return new ResponseEntity<>(accountService.deposit(id,amt),HttpStatus.OK);
    }

    @PutMapping("/withdrawl")
    public ResponseEntity<AccountDto> withdrawl(@RequestParam Long id,@RequestParam double amt)
    {
        return new ResponseEntity<>(accountService.withdrawl(id,amt),HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<AccountDto>> getallAccnts()
    {
        return new ResponseEntity<>(accountService.getallaccounts(),HttpStatus.OK );
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAccount(@RequestParam Long id)
    {
        accountService.deleteaccount(id);
        return new ResponseEntity<>("account deleted successfully",HttpStatus.OK);
    }


}

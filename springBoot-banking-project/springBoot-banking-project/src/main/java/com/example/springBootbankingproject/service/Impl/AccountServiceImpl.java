package com.example.springBootbankingproject.service.Impl;

import com.example.springBootbankingproject.Dto.AccountDto;
import com.example.springBootbankingproject.Entity.Account;
import com.example.springBootbankingproject.Repository.AccountRepository;
import com.example.springBootbankingproject.service.AccountService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accntRep;
    @Autowired
    private ModelMapper mod_map;
    @Override
    public AccountDto createAccount(AccountDto accnt) {
        Account account = mod_map.map(accnt, Account.class);
        Account saved_accnt = accntRep.save(account);

        return mod_map.map(saved_accnt,AccountDto.class);

    }

    @Override
    public AccountDto retrieveAccount(Long id) {
        return mod_map.map(accntRep.findById(id).get(),AccountDto.class);
    }

    @Override
    public AccountDto deposit(Long id, double dep_amount) {

        Account accnt = accntRep.findById(id).get();
        accnt.setBalance(accnt.getBalance()+dep_amount);

        return mod_map.map(accntRep.save(accnt),AccountDto.class);

    }

    @Override
    public AccountDto withdrawl(Long id, double wuthdrawl_amt) {
        Account accnt = accntRep.findById(id).get();
        accnt.setBalance(accnt.getBalance()-wuthdrawl_amt);

        return mod_map.map(accntRep.save(accnt),AccountDto.class);
    }

    @Override
    public List<AccountDto> getallaccounts() {
        List <AccountDto> accnts = accntRep.findAll().stream().map((accnt)-> mod_map.map(accnt,AccountDto.class)).collect(Collectors.toList());
        return accnts;

    }

    @Override
    public void deleteaccount(Long id) {
        accntRep.deleteById(id);
    }


}

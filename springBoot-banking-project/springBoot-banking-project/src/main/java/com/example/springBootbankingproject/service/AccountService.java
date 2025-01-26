package com.example.springBootbankingproject.service;

import com.example.springBootbankingproject.Dto.AccountDto;
import com.example.springBootbankingproject.Entity.Account;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accnt);

    AccountDto retrieveAccount(Long id);

    AccountDto deposit(Long id,double dep_amount);

    AccountDto withdrawl (Long id, double wuthdrawl_amt);

    List<AccountDto> getallaccounts();

    void deleteaccount (Long id);

}

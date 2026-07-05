package com.pravin.accounts.services;

import com.pravin.accounts.dtos.CustomerDto;

public interface IAccountsService {

    void createAccount(CustomerDto customerDto);
}

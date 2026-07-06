package com.pravin.accounts.services;

import com.pravin.accounts.dtos.CustomerDto;

public interface IAccountsService {

    /**
     *
     * @param customerDto - CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber
     * @return Accounts Details on a given mobile number
     */
    CustomerDto fetchAccount(String mobileNumber);

    /**
     *
     * @param customerDto
     * @return
     */
    boolean updateAccount(CustomerDto customerDto);
}

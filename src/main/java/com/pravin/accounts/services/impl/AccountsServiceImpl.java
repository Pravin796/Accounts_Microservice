package com.pravin.accounts.services.impl;

import com.pravin.accounts.Exceptions.CustomerAlreadyExitsException;
import com.pravin.accounts.constants.AccountsConstants;
import com.pravin.accounts.dtos.AccountsDto;
import com.pravin.accounts.dtos.CustomerDto;
import com.pravin.accounts.entity.Accounts;
import com.pravin.accounts.entity.Customer;
import com.pravin.accounts.mappers.CustomerMapper;
import com.pravin.accounts.repository.AccountsRepository;
import com.pravin.accounts.repository.CustomerRepository;
import com.pravin.accounts.services.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExitsException("Customer already registered with this mobile number " +  customerDto.getMobileNumber());
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));

    }

    private Accounts createNewAccount(Customer customer) {
        Accounts accounts = new Accounts();
        accounts.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(999999999);

        accounts.setAccountNumber(randomAccNumber);
        accounts.setAccountType(AccountsConstants.SAVINGS);
        accounts.setBranchAddress(AccountsConstants.ADDRESS);
        accounts.setCreatedAt(LocalDateTime.now());
        accounts.setCreatedBy("Anonymous");
        return accounts;
    }
}

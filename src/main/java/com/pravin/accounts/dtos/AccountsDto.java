package com.pravin.accounts.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold account information"
)
public class AccountsDto {

    @Schema(
            description = "Account number of the customer", example = "1234567890"
    )
    @NotEmpty(message = "Account number can not be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "AccountNumber must be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Type of the account", example = "Savings"
    )
    @NotEmpty(message = "AccountType can not be a null or empty")
    private String accountType;

    @Schema(
            description = "Branch address of the account", example = "123 Main Street, Chennai"
    )
    @NotEmpty(message = "Branch address can not be empty or null")
    private String branchAddress;
}

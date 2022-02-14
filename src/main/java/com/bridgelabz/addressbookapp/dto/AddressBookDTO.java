package com.bridgelabz.addressbookapp.dto;

import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public @ToString class AddressBookDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "First Name is Invalid")
    public String first_name;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Last Name is Invalid")
    public String last_name;

    @Min(value = 18, message = "Min Wage should be more than 18")
    public int age;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "City name is Invalid")
    public String city;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "State Name is Invalid")
    public String state;

    @Pattern(regexp = "^[0-9]{6}$", message = "Zipcode is Invalid")
    public long zipcode;

    @Pattern(regexp = "^[789]\\d{9}$", message = "Mobile Number should start with 7,8 or 9 and it should be 10 digit")
    public long phone_number;
}

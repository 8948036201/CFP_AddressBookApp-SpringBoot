package com.bridgelabz.addressbookapp.entity;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import lombok.Data;

@Data
public class AddressBookData {
    private int id;
    private String first_name;
    private String last_name;
    private int age;
    private String city;
    private String state;
    private long zipcode;
    private long phone_number;

    public AddressBookData(int id, AddressBookDTO addressBookDTO) {
        this.id=id;
        this.first_name = addressBookDTO.first_name;
        this.last_name = addressBookDTO.last_name;
        this.age = addressBookDTO.age;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.zipcode = addressBookDTO.zipcode;
        this.phone_number = addressBookDTO.phone_number;
    }
}

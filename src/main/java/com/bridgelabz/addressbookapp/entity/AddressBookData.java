package com.bridgelabz.addressbookapp.entity;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "person_details")
public @Data class AddressBookData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;


    private String first_name;
    private String last_name;
    private int age;
    private String city;
    private String state;
    private long zipcode;
    private long phone_number;

    public AddressBookData() {}

    public AddressBookData(AddressBookDTO addressBookDTO) {
        this.updateAddressBookData(addressBookDTO);
    }

    public void updateAddressBookData(AddressBookDTO addressBookDTO) {
       // this.id=id;
        this.first_name = addressBookDTO.first_name;
        this.last_name = addressBookDTO.last_name;
        this.age = addressBookDTO.age;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.zipcode = addressBookDTO.zipcode;
        this.phone_number = addressBookDTO.phone_number;
    }
}

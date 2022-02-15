package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.entity.AddressBookData;
import com.bridgelabz.addressbookapp.exceptions.AddressBookException;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AddressBookService implements  IAddressBookService{

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Override
    public List<AddressBookData> getAddressBookData() {
        return  addressBookRepository.findAll();
    }

    /*@Override
    public AddressBookData getAddressBookDataById(int id) {
        return null;
    }*/

    @Override
    public AddressBookData getAddressBookDataById(long id) {
        return addressBookRepository
                .findById(id)
                .orElseThrow( () -> new AddressBookException("AddressBook with Id " +
                        id + " does not exists..!!"));
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = null;
        addressBookData = new AddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }

    @Override
    public AddressBookData updateAddressBookData(long id,AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookDataById(id);
        addressBookData.updateAddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }

    @Override
    public void deleteAddressBookData(long id) {
        AddressBookData addressBookData = this.getAddressBookDataById(id);
        addressBookRepository.delete(addressBookData);
    }
}

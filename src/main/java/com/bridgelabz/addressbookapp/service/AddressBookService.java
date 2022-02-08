package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.entity.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements  IAddressBookService{

    @Override
    public List<AddressBookData> getData() {
        List<AddressBookData> addressBookData=new ArrayList<>();
        addressBookData.add(new AddressBookData(1,new AddressBookDTO("Azharuddin","Ansari"
                ,27,"Fazilnagar","UttarPradesh",274401,894803)));
        return  addressBookData;
    }

    @Override
    public AddressBookData getDataById(int id) {
        AddressBookData addressBookData=null;
        addressBookData=new AddressBookData(1,new AddressBookDTO("Azharuddin","Ansari"
                ,27,"Fazilnagar","UttarPradesh",274401,894803));
        return addressBookData;
    }

    @Override
    public AddressBookData addData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData=null;
        addressBookData=new AddressBookData(1,addressBookDTO);
        return addressBookData;
    }

    @Override
    public AddressBookData updateData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData=null;
        addressBookData=new AddressBookData(1,addressBookDTO);
        return addressBookData;
    }

    @Override
    public void deleteData(int id) {

    }
}

package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.entity.AddressBookData;
import com.bridgelabz.addressbookapp.service.IAddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
@Slf4j
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getAddressBookData(){
        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.getAddressBookData();
        ResponseDTO responseDTO=new ResponseDTO("get call success",addressBookDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("id") int id){
        AddressBookData addressBookData = null;
        addressBookData = addressBookService.getAddressBookDataById(id);
        ResponseDTO responseDTO=new ResponseDTO("get call for id success"+id, addressBookData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @PostMapping("/create")
    public  ResponseEntity<ResponseDTO> createAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO){
        log.debug("AddressBook DTO: "+addressBookDTO.toString());
        AddressBookData addressBookData=null;
        addressBookData=addressBookService.createAddressBookData(addressBookDTO);
        ResponseDTO responseDTO=new ResponseDTO("created AddressBook Data Successfully",addressBookData);
        return new  ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public  ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("id")int id,@Valid @RequestBody AddressBookDTO addressBookDTO){
        AddressBookData addressBookData=null;
        addressBookData=addressBookService.updateAddressBookData(id, addressBookDTO);
        ResponseDTO responseDTO=new ResponseDTO("updated AddressBook Data Successfully",addressBookData);
        return new  ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("id") int id){
        addressBookService.deleteAddressBookData(id);
        ResponseDTO responseDTO=new ResponseDTO("deleted Successfully","deleted id is : "+id);
        return new  ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}

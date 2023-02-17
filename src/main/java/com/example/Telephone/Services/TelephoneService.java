package com.example.Telephone.Services;


import com.example.Telephone.Model.Telephone;
import com.example.Telephone.Repository.TelephoneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelephoneService {


    @Autowired
    TelephoneRepository telephoneRepositoryObject;


    public void addContact(Telephone telephoneObject){
        telephoneRepositoryObject.save(telephoneObject);
    }

    public List<Telephone> displayAll(){
        return telephoneRepositoryObject.findAll();
    }

    public Optional<Telephone> displayById(int id){
        return telephoneRepositoryObject.findById(id);
    }

    public List<Telephone> displayByName(String name){
        return telephoneRepositoryObject.findByName(name);
    }

    public Optional<Telephone> displayByEmail(String email){
        return telephoneRepositoryObject.findByEmail(email);
    }

    public List<Telephone> displayByAddress(String address){
        return telephoneRepositoryObject.findByAddress(address);
    }

    public String Update(int id, Telephone telephoneObject){
        Optional<Telephone> newTelephoneObject = telephoneRepositoryObject.findById(id);
        if(newTelephoneObject!=null){
            telephoneRepositoryObject.deleteById(id);
            telephoneRepositoryObject.save(telephoneObject);
            return "Contact Updated";
        }
        return "Contact Not Updated";
    }

    public void deleteById(int id){
        telephoneRepositoryObject.deleteById(id);
    }

    public void deleteAll(){
        telephoneRepositoryObject.deleteAll();
    }
}

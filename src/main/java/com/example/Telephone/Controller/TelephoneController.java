package com.example.Telephone.Controller;

import com.example.Telephone.Model.Telephone;
import com.example.Telephone.Services.TelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class TelephoneController {

    @Autowired
    TelephoneService telephoneServiceObject;

    @PostMapping("/add")
    public String add(@RequestBody Telephone telephoneObject){
        telephoneServiceObject.addContact(telephoneObject);
        return "Contact Added";
    }

    @GetMapping("/display-All")
    public List<Telephone> display(){
        return telephoneServiceObject.displayAll();
    }

    @GetMapping("/display-by-id/{id}")
    public Optional<Telephone> displayById(@PathVariable int id){
        return telephoneServiceObject.displayById(id);
    }

    @GetMapping("/display-by-name/{name}")
    public List<Telephone> displayByName(@PathVariable String name){
        return telephoneServiceObject.displayByName(name);
    }

    @GetMapping("/display-by-address/{address}")
    public List<Telephone> displayByAddress(@PathVariable String address){
        return telephoneServiceObject.displayByAddress(address);
    }

    @GetMapping("/display-by-email/{email}")
    public Optional<Telephone> displayByEmail(@PathVariable String email){
        return telephoneServiceObject.displayByEmail(email);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestBody Telephone telephoneObject){
        return telephoneServiceObject.Update(id, telephoneObject);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public String deleteById(@PathVariable int id){
        telephoneServiceObject.deleteById(id);
        return "Contact Deleted";
    }

    @DeleteMapping("delete-all")
    public String deleteAll(){
        telephoneServiceObject.deleteAll();
        return "All Contact Deleted";
    }

}

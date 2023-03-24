package com.example.easynotes.controller;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.easynotes.model.Register;
import com.example.easynotes.repository.RegisterRepository;


@RestController
@RequestMapping("/reg")
public class RegController {
	@Autowired
    RegisterRepository regRepository;

    @GetMapping("/regs")
    public List<Register> getAllNotes() {
        return regRepository.findAll();
    }

    @PostMapping("/regs")
    public Register createNote(@Valid @RequestBody Register obj) {
        return regRepository.save(obj);
    }
    @PostMapping("/login")
    @ResponseBody
    public Register loginData(@Valid @RequestBody Register obj) {
       List<Register> lst= regRepository.findAll();
       Iterator it = lst.iterator();
       boolean flag=false;
       Register r=null;
       while(it.hasNext())
       {
    	   r= (Register)it.next();
    	   if(r.getUsername().equals(obj.getUsername()) && r.getPassword().equals(obj.getPassword()))
    	   {
    		   flag=true;
    		   
    		   break;
    	   }
       }
       if(!flag)
    	   r=null;
      return r;
    	
    }

}

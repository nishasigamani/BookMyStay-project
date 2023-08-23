package com.example.pro1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.pro1.model.bmsmodel;
import com.example.pro1.service.bmsservice;

@RestController
public class bmscontroller
{
	@Autowired
    public bmsservice bser;
    @PostMapping("/postbms")
    public String postbms(@RequestBody bmsmodel brr)
    {
    	bser.savebms(brr);
    	return "Data Saved Successfully";
    }
    @GetMapping("/getbms")
    	public List<bmsmodel>getbmsinfo()
    	{
    		return bser.getbms();
    	}
    @PutMapping("/putbms")
    	public bmsmodel updatebms(@RequestBody bmsmodel ba)
    	{
    		return bser.updatebms(ba);
    	}
    @PutMapping("/updatestay/{id}")
	public ResponseEntity<String>updateHotelInfo(@PathVariable int id,@RequestBody bmsmodel ba)
	{
		boolean updated=bser.updateStayif(id,ba);
		if(updated)
		{
			return ResponseEntity.ok("Stay with Id "+ id + " is updated  successfully");		
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Stay with Id "+ id + " is not found");
		}
	}
    @DeleteMapping("/reqparm")
    public String removeByRequestPam(@RequestParam("id") int id)
    {
    	bser.deletebms(id);
    	return id+" is deleted successfully";
    }
    @DeleteMapping("/deletestayif/{id}")
	public ResponseEntity<String>deleteHotelInfo(@PathVariable int id)
	{
		boolean deleted=bser.deleteStayif(id);
		if(deleted)
		{
			return ResponseEntity.ok("Stay with Id "+ id + " is deleted  successfully");		
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Stay with Id "+ id + " is not found");
		}
	}
    @GetMapping("/users/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable int userId)
	{
		Optional <bmsmodel>bms=bser.getUserId(userId);
		if(bms!=null)
		{
			return ResponseEntity.ok(bms);//Return the users data if avail
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("USER NOT AVAIL");
	}
}

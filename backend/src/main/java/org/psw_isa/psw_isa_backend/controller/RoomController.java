package org.psw_isa.psw_isa_backend.controller;

import org.psw_isa.psw_isa_backend.service.RoomService;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "room")
public class RoomController {
	
	@Autowired 
	RoomService roomService;
	
	@GetMapping(value="/all")
	public ResponseEntity<List<Room>> findAll(){
		return new ResponseEntity<>(roomService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Room> findOneByid(@PathVariable("id") Long id){
		return new ResponseEntity<>(roomService.findOneByid(id), HttpStatus.OK);
	}
	
	
}

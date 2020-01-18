package org.psw_isa.psw_isa_backend.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.psw_isa.psw_isa_backend.models.Room;
import org.psw_isa.psw_isa_backend.models.Clinic;
import org.psw_isa.psw_isa_backend.dtos.RoomDTO;
import org.psw_isa.psw_isa_backend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	ClinicAdminService clinicAdminService;
	
	public List<Room> findAll() {
		return roomRepository.findAll();
	}
	
	public List<Room> findAllInClinic(Clinic clinic) {
		List<Room> res = new ArrayList<>();
		List<Room> rooms = this.findAll();
		for (Room r : rooms)
		{
			if (r.getClinic() != null) 
			{
				if(r.getClinic().getId() == clinic.getId()) 
				{
					res.add(r);
				}
			}
		}
		return res;
	}
	
	
	public Room findOneByid(Long id) {
		return roomRepository.findOneByid(id);
	}
	public Room save(RoomDTO room) {
		return roomRepository.save(new Room(room.getTitle(), clinicAdminService.getClinic(), room.getCapacity()));
	}
	public Room update(RoomDTO room) {
		Room newRoom = findOneByid(room.getId());
		newRoom.setTitle(room.getTitle());
		newRoom.setCapacity(room.getCapacity());
		roomRepository.save(newRoom);
		return newRoom;
	}

	public Long delete(Long id) {
		roomRepository.delete(findOneByid(id));
		return id;
	}

}

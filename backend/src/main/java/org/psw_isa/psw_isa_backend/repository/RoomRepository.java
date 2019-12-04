package org.psw_isa.psw_isa_backend.repository;

import org.psw_isa.psw_isa_backend.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

	public Room findOneByid(Long id);
	public List<Room> findAll();
	
}

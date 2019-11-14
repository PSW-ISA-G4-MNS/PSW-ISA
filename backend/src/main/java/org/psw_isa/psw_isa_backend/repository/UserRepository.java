package org.psw_isa.psw_isa_backend.repository;

import org.psw_isa.psw_isa_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findOneByemail(String email);

}

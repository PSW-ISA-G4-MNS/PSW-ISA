package org.psw_isa.psw_isa_backend.repository;

import java.time.LocalDate;

import org.psw_isa.psw_isa_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findOneByid(Long id);
	User findOneByemail(String email);
	List<User> findAll();

	@Modifying
	@Query(value = "UPDATE User u SET u.firstname = :firstname, u.lastname = :lastname, u.address = :address, u.birthday = :birthday, u.mobile_phone = :mobile_phone WHERE u.id = :id", nativeQuery = true)
	public int updateUser(@Param("firstname") String firstname, @Param("lastname") String lastname, @Param("address") String address, @Param("birthday") LocalDate birthday, @Param("mobile_phone") String mobile_phone, @Param("id") Long id);


}

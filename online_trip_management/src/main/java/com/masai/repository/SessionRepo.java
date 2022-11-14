package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.masai.bean.CurrentUserSession;

public interface SessionRepo extends JpaRepository<CurrentUserSession, Integer>{
	
	public  CurrentUserSession  findByUuid(String uuid);

}

package com.example.pro1.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pro1.model.bmsmodel;

import jakarta.transaction.Transactional;

public interface bmsrepo extends JpaRepository <bmsmodel,Integer>
{
	@Modifying
	@Transactional
	@Query (value="delete from booking where id=:id1", nativeQuery=true)
	public int deleteId(@Param("id1") int id);
	
	@Query (value="select * from booking",nativeQuery=true)
	public List<bmsmodel> getAllrows();
}

































































































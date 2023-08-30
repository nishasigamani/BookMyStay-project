package com.example.pro1.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.example.pro1.model.bmsmodel;
import com.example.pro1.repo.bmsrepo;

@Service
public class bmsservice 
{
     @Autowired
	public bmsrepo brepo;
	public String savebms(bmsmodel b)
	{
		brepo.save(b);
		return "DATA IS SUCCESSFULLY SAVED";
	}
	public List<bmsmodel> getbms()
	{
		return brepo.findAll();
	}
//	public boolean updateStayif(int bid,bmsmodel bm)
//	{
//		if(brepo.existsById(bid))
//		{
//			brepo.save(bm);
//			return true;
//		}
//		return false;
//	}
//	public bmsmodel updatebms(bmsmodel bm)
//	{
//		return brepo.saveAndFlush(bm);
//	}
//	public boolean deleteStayif(int hid)
//	{
//		if(brepo.existsById(hid))
//		{
//			brepo.deleteById(hid);
//			return true;
//		}
//		return false;
//	}
//	public void deletebms(int id)
//	{
//		System.out.print("SUCCESSFULLY DELETED");
//		brepo.deleteById(id);
//	}
//	public Optional<bmsmodel> getUserId(int userId)
//	{
//		Optional<bmsmodel> hotel=brepo.findById(userId);
//		if(hotel.isPresent())
//		{
//			return hotel;
//		}
//		return null;
//	}
	public List<bmsmodel>sortByAsc(String location)
	{
		return brepo.findAll(Sort.by(location).ascending());
	}
	public List<bmsmodel> pagination(int pgno,int pgs)
	{
		Page<bmsmodel> cont=brepo.findAll(PageRequest.of(pgno,pgs));
		return cont.getContent();
	}
	public List<bmsmodel>paginationAndSorting(int pgno,int pgs,String location)
	{
		Page<bmsmodel> cont1=brepo.findAll(PageRequest.of(pgno,pgs,Sort.by(location)));
		return cont1.getContent();
	}
	public List<bmsmodel> getAllrows()
	{
		return brepo.getAllrows();
	}
	public int deleteRowByid(int id)
	{
		return brepo.deleteId(id);
	}
}

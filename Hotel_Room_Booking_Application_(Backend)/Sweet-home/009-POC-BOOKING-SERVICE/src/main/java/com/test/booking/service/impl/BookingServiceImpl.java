package com.test.booking.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.booking.binding.BookingBinding;
import com.test.booking.entity.BookingEntity;
import com.test.booking.feign.TransactionFeignProxy;
import com.test.booking.feign.binding.TrancationBinding;
import com.test.booking.repository.BookingRepository;
import com.test.booking.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService
{
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private TransactionFeignProxy transactionFeignProxy;

	@Override
	public String bookRoom(BookingBinding bes)
	{
		BookingEntity entity = new BookingEntity();

		int numberOfRoom = bes.getNumberOfRoom();
		int totalPrice = numberOfRoom * 1000;
		bes.setTotalPrice(totalPrice);
		
		BeanUtils.copyProperties(bes, entity);	
		BookingEntity data = bookingRepository.save(entity);
		
		
		if(data.getId() != null)
		{
			return "Record saved...!!";
		}
		
		return "Booking faild to save...!!!";
		
	}

	@Override
	public String updateBooking(BookingBinding beu) 
	{
		BookingEntity EntityData = bookingRepository.findById(beu.getId()).orElse(null);
		
		if(EntityData  != null)
		{
			EntityData.setAadharNumber(beu.getAadharNumber());
			EntityData.setCustomerName(beu.getCustomerName());
			EntityData.setFromDate(beu.getFromDate());
			EntityData.setNumberOfRoom(beu.getNumberOfRoom());
			EntityData.setToDate(beu.getToDate());
			
			int numOfRoom = beu.getNumberOfRoom();
			int totalPrice = numOfRoom * 1000;
			
			EntityData.setTotalPrice(totalPrice);				
			EntityData.setUpdateDate(beu.getUpdateDate());
			
			bookingRepository.save(EntityData);
		}
			return" Record is updated...!!!";
	}

	@Override
	public BookingBinding deleteBooking(int id)
	{	
		bookingRepository.deleteById(id);
		return null;
	}

	@Override
	public List<BookingBinding> allBookingDetails() 
	{
		List<BookingBinding> BookingBindingList=new ArrayList<>();
		
		List<BookingEntity> findAll = bookingRepository.findAll();
		
		for(BookingEntity entity : findAll)
		{
			BookingBinding cb=new BookingBinding();
			BeanUtils.copyProperties(entity,cb);
			BookingBindingList.add(cb);
		}
		return BookingBindingList;

	}

	
// ================= Feign Transaction Payment Methods ================= 
	
	
	
	@Override
	public String doPayment(TrancationBinding tdb) 
	{
		transactionFeignProxy.doPayment(tdb);
		return null;
	}

	@Override
	public String updateTransaction(TrancationBinding tdb) 
	{
		transactionFeignProxy.updateTransaction(tdb);
		return null;
	}

	@Override
	public List<TrancationBinding> getAllTransaction()
	{
     	return	transactionFeignProxy.getAllTransaction();
		 
	}

	@Override
	public String deleteTRansaction(int id) 
	{
		transactionFeignProxy.deleteTRansaction(id);
		return null;
	}

	
}

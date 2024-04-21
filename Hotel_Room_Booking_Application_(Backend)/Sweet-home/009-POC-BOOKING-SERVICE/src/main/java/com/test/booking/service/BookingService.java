package com.test.booking.service;
import java.util.List;

import com.test.booking.binding.BookingBinding;
import com.test.booking.feign.binding.TrancationBinding;

public interface BookingService
{
	public String bookRoom(BookingBinding bes);
	
	public String updateBooking(BookingBinding beu);
	
	public BookingBinding deleteBooking(int id);
	
	public List<BookingBinding> allBookingDetails();


	// ================= Feign Transaction Payment Methods ================= 
	

	public String doPayment(TrancationBinding tdb);
	
	public String updateTransaction(TrancationBinding tdb);
	
	public List<TrancationBinding> getAllTransaction();
	
	public String deleteTRansaction(int id);

}



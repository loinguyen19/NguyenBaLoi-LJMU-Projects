package com.test.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.booking.binding.BookingBinding;
import com.test.booking.feign.binding.TrancationBinding;
import com.test.booking.service.BookingService;


@RestController
@RequestMapping("/bookingRoom")
public class BookingController 
{
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("")
	public String BookRoom(@RequestBody BookingBinding be)
	{
		bookingService.bookRoom(be);
		return" Room Booked...!!!  Thanks For Booking....!!  || Visite Again ||";
	}
	
	@GetMapping("")
	public List<BookingBinding> getAllBookingDetails()
	{
		return bookingService.allBookingDetails();
	}
	
	@DeleteMapping("/{id}")
	public String bookingDelete(@PathVariable int id)
	{
		bookingService.deleteBooking(id);
		return "Booking Record is deleted....!!!";
	}
	
	@PutMapping("")
	public String bookingUpdate(@RequestBody BookingBinding bb)
	{
		bookingService.updateBooking(bb);
		return "Record is updated....!!!";
	}
	
	// ================= Feign Transaction Payment Methods ================= 
	

	@PostMapping("/payment")
	public String doPayment(@RequestBody TrancationBinding tdb)
	{
		if(tdb.getPaymentMode().contains("CARD"))
		{
			bookingService.doPayment(tdb);
		}
		else
		{
			return "Ooppsss....Payment Mode is not match....!!! We can accept only || CARD || mode...!!!";
		}
		
		return"Paymemnt is succeffully paid...!!! Thanks... || Visite Again ||";
	}
	
	@PutMapping("/payment")
	public String updateTransaction(@RequestBody TrancationBinding tdb)
	{
		bookingService.updateTransaction(tdb);
		return"Transaction is updated....!!!";
	}
	
	@GetMapping("/payment")
	public List<TrancationBinding> getAllTransaction()
	{
		
		return bookingService.getAllTransaction();
	}
	
	@DeleteMapping("/payment/{id}")
	public String deleteTRansaction(@PathVariable int id)
	{
		bookingService.deleteTRansaction(id);
		return "Transaction is deleted....!!!";
	}

}

package com.payment.controller;

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

import com.payment.binding.TransactionDetailsBinding;
import com.payment.service.TransactionDetailsService;

@RestController
@RequestMapping("/transaction")
public class TransactionDetailsController 
{
	@Autowired
	private TransactionDetailsService service;
	
	@PostMapping("/")
	public String doPayment(@RequestBody TransactionDetailsBinding tdb)
	{
		if(tdb.getPaymentMode().contains("CARD"))
		{
			service.doPayment(tdb);
		}
		else
		{
			return "Ooppsss....Payment Mode is not match....!!! We can accept only || CARD || mode...!!!";
		}
		
		
		return"Paymemnt is succeffully paid...!!! Thanks... || Visite Again ||";
	}
	
	@PutMapping("/")
	public String updateTransaction(@RequestBody TransactionDetailsBinding tdb)
	{
		service.updateTransaction(tdb);
		return"Transaction is updated..!!";
	}
	
	@GetMapping("/")
	public List<TransactionDetailsBinding> getAllTransaction()
	{
		return service.getAllTransaction();
	}
	
	@DeleteMapping("/{id}")
	public String deleteTRansaction(@PathVariable int id)
	{
		service.deleteTRansaction(id);
		return "Transaction is deleted...!!";
	}
}

package com.test.booking.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.test.booking.feign.binding.TrancationBinding;


@FeignClient(name = "PAYMENT-SERVICE")
public interface TransactionFeignProxy 
{
	@PostMapping("transaction/")
	public String doPayment(@RequestBody TrancationBinding tdb);
	
	@PutMapping("transaction/")
	public String updateTransaction(@RequestBody TrancationBinding tdb);
	
	@GetMapping("transaction/")
	public List<TrancationBinding> getAllTransaction();
	
	@DeleteMapping("transaction/{id}")
	public String deleteTRansaction(@PathVariable int id);
}

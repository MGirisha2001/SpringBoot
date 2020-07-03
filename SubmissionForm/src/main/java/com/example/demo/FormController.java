package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class FormController{
	@Autowired
	CustomerRepo repo;
	@RequestMapping("/")
	public String details()
	{
		return "fun";
	
	}
	
	@RequestMapping("/details")
	public String details(Customers customers)
	{
		repo.save(customers);
		return "fun";
	
	}
	
	@RequestMapping("/getdetails")
	public String getdetails()
	{
		
		return "ViewCustomers";
	
	}
	
	
 @PostMapping("/getdetails")
	
	public ModelAndView getdetails( @RequestParam int cid)
		
	{
	 ModelAndView mv = new ModelAndView("Retrive");
	Customers customers=repo.findById(cid).orElse(null);
	mv.addObject(customers);
	return mv;
	} 
 
 @RequestMapping("/customers")
 @ResponseBody
 public String getCustomers()
 {
	 return repo.findAll(). toString();
 }
 
 @RequestMapping("/customers/{cid}")
 @ResponseBody
 
 public String getCustomers2(@PathVariable("cid") int cid)
 {
	 return repo.findById(cid).toString();
 }
}

	





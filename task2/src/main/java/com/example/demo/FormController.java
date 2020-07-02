
package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Optional;

@Controller
public class FormController{
	@Autowired
	PlantMasterRepo repo;
	@RequestMapping("/")
	public String details()
	{
		return "function";
	
	}
	@RequestMapping("/details")
	
	public String details(PlantMaster customers)
	{
		
		repo.save(customers);
		return "function";
	
	}
	
	@RequestMapping("/getdetails")
	public String getdetails()
	{
		
		return "ViewCustomers";
	
	}
	
	
 @PostMapping("/getdetails")
	
	public ModelAndView getdetails( @RequestParam String FullName)
		
	{
	 ModelAndView mv = new ModelAndView("Retrive");
	PlantMaster customers=repo.findById(FullName).orElse(null);
	mv.addObject(customers);
	return mv;
	} 
	
	
	@RequestMapping("/customers")
	@ResponseBody
	public List<PlantMaster> getCustomers()
	{
		return repo.findAll();
		}
	
	@RequestMapping("/customers/{FullName}")
	@ResponseBody
	public Optional<PlantMaster> getCustomers2(@PathVariable("FullName") String FullName)
	{
		return repo.findById(FullName);
		}
	
	@PostMapping("/customers")
	public PlantMaster getCustomers3(@RequestBody PlantMaster customers)
	{
		repo.save(customers);
		return customers;
	}
	@PutMapping(path="/customers", consumes= {"application/json"})
	public PlantMaster getCustomers4(@RequestBody PlantMaster customers)
	{
		repo.save(customers);
		return customers;
	}
	
	@DeleteMapping("/customers/{FullName}")
	public PlantMaster getCustomers5(@PathVariable ("FullName") String FullName)
	{
		PlantMaster pm=repo.getOne(FullName);
		repo.delete(pm);
		return pm;
	}
	
	
}
	
	


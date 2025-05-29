package in.scalive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.scalive.entity.Emp;
import in.scalive.exception.EmpAlreadyExistsException;
import in.scalive.exception.ErrorResponse;
import in.scalive.exception.NoSuchEmpExistsException;
import in.scalive.service.EmpService;

@RestController
@RequestMapping("/api/emp")
public class EmpController {
    private EmpService serv;
    
    @Autowired
	public EmpController(EmpService serv) {
		this.serv = serv;
	}
    //Add
    @PostMapping("/add")
    public String addEmp(@RequestBody Emp emp) {
    	return serv.addEmp(emp);
    }
    
    //fetch
    @GetMapping("/{empId}")
    public Emp getEmp(@PathVariable("empId")Integer empId) {
    	return serv.getEmp(empId);
    }
    
    //update
    @PutMapping("/update/{empId}")
    public String updateEmp(@RequestBody Emp updatedEmp,@PathVariable("empId") Integer empId) {
    	return serv.updateEmp(updatedEmp, empId);
    }
    
    //delete
    @DeleteMapping("/delete/{empId}")
    public String deleteEmp(@RequestBody Emp deleteEmp, @PathVariable("empId")  Integer empId) {
    	return serv.deleteEmp(deleteEmp, empId);
    }
    
    
}

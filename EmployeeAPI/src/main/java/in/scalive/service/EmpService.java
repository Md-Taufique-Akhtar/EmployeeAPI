package in.scalive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.scalive.entity.Emp;
import in.scalive.exception.EmpAlreadyExistsException;
import in.scalive.exception.NoSuchEmpExistsException;
import in.scalive.repository.EmpRepository;

@Service
public class EmpService {
  
	private EmpRepository empRepo;
    @Autowired
	public EmpService(EmpRepository empRepo) {
    	this.empRepo=empRepo;
    }
    
    //Add
    public String addEmp(Emp emp) {
    Emp e=empRepo.findByEname(emp.getEname()).orElse(null);
    if(e!=null) {
    	throw new EmpAlreadyExistsException("Emp with name "+emp.getEname()+" already exists");
      }
     empRepo.save(emp);
     return "Emp saved successfully!";
    }
    
    //fetch
    public Emp getEmp(Integer empId) {
    	Emp e=empRepo.findById(empId).orElse(null);
        if(e==null) {
        	throw new NoSuchEmpExistsException("Emp with id"+empId+" does not exist");
          }
        return e;
    }
    
    //update
    public String updateEmp(Emp emp,Integer empId) {
    	Emp e=empRepo.findById(empId).orElse(null);
        if(e==null) {
        	throw new NoSuchEmpExistsException("Emp with id"+empId+" does not exist");
          }
        e.setEname(emp.getEname());
        e.setSal(emp.getSal());
        empRepo.save(e);
        return "Emp updated successfully!";
    	
    }
    
    
    //delete
   public String deleteEmp(Integer empId) {
	    Emp emp = empRepo.findById(empId).orElse(null);

	    if (emp == null) {
	        throw new NoSuchEmpExistException("Emp with ID " + empId + " does not exist");
	    }

	    empRepo.delete(emp);

	    return "Emp with ID " + empId + " deleted successfully!";
	}
}

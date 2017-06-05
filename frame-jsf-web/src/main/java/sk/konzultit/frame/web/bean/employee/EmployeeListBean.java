package sk.konzultit.frame.web.bean.employee;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import sk.konzultit.frame.service.employee.EmployeeService;
import sk.loveit.frame.persist.entity.Employee;

 
@ManagedBean(name="employeeListBean")
@ViewScoped
public class EmployeeListBean implements Serializable {

	private static final long serialVersionUID = 5897979677517122019L;

	private LazyDataModel<Employee> employeeLazyModel;
    
    private Employee selectedEmployee;
     
    @ManagedProperty("#{employeeService}")
    private EmployeeService service;
     
    @PostConstruct
    public void init() {
    	List<Employee> listOfEmployee = service.findAll();
    	employeeLazyModel = new LazyEmployeeDataModel(listOfEmployee);
    }
 
    public LazyDataModel<Employee> getEmployeeLazyModel() {
        return employeeLazyModel;
    }
       
    public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}

	public void setService(EmployeeService service) {
        this.service = service;
    }
     
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Employee Selected " + ((Employee) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	
}
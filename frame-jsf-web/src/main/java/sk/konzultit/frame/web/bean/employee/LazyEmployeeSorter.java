package sk.konzultit.frame.web.bean.employee;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import sk.loveit.frame.persist.entity.Employee;

public class LazyEmployeeSorter implements Comparator<Employee> {
	 
    private String sortField;
     
    private SortOrder sortOrder;
     
    public LazyEmployeeSorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
 
    @SuppressWarnings(value={"unchecked","rawtypes"})
	public int compare(Employee employee1, Employee employee2) {
        try {
            Object value1 = Employee.class.getField(this.sortField).get(employee1);
            Object value2 = Employee.class.getField(this.sortField).get(employee2);
 
			int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
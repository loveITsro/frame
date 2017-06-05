package sk.konzultit.frame.web.bean.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import sk.loveit.frame.persist.entity.Employee;

public class LazyEmployeeDataModel extends LazyDataModel<Employee> {

	private static final long serialVersionUID = 7554186656242491520L;
	private List<Employee> datasource;

	public LazyEmployeeDataModel(List<Employee> datasource) {
		this.datasource = datasource;
	}

	@Override
	public Employee getRowData(String rowKey) {
		for (Employee employee : datasource) {
			if (Long.toString(employee.getId()).equals(rowKey))
				return employee;
		}

		return null;
	}

	@Override
	public Object getRowKey(Employee employee) {
		return employee.getId();
	}

	@Override
	public List<Employee> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		List<Employee> data = new ArrayList<Employee>();

		// filter
		for (Employee employee : datasource) {
			boolean match = true;

			if (filters != null) {
				for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
					try {
						String filterProperty = it.next();
						Object filterValue = filters.get(filterProperty);
						String fieldValue = String.valueOf(employee.getClass().getField(filterProperty).get(employee));

						if (filterValue == null || fieldValue.startsWith(filterValue.toString())) {
							match = true;
						} else {
							match = false;
							break;
						}
					} catch (Exception e) {
						match = false;
					}
				}
			}

			if (match) {
				data.add(employee);
			}
		}

		// sort
		if (sortField != null) {
			Collections.sort(data, new LazyEmployeeSorter(sortField, sortOrder));
		}

		// rowCount
		int dataSize = data.size();
		this.setRowCount(dataSize);

		// paginate
		if (dataSize > pageSize) {
			try {
				return data.subList(first, first + pageSize);
			} catch (IndexOutOfBoundsException e) {
				return data.subList(first, first + (dataSize % pageSize));
			}
		} else {
			return data;
		}
	}
}

package com.fdaindia.hrms.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fdaindia.hrms.entity.DeletedEmployee;
import com.fdaindia.hrms.entity.Employee;
import com.fdaindia.hrms.exceptions.ResourceNotFoundException;
import com.fdaindia.hrms.repository.DeletedEmployeeRepo;
import com.fdaindia.hrms.repository.EmployeeRepo;
import com.fdaindia.hrms.response.ReportResponse;
import com.fdaindia.hrms.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private DeletedEmployeeRepo deletedEmployeeRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Map<String, Object> addOrUpdate(Employee employee) {
		Map<String, Object> response = new HashMap<>();

		// Check if username already exists
		Optional<Employee> existingEmployee = employeeRepo.findByUsername(employee.getUsername());
		if (existingEmployee.isPresent() && !existingEmployee.get().getId().equals(employee.getId())) {
			response.put("status", "FAILURE");
			response.put("message", "Username already exists.");
		} else {
			// Save employee if username is unique
			Employee savedEmployee = employeeRepo.save(employee);
			response.put("data", savedEmployee);
			response.put("status", "SUCCESS");
		}

		return response;
	}

	@Override
	public Employee getEmployeeById(Long employeeId) {
		return employeeRepo.findById(employeeId).orElseThrow(() -> {
			return new ResourceNotFoundException("Employee", "employeeId", employeeId);
		});
	}

	@Override
	public List<Employee> getAll(Pageable pageable) {
		Page<Employee> pageEmployee = employeeRepo.findAll(pageable);
		return pageEmployee.getContent();
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee = employeeRepo.findById(employeeId).orElseThrow(() -> {
			return new ResourceNotFoundException("employee", "employee Id", employeeId);
		});

		DeletedEmployee deletedEmployee = modelMapper.map(employee, DeletedEmployee.class);
		deletedEmployee.setOriginalId(employee.getId());
		deletedEmployee.setDeletionTime(LocalDateTime.now());

		deletedEmployeeRepo.save(deletedEmployee);
		employeeRepo.delete(employee);
	}

	@Override
	public List<Employee> searchEmployee(String query, Pageable pageable) {
		List<Employee> employees = employeeRepo.searchEmployee(query, pageable).getContent();
		if (employees.isEmpty()) {
			throw new ResourceNotFoundException("Employee", "query", query);
		}
		return employees;
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		return employeeRepo.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "email", email));
	}

	@Override
	public List<ReportResponse> fetchReportResponses() {
		return employeeRepo.fetchReportResponses();
	}

	@Override
	public ByteArrayInputStream exportEmployeesToExcel(List<ReportResponse> employees) throws IOException {
		String[] columns = { "User Name", "Date Of Joining", "Employee Number", "Date Of Birth", "Address",
				"Contact Number", "Email", "Branch", "Department Name", "Designation Name" };

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			Sheet sheet = workbook.createSheet("Employees");

			// Create header row
			Row headerRow = sheet.createRow(0);
			for (int col = 0; col < columns.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(columns[col]);
			}

			// Create data rows
			int rowIdx = 1;
			for (ReportResponse employee : employees) {
				Row row = sheet.createRow(rowIdx++);
				row.createCell(0).setCellValue(employee.getusername());
				row.createCell(1).setCellValue(employee.getdateOfJoining());
				row.createCell(2).setCellValue(employee.getemployeeNumber());
				row.createCell(3).setCellValue(employee.getdateOfBirth());
				row.createCell(4).setCellValue(employee.getaddress());
				row.createCell(5).setCellValue(employee.getcontactNumber());
				row.createCell(6).setCellValue(employee.getemail());
				row.createCell(7).setCellValue(employee.getbranch());
				row.createCell(8).setCellValue(employee.getdepartmentName());
				row.createCell(9).setCellValue(employee.getdesignationName());
			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
}

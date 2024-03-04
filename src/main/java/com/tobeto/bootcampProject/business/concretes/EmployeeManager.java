package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.BaseService;
import com.tobeto.bootcampProject.business.abstracts.EmployeeService;
import com.tobeto.bootcampProject.business.requests.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcampProject.business.requests.update.employee.UpdateEmployeeRequest;
import com.tobeto.bootcampProject.business.responses.create.employee.CreateEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetAllEmployeeResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetEmployeeByIdResponse;
import com.tobeto.bootcampProject.business.responses.get.employee.GetEmployeeByPositionResponse;
import com.tobeto.bootcampProject.business.responses.update.employee.UpdateEmployeeResponse;
import com.tobeto.bootcampProject.business.rules.BusinessRules;
import com.tobeto.bootcampProject.core.exceptions.types.BusinessException;
import com.tobeto.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcampProject.core.utilities.paging.PageDto;
import com.tobeto.bootcampProject.core.utilities.results.DataResult;
import com.tobeto.bootcampProject.core.utilities.results.Result;
import com.tobeto.bootcampProject.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcampProject.core.utilities.results.SuccessResult;
import com.tobeto.bootcampProject.dataAccess.abstracts.EmployeeRepository;
import com.tobeto.bootcampProject.entities.Employee;
import com.tobeto.bootcampProject.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService, BaseService {

    private EmployeeRepository employeeRepository;
    private ModelMapperService mapperService;

    @Override
    public DataResult<CreateEmployeeResponse> createEmployee(CreateEmployeeRequest request) {
        var result = BusinessRules.run(checkIfUserExists(request.getEmail()), isUsernameAlreadyTaken(request.getUserName()));
        Employee employee = mapperService.forRequest().map(request, Employee.class);
        employee.setCreatedDate(LocalDateTime.now());
        employeeRepository.save(employee);

        CreateEmployeeResponse response = this.mapperService.forResponse().map(employee, CreateEmployeeResponse.class);
        return new SuccessDataResult<CreateEmployeeResponse>(response, "Employee Created");
    }

    @Override
    public DataResult<List<GetAllEmployeeResponse>> getAllEmployee() {
        List <Employee> employees = employeeRepository.findAll();
        List <GetAllEmployeeResponse> response = employees.stream().map(employee -> mapperService.
                forResponse().map(employee, GetAllEmployeeResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllEmployeeResponse>>(response, "All Employees Listed");
    }
    @Override
    public DataResult<GetEmployeeByIdResponse> getEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        GetEmployeeByIdResponse response = mapperService.forResponse().map(employee, GetEmployeeByIdResponse.class);
        return new SuccessDataResult<GetEmployeeByIdResponse>(response, "The Employee Listed");
    }

    @Override
    public DataResult<UpdateEmployeeResponse> updateEmployee(UpdateEmployeeRequest request, int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();

        Employee updatedEmployee = mapperService.forRequest().map(request, Employee.class);

        employee.setId(id);
        employee.setUpdatedDate(LocalDateTime.now());
        employee.setFirstName(updatedEmployee.getFirstName() != null ? updatedEmployee.getFirstName() : employee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName() != null ? updatedEmployee.getLastName() : employee.getLastName());
        employee.setUserName(updatedEmployee.getUserName() != null ? updatedEmployee.getUserName() : employee.getUserName());
        employee.setNationalIdentity(updatedEmployee.getNationalIdentity() != null ? updatedEmployee.getNationalIdentity() : employee.getNationalIdentity());
        employee.setDateOfBirth((updatedEmployee.getDateOfBirth() != null ? updatedEmployee.getDateOfBirth() : employee.getDateOfBirth()));
        employee.setPosition(updatedEmployee.getPosition() != null ? updatedEmployee.getPosition() : employee.getPosition());

        employeeRepository.save(employee);
        UpdateEmployeeResponse response = mapperService.forResponse().map(employee, UpdateEmployeeResponse.class);

        return new SuccessDataResult<UpdateEmployeeResponse>(response, "Employee Updated");
    }

    @Override
    public DataResult<List<GetEmployeeByPositionResponse>> getEmployeeByPosition(String position) {
        List<Employee> employees = employeeRepository.findAllByPosition(position);

        List<GetEmployeeByPositionResponse> response = employees.stream()
                .map(employee -> mapperService.forResponse().map(employee, GetEmployeeByPositionResponse.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<GetEmployeeByPositionResponse>>(response, "All Employees Listed By Position");
    }

    @Override
    public DataResult<List<GetAllEmployeeResponse>> getAllSorted(PageDto pageDto) {
        Sort sort = Sort.by(Sort.Direction.fromString(pageDto.getSortDirection()), pageDto.getSortBy());
        Pageable pageable = PageRequest.of(pageDto.getPageNumber(), pageDto.getPageSize(), sort);
        Page<Employee> employees = employeeRepository.findAll(pageable);
        List <GetAllEmployeeResponse> response = employees.stream().map(employee -> mapperService.forResponse().map(employee, GetAllEmployeeResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllEmployeeResponse>>(response, "All Employees Sorted");
    }

    @Override
    public Result deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
        return new SuccessResult("Employee Deleted!");
    }


    @Override
    public Result checkIfUserExists(String email) {
        Employee employee = employeeRepository.findByEmail(email.trim());
        if(employee != null){
            throw new BusinessException("Employee already exists!");
        }
        return  new SuccessResult();
    }

    @Override
    public Result isUsernameAlreadyTaken(String username) {
        User employee = employeeRepository.findByUserName(username.trim());
        if(employee != null){
            throw new BusinessException("User name already taken!");
        }
        return new SuccessResult();
    }
}

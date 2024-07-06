package org.ds.spring_security_3.service;

import jakarta.transaction.Transactional;
import org.ds.spring_security_3.Exception.EmployeeClientException;
import org.ds.spring_security_3.bean.EmployeeBean;
import org.ds.spring_security_3.dto.EmployeeDTO;
import org.ds.spring_security_3.repository.EmployeeRepository;
import org.ds.spring_security_3.Exception.EmployeeServerException;
import org.ds.spring_security_3.utils.EmployeePopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public EmployeeDTO addEmployee(EmployeeDTO newEmployee) {

        if (newEmployee == null || newEmployee.getFirstName() == null || newEmployee.getFirstName().isBlank()
                || newEmployee.getLastName() == null || newEmployee.getLastName().isBlank()
                || newEmployee.getEmail() == null || newEmployee.getEmail().isBlank()) {
            throw new EmployeeClientException("invalid input data.");
        }

        try {
            EmployeeBean employeeBean = EmployeePopulator.populateEmployeeBean(newEmployee, false);
            employeeRepository.save(employeeBean);
            newEmployee.setId(employeeBean.getId());
            return newEmployee;
        } catch (Exception e) {
            throw new EmployeeServerException("Error occurred when adding a new employee.");
        }
    }

    @Transactional
    public EmployeeDTO findByEmployeeId(long id) {
        if (id > 0) {
            EmployeeBean employeeBean;
            try {
                employeeBean = employeeRepository.findById(id).orElse(null);
            } catch (Exception e) {
                throw new EmployeeServerException("Error occurred when getting employee.");
            }
            if (employeeBean != null) {
                return EmployeePopulator.populateEmployeeDTO(employeeBean);
            } else {
                throw new EmployeeClientException("Employee not found for given id.");
            }
        } else {
            throw new EmployeeClientException("invalid Employee Id.");
        }
    }

    @Transactional
    public List<EmployeeDTO> findByAllEmployee() {
        try {
            List<EmployeeBean> employeeBeanList = employeeRepository.findAll();
            return employeeBeanList.stream().map(EmployeePopulator::populateEmployeeDTO).collect(Collectors.toList());
        } catch (Exception e) {
            throw new EmployeeServerException("Error occurred when getting all employees.");
        }
    }

    @Transactional
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        if (employeeDTO == null || employeeDTO.getId() < 1 || employeeDTO.getFirstName() == null || employeeDTO.getFirstName().isBlank()
                || employeeDTO.getLastName() == null || employeeDTO.getLastName().isBlank()
                || employeeDTO.getEmail() == null || employeeDTO.getEmail().isBlank()) {
            throw new EmployeeClientException("invalid input data.");
        }
        EmployeeBean employeeBean;
        try {
            employeeBean = employeeRepository.findById(employeeDTO.getId()).orElse(null);
        } catch (Exception e) {
            throw new EmployeeServerException("Error occurred when getting employee.");
        }
        if (employeeBean != null) {
            employeeBean.setFirstName(employeeDTO.getFirstName());
            employeeBean.setLastName(employeeDTO.getLastName());
            employeeBean.setEmail(employeeDTO.getEmail());
            try {
                employeeRepository.save(employeeBean);
            } catch (Exception e) {
                throw new EmployeeServerException("Error occurred when updating employee.");
            }
            return employeeDTO;
        } else {
            throw new EmployeeClientException("Employee not found for given id.");
        }
    }

    @Transactional
    public EmployeeDTO deleteByEmployeeId(long id) {
        if (id > 0) {
            EmployeeBean employeeBean;
            try {
                employeeBean = employeeRepository.findById(id).orElse(null);
            } catch (Exception e) {
                throw new EmployeeServerException("Error occurred when finding employee.");
            }
            if (employeeBean != null) {
                EmployeeDTO employeeDTO = EmployeePopulator.populateEmployeeDTO(employeeBean);
                try {
                    employeeRepository.delete(employeeBean);
                } catch (Exception e) {
                    throw new EmployeeServerException("Error occurred when deleting employee.");
                }
                return employeeDTO;
            } else {
                throw new EmployeeClientException("Employee not found for given id.");
            }
        } else {
            throw new EmployeeClientException("invalid Employee Id.");
        }
    }

}

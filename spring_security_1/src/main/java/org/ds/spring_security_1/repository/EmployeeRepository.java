package org.ds.spring_security_1.repository;

import org.ds.spring_security_1.bean.EmployeeBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeBean,Long> {
}

package edu.poly.demo2.dao;

import edu.poly.demo2.entity.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface CareerDao extends JpaRepository<Career, Long> {
}

package edu.poly.demo2.dao;

import edu.poly.demo2.entity.ProField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProFieldDao extends JpaRepository<ProField, Long> {
}

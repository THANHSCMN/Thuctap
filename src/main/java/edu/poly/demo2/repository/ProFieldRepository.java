package edu.poly.demo2.repository;

import edu.poly.demo2.entity.ProField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProFieldRepository extends JpaRepository<ProField, String> {
}

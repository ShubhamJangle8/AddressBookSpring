package com.capge.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capge.demo.model.PersonData;

@Repository
public interface IPersonRepository extends JpaRepository<PersonData, Long>{

}

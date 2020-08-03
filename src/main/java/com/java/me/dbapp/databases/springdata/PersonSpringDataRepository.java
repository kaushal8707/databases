package com.java.me.dbapp.databases.springdata;
import org.springframework.data.jpa.repository.JpaRepository;

interface PersonSpringDataRepository extends JpaRepository<Persons,Integer> {
}

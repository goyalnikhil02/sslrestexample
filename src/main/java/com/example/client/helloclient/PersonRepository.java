package com.example.client.helloclient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository  extends JpaRepository<Person, Integer>{

}

package com.example_jpa.demo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example_jpa.demo3.model.JpaMember;

public interface MemberRepository extends JpaRepository<JpaMember, Long>{

}

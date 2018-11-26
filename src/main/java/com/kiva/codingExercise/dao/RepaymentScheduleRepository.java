package com.kiva.codingExercise.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiva.codingExercise.model.Repayment;

@Repository
public interface RepaymentScheduleRepository extends JpaRepository<Repayment, Long> {

}

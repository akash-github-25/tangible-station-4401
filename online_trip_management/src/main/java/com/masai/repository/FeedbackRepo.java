package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.bean.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, Integer>{
	@Query("select f from Feedback f where f.customer=(from Customer where customerId=?1) ")
 public List<Feedback> viewFeedbackByCustomerId(Integer custom_id);
}

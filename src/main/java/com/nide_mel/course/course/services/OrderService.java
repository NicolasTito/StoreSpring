package com.nide_mel.course.course.services;

import java.util.Optional;

import com.nide_mel.course.course.domain.Order;
import com.nide_mel.course.course.repositories.OrderRepository;
import com.nide_mel.course.course.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;

	public Order find(Integer id) {
		Optional<Order> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Object not found!! Id: " + id + ", Tipo: " + Order.class.getName()));
	}

}

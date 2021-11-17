package com.nide_mel.store.store.services;

import java.util.Date;
import java.util.Optional;

import com.nide_mel.store.store.domain.ItemOrder;
import com.nide_mel.store.store.domain.Order;
import com.nide_mel.store.store.domain.enums.StatePayment;
import com.nide_mel.store.store.repositories.ItemOrderRepository;
import com.nide_mel.store.store.repositories.OrderRepository;
import com.nide_mel.store.store.repositories.PaymentRepository;
import com.nide_mel.store.store.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private ProductService productService;

	@Autowired
	private ItemOrderRepository itemOrderRepository;

	public Order find(Integer id) {
		Optional<Order> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Object not found!! Id: " + id + ", Tipo: " + Order.class.getName()));
	}

	@Transactional
	public Order insert(Order obj) {
		obj.setId(null);
		obj.setDate(new Date());
		obj.getPayment().setState(StatePayment.OUTSTANDING);
		obj.getPayment().setOrder(obj);
		obj = repo.save(obj);
		paymentRepository.save(obj.getPayment());

		for (ItemOrder io : obj.getItemOrders()) {
			io.setDiscount(0.0);
			io.setPrice(productService.find(io.getProduct().getId()).getPrice());
			io.setOrder(obj);
		}
		itemOrderRepository.saveAll(obj.getItemOrders());
		return obj;
	}
}

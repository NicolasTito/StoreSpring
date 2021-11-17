package com.nide_mel.store.store.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.nide_mel.store.store.domain.Address;
import com.nide_mel.store.store.domain.Category;
import com.nide_mel.store.store.domain.City;
import com.nide_mel.store.store.domain.Client;
import com.nide_mel.store.store.domain.District;
import com.nide_mel.store.store.domain.ItemOrder;
import com.nide_mel.store.store.domain.Order;
import com.nide_mel.store.store.domain.Payment;
import com.nide_mel.store.store.domain.PaymentCreditCard;
import com.nide_mel.store.store.domain.PaymentPayPal;
import com.nide_mel.store.store.domain.Product;
import com.nide_mel.store.store.domain.enums.StatePayment;
import com.nide_mel.store.store.repositories.AddressRepository;
import com.nide_mel.store.store.repositories.CategoryRepository;
import com.nide_mel.store.store.repositories.CityRepository;
import com.nide_mel.store.store.repositories.ClientRepository;
import com.nide_mel.store.store.repositories.DistrictRepository;
import com.nide_mel.store.store.repositories.ItemOrderRepository;
import com.nide_mel.store.store.repositories.OrderRepository;
import com.nide_mel.store.store.repositories.PaymentRepository;
import com.nide_mel.store.store.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private DistrictRepository districtRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private ItemOrderRepository itemOrderRepository;

	public void instantiateTestDatabase() throws ParseException {
		Category cat1 = new Category(null, "Computing");
		Category cat2 = new Category(null, "Office");
		Category cat3 = new Category(null, "Home");
		Category cat4 = new Category(null, "Electronics");
		Category cat5 = new Category(null, "Gardening");
		Category cat6 = new Category(null, "Decoration");
		Category cat7 = new Category(null, "");

		Product p1 = new Product(null, "Computer", 1500.00);
		Product p2 = new Product(null, "Printer", 250.00);
		Product p3 = new Product(null, "Mouse", 30.00);
		Product p4 = new Product(null, "Officce Table", 250.00);
		Product p5 = new Product(null, "Towel", 30.00);
		Product p6 = new Product(null, "Quilt", 50.00);
		Product p7 = new Product(null, "Tv", 1500.00);
		Product p8 = new Product(null, "Brushcutter", 300.00);
		Product p9 = new Product(null, "Lampshade", 30.00);
		Product p10 = new Product(null, "Channel", 250.00);
		Product p11 = new Product(null, "Shampoo", 10.00);

		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2, p4));
		cat3.getProducts().addAll(Arrays.asList(p5, p6));
		cat4.getProducts().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProducts().addAll(Arrays.asList(p8));
		cat6.getProducts().addAll(Arrays.asList(p9));
		cat7.getProducts().addAll(Arrays.asList(p10, p11));

		p1.getCategories().addAll(Arrays.asList(cat1, cat4));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategories().addAll(Arrays.asList(cat1, cat4));
		p4.getCategories().addAll(Arrays.asList(cat2));
		p5.getCategories().addAll(Arrays.asList(cat3));
		p6.getCategories().addAll(Arrays.asList(cat3));
		p7.getCategories().addAll(Arrays.asList(cat4));
		p8.getCategories().addAll(Arrays.asList(cat5));
		p9.getCategories().addAll(Arrays.asList(cat6));
		p10.getCategories().addAll(Arrays.asList(cat7));
		p11.getCategories().addAll(Arrays.asList(cat7));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		District dist1 = new District(null, "Lisboa");
		District dist2 = new District(null, "Porto");

		City city1 = new City(null, "Lisboa", dist1);
		City city2 = new City(null, "Porto", dist2);
		City city3 = new City(null, "Amadora", dist1);

		dist1.getCities().addAll(Arrays.asList(city1, city3));
		dist2.getCities().addAll(Arrays.asList(city2));

		districtRepository.saveAll(Arrays.asList(dist1, dist2));
		cityRepository.saveAll(Arrays.asList(city1, city2, city3));

		Client cli1 = new Client(null, "João Alves", "joa@qualquer.com");
		Client cli2 = new Client(null, "Maria Bethania", "mb@qualquer.com");

		cli1.getPhone().addAll(Arrays.asList("000.000.000", "012.012.012"));
		cli2.getPhone().addAll(Arrays.asList("111.111.111"));

		Address addr1 = new Address(null, "2675-340", "rua qualquer", "12", cli1, city1);
		Address addr2 = new Address(null, "2670-340", "rua alguma", "11", cli2, city2);
		Address addr3 = new Address(null, "2070-340", "rua aquela ali", "100", cli1, city3);

		cli1.getAdrresses().addAll(Arrays.asList(addr1, addr3));
		cli2.getAdrresses().addAll(Arrays.asList(addr2));

		clientRepository.saveAll(Arrays.asList(cli1, cli2));
		addressRepository.saveAll(Arrays.asList(addr1, addr2, addr3));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Order order1 = new Order(null, sdf.parse("30/11/2020 11:50"), cli1, addr1);
		Order order2 = new Order(null, sdf.parse("11/09/2021 09:49"), cli2, addr2);

		Payment pay1 = new PaymentCreditCard(null, StatePayment.SETTLED, order1, 12);
		Payment pay2 = new PaymentPayPal(null, StatePayment.OUTSTANDING, order2, sdf.parse("11/09/2021 14:20"));

		order1.setPayment(pay1);
		order2.setPayment(pay2);

		cli1.getOrders().addAll(Arrays.asList(order1));
		cli2.getOrders().addAll(Arrays.asList(order2));

		orderRepository.saveAll(Arrays.asList(order1, order2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));

		ItemOrder io1 = new ItemOrder(order1, p1, 0.00, 1, 1500.00);
		ItemOrder io2 = new ItemOrder(order2, p3, 0.00, 3, 90.00);
		ItemOrder io3 = new ItemOrder(order1, p2, 100.00, 1, 250.00);

		itemOrderRepository.saveAll(Arrays.asList(io1, io2, io3));
	}

}

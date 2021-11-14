package com.nide_mel.course.course;

import java.util.Arrays;

import com.nide_mel.course.course.domain.Address;
import com.nide_mel.course.course.domain.Category;
import com.nide_mel.course.course.domain.City;
import com.nide_mel.course.course.domain.Client;
import com.nide_mel.course.course.domain.District;
import com.nide_mel.course.course.domain.Product;
import com.nide_mel.course.course.repositories.AddressRepository;
import com.nide_mel.course.course.repositories.CategoryRepository;
import com.nide_mel.course.course.repositories.CityRepository;
import com.nide_mel.course.course.repositories.ClientRepository;
import com.nide_mel.course.course.repositories.DistrictRepository;
import com.nide_mel.course.course.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApplication implements CommandLineRunner{

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

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Computing");
		Category cat2 = new Category(null, "Office");

		Product p1 = new Product(null, "Computer", 1500.00);
		Product p2 = new Product(null, "Printer", 250.00);
		Product p3 = new Product(null, "Mouse", 30.00);

		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));

		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));

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
	}
}

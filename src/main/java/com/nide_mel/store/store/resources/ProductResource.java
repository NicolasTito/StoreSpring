package com.nide_mel.store.store.resources;

import java.util.List;

import com.nide_mel.store.store.domain.Product;
import com.nide_mel.store.store.dto.ProductDTO;
import com.nide_mel.store.store.resources.utils.URL;
import com.nide_mel.store.store.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Product obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<Page<ProductDTO>> findPage(
			@RequestParam(value = "name", defaultValue = "")String name,
			@RequestParam(value = "categories", defaultValue = "")String categories,
			@RequestParam(value = "page", defaultValue = "0")Integer page,
			@RequestParam(value = "linesPages", defaultValue = "24")Integer linesPages,
			@RequestParam(value = "orderBy", defaultValue = "name")String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC")String direction) {

		List<Integer> ids = URL.decodeIntList(categories);
		String nameDecoder = URL.decodeParam(name);
		Page<Product> list = service.search(nameDecoder, ids, page, linesPages, orderBy, direction);
		Page<ProductDTO> listDto= list.map(obj -> new ProductDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
}

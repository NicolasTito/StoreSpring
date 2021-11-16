package com.nide_mel.store.store.services;

import java.util.List;
import java.util.Optional;

import com.nide_mel.store.store.domain.Address;
import com.nide_mel.store.store.domain.City;
import com.nide_mel.store.store.domain.Client;
import com.nide_mel.store.store.dto.ClientDTO;
import com.nide_mel.store.store.dto.ClientNewDTO;
import com.nide_mel.store.store.repositories.AddressRepository;
import com.nide_mel.store.store.repositories.ClientRepository;
import com.nide_mel.store.store.services.exceptions.DataExceptionIntegrity;
import com.nide_mel.store.store.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repo;

	@Autowired
	private AddressRepository addr;

	public List<Client> findAll() {
		return repo.findAll();
	}

	public Client find(Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Object not found!! Id: " + id + ", Tipo: " + Client.class.getName()));
	}

	@Transactional
	public Client insert(Client obj) {
		obj.setId(null);
		obj = repo.save(obj);
		addr.saveAll(obj.getAdrresses());
		return obj;
	}

	public Client update(Client obj) {
		Client newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch(DataIntegrityViolationException e) {
			throw new DataExceptionIntegrity("Cannot delete!!!");
		}
	}

	public Page<Client> findPage(Integer page, Integer linesPages, String orderBy, String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPages, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Client fromDto(ClientDTO objDto) {
		return new Client(objDto.getId(), objDto.getName(), objDto.getName());
	}

	public Client fromDto(ClientNewDTO objDto) {
		Client cli = new Client(null, objDto.getName(), objDto.getName());
		City city = new City(objDto.getCityId(), null, null);
		Address addr = new Address(null, objDto.getCep(), objDto.getAddress(), objDto.getNumber(), cli, city);
		cli.getAdrresses().add(addr);
		cli.getPhone().add(objDto.getNumberPhone1());
		if (objDto.getNumberPhone2() != null) {
			cli.getPhone().add(objDto.getNumberPhone2());
			if (objDto.getNumberPhone3() != null) {
				cli.getPhone().add(objDto.getNumberPhone3());
			}
		}
		return cli;
	}

	private void updateData(Client newObj, Client obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

}

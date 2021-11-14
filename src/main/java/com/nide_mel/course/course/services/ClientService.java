package com.nide_mel.course.course.services;

import java.util.Optional;

import com.nide_mel.course.course.domain.Client;
import com.nide_mel.course.course.repositories.ClientRepository;
import com.nide_mel.course.course.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repo;

	public Client find(Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Object not found!! Id: " + id + ", Tipo: " + Client.class.getName()));
	}

}

package com.nide_mel.store.store.repositories;

import com.nide_mel.store.store.domain.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ClientRepository extends JpaRepository<Client, Integer>{

	@Transactional(readOnly = true)
	Client findByEmail(String email);
}

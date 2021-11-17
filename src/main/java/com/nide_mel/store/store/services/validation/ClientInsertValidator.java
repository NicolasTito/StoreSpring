package com.nide_mel.store.store.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nide_mel.store.store.domain.Client;
import com.nide_mel.store.store.dto.ClientNewDTO;
import com.nide_mel.store.store.repositories.ClientRepository;
import com.nide_mel.store.store.resources.exception.FieldMessage;

import org.springframework.beans.factory.annotation.Autowired;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, ClientNewDTO> {
	@Autowired
	ClientRepository repository;

	@Override
	public void initialize(ClientInsert ann) {
	}

	@Override
	public boolean isValid(ClientNewDTO objDto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();

		Client aux = repository.findByEmail(objDto.getEmail());
		if(aux!=null) {
			list.add(new FieldMessage("email", "email já existente"));
		}
		// inclua os testes aqui, inserindo erros na lista
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}

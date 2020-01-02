package com.appjava.admin.user.controllers;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerErrorException;

import com.appjava.admin.user.entity.EntityUser;
import com.appjava.admin.user.resources.ResourceUser;
import com.appjava.admin.user.services.ServiceUser;
import com.appjava.core.controllers.BaseController;
import com.appjava.core.exception.BadRequestException;
import com.appjava.core.exception.ConflictException;
import com.appjava.core.services.BaseService;

import io.swagger.annotations.Api;

@Api("Application User")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/users")
public class ControllerUser extends BaseController<ResourceUser, EntityUser> {
	
	@Autowired
	private ServiceUser servicio;
	
	@Autowired
	protected ModelMapper modelMapper;
	
	@Override
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<ResourceUser>> list()
			throws ServerErrorException, EntityNotFoundException, BadRequestException, ConflictException,
			MethodArgumentNotValidException, Exception {
		return super.list();
	}
	
	@Override
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ResourceUser> create(@RequestBody @Validated ResourceUser recurso) throws Exception, BadRequestException,
			MethodArgumentNotValidException, ServerErrorException, EntityNotFoundException, ConflictException {
		return super.create(recurso);
	}
	
	@Override
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<ResourceUser> update(@RequestBody @Validated ResourceUser recurso) throws Exception, BadRequestException,
			MethodArgumentNotValidException, ServerErrorException, EntityNotFoundException, ConflictException {
		return super.update(recurso);
	}
	
	@Override
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<ResourceUser> detail(@PathVariable("id") Long id) throws Exception, BadRequestException,
			MethodArgumentNotValidException, ServerErrorException, EntityNotFoundException, ConflictException {
		return super.detail(id);
	}
	
	@Override
	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public ResponseEntity<ResourceUser> delete(@PathVariable("id") Long id) throws Exception, BadRequestException,
			MethodArgumentNotValidException, ServerErrorException, EntityNotFoundException, ConflictException {
		return super.delete(id);
	}
	
	@Override
	protected BaseService<EntityUser> getService() {
		return servicio;
	}

	@Override
	protected ResourceUser convertEntityToResource(EntityUser entidad) {
		return modelMapper.map(entidad, ResourceUser.class);
	}

	@Override
	protected EntityUser convertResourceToEntity(ResourceUser recurso) {
		return modelMapper.map(recurso, EntityUser.class);
	}
}

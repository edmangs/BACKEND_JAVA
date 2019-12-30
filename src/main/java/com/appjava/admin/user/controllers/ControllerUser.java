package com.appjava.admin.user.controllers;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import org.springframework.http.HttpStatus;

import io.swagger.annotations.Api;

@Api("Application User")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
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

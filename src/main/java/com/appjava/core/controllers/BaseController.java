package com.appjava.core.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ServerErrorException;

import com.appjava.core.entity.BaseEntity;
import com.appjava.core.exception.BadRequestException;
import com.appjava.core.exception.ConflictException;
import com.appjava.core.resources.BaseResource;
import com.appjava.core.services.BaseService;

import springfox.documentation.swagger2.mappers.ModelMapper;

@ControllerAdvice
public abstract class BaseController<R extends BaseResource, E extends BaseEntity> {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	protected ModelMapper modelMapper;
	
	protected abstract BaseService<E> getService();

	protected abstract R convertEntityToResource(E entidad);

	protected abstract E convertResourceToEntity(R recurso);
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get() {
        return "custom";
    }
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<R>> list() throws ServerErrorException, EntityNotFoundException, BadRequestException,
	ConflictException, MethodArgumentNotValidException, Exception {
		List<R> listado = getService().listAll().stream().map(entity -> convertEntityToResource((E) entity))
				.collect(Collectors.toList());
		return new ResponseEntity<List<R>>(listado, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search() {
        return "custom";
    }
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create() {
        return "custom";
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update() {
        return "custom";
    }
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete() {
        return "custom";
    }
	
}

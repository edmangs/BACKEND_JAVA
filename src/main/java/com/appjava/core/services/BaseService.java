package com.appjava.core.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.server.ServerErrorException;

import com.appjava.core.entity.BaseEntity;
import com.appjava.core.exception.BadRequestException;
import com.appjava.core.exception.ConflictException;
import com.appjava.core.repository.BaseRepository;
import com.appjava.core.utils.SortAndPagination;
import com.google.common.collect.Lists;

import org.springframework.data.domain.Sort;

public abstract class BaseService<E extends BaseEntity> {
	public BaseService() {
		super();
	}
	
	public List<BaseEntity> listAll()
			throws Exception, BadRequestException, MethodArgumentNotValidException, ServerErrorException,
			EntityNotFoundException, ConflictException {
		return Lists.newArrayList(getRepository().findAll());
	}
	
	protected final Sort constructSort(final String sortBy, final String sortOrder) {
		Sort sortInfo = null;
		if (sortBy != null) {
			switch (sortOrder.toLowerCase().trim()) {
			case "desc":
				return Sort.by(Sort.Order.desc(sortBy).ignoreCase());
			default:
				return Sort.by(Sort.Order.asc(sortBy).ignoreCase());
			}
		}
		return sortInfo;
	}
	
	public abstract PagingAndSortingRepository<E, Long> getRepository();

	public abstract JpaSpecificationExecutor<E> getSpecificationExecutor();

	public abstract BaseRepository<E> getCustomRepository();

	public abstract Page<E> search(Specification<E> specification, SortAndPagination sortAndPagination);
}

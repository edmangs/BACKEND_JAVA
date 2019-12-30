package com.appjava.admin.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.appjava.admin.user.entity.EntityUser;
import com.appjava.admin.user.repository.RepositoryUser;
import com.appjava.core.repository.BaseRepository;
import com.appjava.core.services.BaseService;
import com.appjava.core.utils.SortAndPagination;

@Service
public class ServiceUser extends BaseService<EntityUser> {
	
	@Autowired
	private RepositoryUser repositorio;

	public ServiceUser() {
		super();
	}

	public PagingAndSortingRepository<EntityUser, Long> getRepository() {
		return repositorio;
	}

	public JpaSpecificationExecutor<EntityUser> getSpecificationExecutor() {
		return repositorio;
	}

	public BaseRepository<EntityUser> getCustomRepository() {
		return repositorio;
	}

	public Page<EntityUser> search(Specification<EntityUser> specification,
			SortAndPagination sortAndPagination) {
		PageRequest pageRequest;
		pageRequest = PageRequest.of(sortAndPagination.getPage(), sortAndPagination.getSize(),
				constructSort(sortAndPagination.getSortBy(), sortAndPagination.getSortOrder()));
		return repositorio.findAll(specification, pageRequest);
	}
}
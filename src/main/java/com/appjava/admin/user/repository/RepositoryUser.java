package com.appjava.admin.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.appjava.admin.user.entity.EntityUser;
import com.appjava.core.repository.BaseRepository;

@Repository
public interface RepositoryUser extends JpaRepository<EntityUser, Long>, JpaSpecificationExecutor<EntityUser>, BaseRepository<EntityUser> {
	
}

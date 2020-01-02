package com.appjava.admin.user.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.appjava.admin.user.entity.EntityUser;

import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@And({ @Spec(path = "firstName", params = "firstName", spec = LikeIgnoreCase.class),
	@Spec(path = "lastName", params = "lastName", spec = LikeIgnoreCase.class),
	@Spec(path = "email", params = "email", spec = LikeIgnoreCase.class)
})
public interface SpecificationUserSearch extends Specification<EntityUser> {
}


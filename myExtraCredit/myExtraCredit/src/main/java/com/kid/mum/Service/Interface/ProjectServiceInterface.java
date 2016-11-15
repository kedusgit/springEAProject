package com.kid.mum.Service.Interface;

import org.springframework.data.repository.CrudRepository;


import com.kid.mum.domain.Project;

public interface ProjectServiceInterface extends CrudRepository<Project, Long> {

}

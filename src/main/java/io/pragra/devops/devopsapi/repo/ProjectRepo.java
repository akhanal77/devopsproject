package io.pragra.devops.devopsapi.repo;

import io.pragra.devops.devopsapi.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {
}

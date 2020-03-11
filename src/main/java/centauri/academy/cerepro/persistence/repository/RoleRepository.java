package centauri.academy.cerepro.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findByLevel(int level);

}

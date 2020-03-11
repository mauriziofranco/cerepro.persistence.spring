package centauri.academy.cerepro.persistence.repository.originsite;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.OriginSite;

@Repository
public interface OriginSiteRepository extends JpaRepository<OriginSite, Long> {

	Optional<OriginSite> findByLabel(String label);
	Page<OriginSite> findAll(Pageable info);
	
}

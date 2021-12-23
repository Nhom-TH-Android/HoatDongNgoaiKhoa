package dataHDNK.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dataHDNK.entity.ActivityEntity;

public interface ActitvityRepository extends JpaRepository<ActivityEntity, Long> {
	ActivityEntity findOneByCode(String code);
}

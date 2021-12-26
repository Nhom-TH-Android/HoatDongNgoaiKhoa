package dataHDNK.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dataHDNK.entity.ActivityEntity;

public interface ActitvityRepository extends JpaRepository<ActivityEntity, Long> {
	ActivityEntity findOneByCode(String code);
	List<ActivityEntity> findByThoiGianLessThan(Date date);
	List<ActivityEntity> findByThoiGianGreaterThan(Date date);
}

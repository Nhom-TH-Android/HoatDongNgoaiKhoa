package dataHDNK.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dataHDNK.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
	StudentEntity findOneByMsv(String msv);
}

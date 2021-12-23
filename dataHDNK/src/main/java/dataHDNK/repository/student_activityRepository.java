package dataHDNK.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dataHDNK.entity.ActivityEntity;
import dataHDNK.entity.StudentEntity;
import dataHDNK.entity.student_activityEntity;

public interface student_activityRepository extends JpaRepository<student_activityEntity, Long> {
//	List<student_activityEntity> findOneByCode(ActivityEntity entity);
//	List<student_activityEntity> findOneByMsv(StudentEntity entity);
//	student_activityEntity findOneByKey(String code, String msv);
}

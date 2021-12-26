package dataHDNK.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dataHDNK.entity.ActivityEntity;
import dataHDNK.entity.StudentEntity;
import dataHDNK.entity.student_activityEntity;

public interface student_activityRepository extends JpaRepository<student_activityEntity, Long> {
	List<student_activityEntity> findOneByActivity(ActivityEntity entity);
	List<student_activityEntity> findOneByStudent(StudentEntity student);
	student_activityEntity findByActivity_IdAndStudent_Id(Long activity_id, Long student_id);
	
}

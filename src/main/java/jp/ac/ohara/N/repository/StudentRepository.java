package jp.ac.ohara.N.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.ac.ohara.N.model.StudentModel;

public interface StudentRepository extends JpaRepository<StudentModel, Long> {
//	public Optional<StudentModel> findByName(String name);
}
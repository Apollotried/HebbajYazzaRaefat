package com.idld.coursservice.Repository;

import com.idld.coursservice.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository  extends JpaRepository<Course, Long> {
}

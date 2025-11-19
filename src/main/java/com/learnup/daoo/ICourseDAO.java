package com.learnup.daoo;

/**
 *
 * @author alfre
 */

import com.learnup.model.Course;
import org.bson.types.ObjectId;
import java.util.List;

public interface ICourseDAO {
    void create(Course course);
    Course findById(ObjectId id);
    List<Course> findAll();
    void update(Course course);
    void deleteById(ObjectId id);
    List<Course> findByNombre(String title);
}
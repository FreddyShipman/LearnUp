package com.learnup.controllerss;

/**
 *
 * @author alfre
 */

import com.learnup.model.Course;
import org.bson.types.ObjectId;
import java.util.List;

public interface ICourseController {
    void createCourse(Course course);
    Course findCourseById(ObjectId id);
    List<Course> listAllCourses();
    void updateCourse(Course course);
    void deleteCourse(ObjectId id);
    List<Course> searchCoursesByName(String title);
}
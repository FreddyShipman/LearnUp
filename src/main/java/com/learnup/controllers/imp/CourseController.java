package com.learnup.controllers.imp;

/**
 *
 * @author alfre
 */

import com.learnup.controllerss.ICourseController;
import com.learnup.daoo.ICourseDAO;
import com.learnup.dao.imp.CourseDAO;
import com.learnup.model.Course;
import org.bson.types.ObjectId;
import java.util.List;

public class CourseController implements ICourseController {

    private final ICourseDAO courseDao;

    public CourseController() {
        this.courseDao = new CourseDAO();
    }

    @Override
    public void createCourse(Course course) {
        courseDao.create(course);
    }

    @Override
    public Course findCourseById(ObjectId id) {
        return courseDao.findById(id);
    }

    @Override
    public List<Course> listAllCourses() {
        return courseDao.findAll();
    }

    @Override
    public void updateCourse(Course course) {
        courseDao.update(course);
    }

    @Override
    public void deleteCourse(ObjectId id) {
        courseDao.deleteById(id);
    }

    @Override
    public List<Course> searchCoursesByName(String title) {
        return courseDao.findByNombre(title);
    }
}
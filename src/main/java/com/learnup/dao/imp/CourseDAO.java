package com.learnup.dao.imp;

/**
 *
 * @author alfre
 */

import com.learnup.config.Conexion;
import com.learnup.daoo.ICourseDAO;
import com.learnup.model.Course;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseDAO implements ICourseDAO {

    private final MongoCollection<Course> collection;

    public CourseDAO() {
        this.collection = Conexion.getInstance().getCollection("courses", Course.class);
    }

    @Override
    public void create(Course course) {
        if (course.getId() == null) {
            course.setId(new ObjectId());
        }
        course.setCreatedAt(new Date());
        course.setUpdatedAt(new Date());
        collection.insertOne(course);
    }

    @Override
    public Course findById(ObjectId id) {
        return collection.find(Filters.eq("_id", id)).first();
    }

    @Override
    public List<Course> findAll() {
        List<Course> list = new ArrayList<>();
        collection.find().into(list);
        return list;
    }

    @Override
    public void update(Course course) {
        course.setUpdatedAt(new Date());
        collection.replaceOne(Filters.eq("_id", course.getId()), course);
    }

    @Override
    public void deleteById(ObjectId id) {
        collection.deleteOne(Filters.eq("_id", id));
    }

    @Override
    public List<Course> findByNombre(String title) {
        List<Course> list = new ArrayList<>();
        collection.find(Filters.regex("title", title, "i")).into(list);
        return list;
    }
}
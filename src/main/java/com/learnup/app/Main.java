package com.learnup.app;

/**
 *
 * @author alfre
 */

import com.learnup.controllers.imp.CourseController;
import com.learnup.dao.imp.CourseDAO;
import com.learnup.model.Course;
import com.learnup.model.Module;
import com.learnup.model.Resource;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            CourseController controller = new CourseController();

            Course c = new Course();
            c.setTitle("Curso de Arquitectura Java");
            c.setDescription("Capas y patrones");
            c.setCategory("Backend");
            c.setPrice(250.00);
            c.setRating(5.0);
            c.setTags(Arrays.asList("Java", "SQL", "Mongo"));

            Module m1 = new Module();
            m1.setModuleTitle("Patrones de Disenio");
            m1.setDurationMinutes(60);
            m1.setResources(Arrays.asList(
                new Resource("pdf", "Lectura MVC", "http://learnup.com/pdf")
            ));
            c.setModules(Arrays.asList(m1));

            controller.createCourse(c);
            System.out.println("Curso creado con ID: " + c.getId());

            Course leido = controller.findCourseById(c.getId());
            if(leido != null) {
                System.out.println("Curso recuperado: " + leido.getTitle());
            }

            leido.setTitle("Curso de Arquitectura Java (Editado)");
            controller.updateCourse(leido);
            System.out.println("Curso actualizado correctamente");

            List<Course> lista = controller.listAllCourses();
            System.out.println("Cursos en base de datos: " + lista.size());

            controller.deleteCourse(c.getId());
            System.out.println("Curso eliminado.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//    public static void main(String[] args) {
//        try {
//            CourseDAO dao = new CourseDAO();
//
//            Course c = new Course();
//            c.setTitle("Curso de Java Avanzado");
//            c.setDescription("Aprende Java y MongoDB");
//            c.setCategory("Programacion");
//            c.setPrice(199.99);
//            c.setRating(4.5);
//            c.setTags(Arrays.asList("Java", "MongoDB", "Backend"));
//
//            Module m1 = new Module();
//            m1.setModuleTitle("Introduccion");
//            m1.setDurationMinutes(120);
//            
//            Resource r1 = new Resource("video", "Instalacion", "http://video.itson");
//            m1.setResources(Arrays.asList(r1));
//            
//            c.setModules(Arrays.asList(m1));
//
//            dao.create(c);
//            System.out.println("Curso creado con ID: " + c.getId());
//
//            Course leido = dao.findById(c.getId());
//            if(leido != null) {
//                System.out.println("Leido: " + leido.getTitle());
//            }
//
//            leido.setTitle("Curso de Java y Mongo Actualizado");
//            dao.update(leido);
//            System.out.println("Curso actualizado.");
//
//            List<Course> todos = dao.findAll();
//            System.out.println("Total cursos: " + todos.size());
//
//            dao.deleteById(c.getId());
//            System.out.println("Curso eliminado.");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
// }
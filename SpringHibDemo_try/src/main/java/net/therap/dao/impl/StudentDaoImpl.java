package net.therap.dao.impl;

import net.therap.dao.StudentDao;
import net.therap.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author sanjoy.saha
 * @date 6/18/14
 * @time 12:00 PM
 */
@Repository
public class StudentDaoImpl implements StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addStudent(Student student) {
        entityManager.persist(student);
        entityManager.flush();
    }
}

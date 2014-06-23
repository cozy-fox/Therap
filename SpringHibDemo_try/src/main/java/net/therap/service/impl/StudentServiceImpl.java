package net.therap.service.impl;

import net.therap.dao.StudentDao;
import net.therap.model.Student;
import net.therap.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sanjoy.saha
 * @date 6/19/14
 * @time 2:51 PM
 */
@Service
@Transactional(value = "jpaTransactionManager")
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }
}

package com.lgd.dao;

import com.lgd.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class StudentDAOTest {

    @org.junit.Test
    public void insertStudent() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            SqlSessionFactory factory=builder.build(is);
            SqlSession sqlSession= factory.openSession();
            StudentDAO studentDAO=sqlSession.getMapper(StudentDAO.class);
            int i = studentDAO.insertStudent(new Student(0, "1003", "撒", "男", 21));
            sqlSession.commit();
            System.out.println(i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void deleteStudent() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            SqlSessionFactory factory=builder.build(is);
            SqlSession sqlSession= factory.openSession();
            StudentDAO studentDAO=sqlSession.getMapper(StudentDAO.class);
            int i = studentDAO.deleteStudent("1001");
            sqlSession.commit();
            System.out.println(i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateStudent() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            SqlSessionFactory factory=builder.build(is);
            SqlSession sqlSession= factory.openSession();
            StudentDAO studentDAO=sqlSession.getMapper(StudentDAO.class);
            int i = studentDAO.updateStudent(new Student(0,"10001","jasx","女",23));
            sqlSession.commit();
            assertEquals(1,i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void listStudents() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            SqlSessionFactory factory=builder.build(is);
            SqlSession sqlSession= factory.openSession();
            StudentDAO studentDAO=sqlSession.getMapper(StudentDAO.class);
            List<Student> list=studentDAO.listStudents();
            assertNotNull(list);
            for (Student student:list) {
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryStudent() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            SqlSessionFactory factory=builder.build(is);
            SqlSession sqlSession= factory.openSession();
            StudentDAO studentDAO=sqlSession.getMapper(StudentDAO.class);
            Student student = studentDAO.queryStudent("10001");
            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void listStudentByPage() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            SqlSessionFactory factory=builder.build(is);
            SqlSession sqlSession= factory.openSession();
            StudentDAO studentDAO=sqlSession.getMapper(StudentDAO.class);
            List<Student> students = studentDAO.listStudentByPage(0, 1);
            System.out.println(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCount() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            SqlSessionFactory factory=builder.build(is);
            SqlSession sqlSession= factory.openSession();
            StudentDAO studentDAO=sqlSession.getMapper(StudentDAO.class);
            int count = studentDAO.getCount();
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
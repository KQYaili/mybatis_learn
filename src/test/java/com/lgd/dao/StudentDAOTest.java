package com.lgd.dao;

import com.lgd.pojo.Student;
import com.lgd.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class StudentDAOTest {

    @org.junit.Test
    public void insertStudent() {
        //try {
//            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
//            SqlSessionFactory factory=builder.build(is);
//            SqlSession sqlSession= factory.openSession();
//            StudentDAO studentDAO=sqlSession.getMapper(StudentDAO.class);
//            int i = studentDAO.insertStudent(new Student(0, "1009", "lilsy", "男", 17));
//            sqlSession.commit();
//            System.out.println(i);
//            } catch (IOException e) {
//            e.printStackTrace();
//        }
        SqlSession sqlSession= MyBatisUtils.getSqlSession();

        StudentDAO studentDAO=sqlSession.getMapper(StudentDAO.class);
        Student student=new Student(0,"10015","lyills","女",14);
        int i=studentDAO.insertStudent(student);
        System.out.println(student);
        sqlSession.commit();
        System.out.println(i);
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
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDAO studentDAO=sqlSession.getMapper(StudentDAO.class);
        int i=studentDAO.updateStudent(new Student(0,"10010","ssss","女",3));
        sqlSession.commit();
        System.out.println(i);
    }

    @Test
    public void listStudents() {
//        try {
//            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
//            SqlSessionFactory factory=builder.build(is);
//            SqlSession sqlSession= factory.openSession();
//            StudentDAO studentDAO=sqlSession.getMapper(StudentDAO.class);
//            List<Student> list=studentDAO.listStudents();
//            assertNotNull(list);
//            for (Student student:list) {
//                System.out.println(student);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        StudentDAO mapper=MyBatisUtils.getMapper(StudentDAO.class);
        List<Student>list=mapper.listStudents();
        for(Student stu:list){
            System.out.println(stu);
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

//    @Test
//    public void listStudentsByPage() {
//        try {
//            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
//            SqlSessionFactory factory=builder.build(is);
//            SqlSession sqlSession= factory.openSession();
//            StudentDAO studentDAO=sqlSession.getMapper(StudentDAO.class);
//            HashMap<String, Integer> map = new HashMap<>();
//            map.put("start",0);
//            map.put("pageSize",2);
//            List<Student> list = studentDAO.listStudentsByPage(map);
//            System.out.println(list);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
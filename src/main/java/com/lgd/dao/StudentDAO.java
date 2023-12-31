package com.lgd.dao;

import com.lgd.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface StudentDAO {
    public int insertStudent(Student student);
    public int deleteStudent(String stuNum);
    public int updateStudent(Student student);
    public List<Student> listStudents();
    public Student queryStudent(String stuNum);
    public List<Student> listStudentByPage(@Param("start")int start,
                                           @Param("pageSize")int pageSize);
    public int getCount();
//    public List<Student> listStudentsByPage(HashMap<String,Integer> map);

}

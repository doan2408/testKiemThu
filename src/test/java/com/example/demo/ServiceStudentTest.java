package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceStudentTest {
    private ServiceStudent serviceStudent;
    private Student student;

    @BeforeEach
    void setUp() {
        serviceStudent = new ServiceStudent();
        student = new Student(1,"a",20,9.0);
        serviceStudent .getListStudent().add(student);
    }

    @Test
    void addStudentWithValidStudent() {
        Student student = new Student(2,"a",20,9.0);
        serviceStudent.addStudent(student);
        assertEquals(2,serviceStudent.getListStudent().get(1).getId());
    }

    @Test
    void addStudentWithNull() {
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            serviceStudent.addStudent(null);
        });
        assertEquals("Student can not be null", exception.getMessage());
    }

    @Test
    void addStudentWithInvalidName() {
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            Student student = new Student(1,"",20,9.0);
            serviceStudent.addStudent(student);
        });
    }

    @Test
    void addStudentWithInvalidAge() {
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            Student student = new Student(1,"a",17,9.0); // dieu kien tuoi >=18
            serviceStudent.addStudent(student);
        });
    }

    @Test
    void addStudentWithInvalidMark() {
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            Student student = new Student(1,"a",17,11.0); // dieu kien mark trong khoảng [0;10]
            serviceStudent.addStudent(student);
        });
    }



    @Test
    void getStudentById() {
        serviceStudent.addStudent(new Student(2,"doan",20,10.0));
        Student student =serviceStudent.getStudentById(2);
        assertEquals(2L,student.getId());
    }

    @Test
    void updateStudentWithValidStudent() {
        Student student = new Student(1,"alice",20,9);
        serviceStudent.addStudent(student);

        student.setName("doan");
        student.setAge(21);
        student.setMark(10.0);
        serviceStudent.updateStudent(student);

        assertEquals("doan", serviceStudent.getStudentById(1).getName());
        assertEquals(21, serviceStudent.getStudentById(1).getAge());
        assertEquals(10.0, serviceStudent.getStudentById(1).getMark());
    }

    @Test
    void updateStudentInvalid() {
        Student student = new Student(2,"alice",20,9); // mới add 1 đối tượng nên mới chỉ có id là 1
        serviceStudent.addStudent(student);

        student.setName("doan");
        student.setAge(21);
        student.setMark(10.0);
        serviceStudent.updateStudent(student);

        assertEquals("doan", serviceStudent.getStudentById(2).getName());
        assertEquals(21, serviceStudent.getStudentById(2).getAge());
        assertEquals(10.0, serviceStudent.getStudentById(2).getMark());
    }

        @Test
        void updateStudentTrongName() {

            Exception exception = assertThrows(IllegalArgumentException.class, ()-> {
                Student student = new Student(2,"",20,9); // mới add 1 đối tượng nên mới chỉ có id là 1
                serviceStudent.updateStudent(student);
            });
            assertEquals("Name must not be null or empty", exception.getMessage());
        }

    @Test
    void updateStudentV2() {
    }

    @Test
    void deleteStudent() {
    }

    @Test
    void deleteStudentV2() {
    }

    @Test
    void getAllStudents() {
    }

//    @Test
//    void sumArrayValid() {
//        Integer mang = serviceStudent.sumArray(new int[] {2,5,7});
//        assertEquals(14, mang);
//    }

//    @Test
//    void sumArrayInvalid() {
//        Exception exception = assertThrows(IllegalArgumentException.class, () ->{
//            Integer mang = serviceStudent.sumArray(new int[] {1,1,101});
//        });
//        assertEquals("số trong mảng phải <=100",exception.getMessage());
//    }

    @Test
    void testTinhTongMangSoNguyen() {
        Integer ketQua = serviceStudent.tinhTongMangSoNguyen(new int[] {2,3,4});
        assertEquals(9,ketQua);
    }

}
package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceStudent {
    private List<Student> students = new ArrayList<>();

     public List<Student> setListStudent() {
        return students;
    }

    public List<Student> getListStudent() {
        return new ArrayList<>(students);
    }

    void setListStudent(List<Student> list) {
        this.students = list;
    }

    private Student st = new Student();

//    public Integer sumArray(int[] mang) {
//        int sum = 0;
//        for (int i = 0; i < mang.length; i++) {
//            if (mang[i] >100) {
//                throw new IllegalArgumentException("số trong mảng phải <=100");
//            } else {
//                sum += mang[i];
//            }
//        }
//        return sum;
//    }


    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student can not be null");
        }
        students.add(student);
    }

    //    cach 1 getById
    public Student getStudentById(long id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    //    cach 2 getById
    public Optional<Student> getStudentByIdV2(long id) {
        return students
                .stream()
                .filter(student -> student.getId() == id)
                .findFirst();
    }


    //    update cach 1
    public void updateStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student can not be null");
        }

        boolean found = false;
        for (int i = 0; i < students.size(); ++i) {
            if (students.get(i).getId() == student.getId()) {
                students.set(i, student);
                found = true;
                break;
            }
        }

        if(!found) {
            throw new IllegalArgumentException("Student with id" + student.getId() + " does not exists");
        }
    }




    //    update cach 2:
    public void UpdateStudentV2(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student can not be null");
        }

        Optional<Student> exitstsStudent = getStudentByIdV2(student.getId());
        if (exitstsStudent.isPresent()) {
            students.set(students.indexOf(exitstsStudent.get()), student);
        } else {
            throw new IllegalArgumentException("Student with id" + student.getId() + " does not exists");
        }
    }

    //    update cach 1:
    boolean deleteStudent(long id) {
        for (int i = 0; i < students.size(); ++i) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    //    xoa cach 2
    public boolean deleteStudentV2(long id) {
        return students.removeIf(student -> student.getId() == id);
    }



    public Integer tinhTongMangSoNguyen(int[] mang) {
        int sum=0;
        for(int i=0; i<mang.length; i++) {
            sum += mang[i];
        }
        return sum;
    }




}

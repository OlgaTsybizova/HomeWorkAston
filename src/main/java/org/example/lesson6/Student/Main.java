package org.example.lesson6.Student;
import java.util.HashMap;
import java.util.List;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();//Коллекция студентов

        Student st1 = new Student ("Ivanov", 123, 2);
        st1.createMarks("math", List.of(5,4,5,3));
        st1.createMarks("phys", List.of(5,4,5,5));
        addStudent(students, st1);

        Student st2 = new Student ("Petrov", 122, 1);
        st2.createMarks("math", List.of(3,2,2,3));
        st2.createMarks("phys", List.of(3,3,2,2));
        addStudent(students, st2);

        Student st3 = new Student ("Sidorov", 123, 3);
        st3.createMarks("math", List.of(5,5,5,4));
        st3.createMarks("phys", List.of(5,4,5,5));
        addStudent(students, st3);

        System.out.println("Первоначальный список студентов:");
        printStudentsInfo(students);
        st1.getAverageMarcs();
        st2.getAverageMarcs();
        System.out.println("Cписок студентов после отчисления:");
        removeStudents(students);
        printStudentsInfo(students);
        System.out.println("Cписок студентов после перевода на следующий курс:");
        nextCourse(students);
        printStudentsInfo(students);
        printStudents(students, 2);

    }

    //Добавить студента
    public static void addStudent(ArrayList<Student> students,Student student){
        students.add(student);
    }

    //Вывести список студентов
    public static void printStudentsInfo(ArrayList<Student> students){
        for(Student st: students){
            //System.out.print("Студент: " + st.getName() + "курс обучения: " + st.getCourse()+ "Средний балл:" + st.getAverageMarcs());
            System.out.printf("Студент %s Курс обучения %d Средний балл %.2f \n", st.getName(), st.getCourse(), st.getAverageMarcs());
        }
    }
    //Удалить студента
    public static void removeStudents(ArrayList<Student> students){
        Iterator<Student> iterator = students.iterator();
        while(iterator.hasNext()){
            Student st = iterator.next();
            if(st.getAverageMarcs()<3){
                iterator.remove();
            }
        }
    }
    //Перевести студента на следующий курс
    public static void nextCourse(ArrayList<Student> students){
        for(Student st: students){
            if(st.getAverageMarcs()>=3){
                st.setCourse(st.getCourse() + 1);
            }
        }
    }

    //Вывести список студентов, обучающихся на заданном курсе
    public static void printStudents(ArrayList<Student> students, int course){
        System.out.println("Список студентов, обучающихся на курсе: " + course);
        for (Student st: students){
            if(st.getCourse() == course){
                System.out.println(st.getName());
            }
        }
    }
}


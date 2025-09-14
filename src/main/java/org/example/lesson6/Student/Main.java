package org.example.lesson6.Student;
import java.util.ArrayList;
import java.util.ListIterator;
public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        addStudent(students,"Danilov", 124, 1, new int[]{8,4,5} );
        addStudent(students,"Ivanov", 125, 1, new int[]{5, 4, 5, 5, 5});
        addStudent(students,"Petrov", 112, 3, new int[]{3, 3, 3, 3});
        addStudent(students,"Sidorov", 125, 1, new int[]{4, 5, 5});
        addStudent(students,"Repin", 114, 2, new int[]{2, 2, 3, 3, 3});
        addStudent(students,"Kuznetsov", 115, 4, new int[]{4, 5, 4, 3, 5});

        System.out.println("Первоначальный список студентов:");
        printStudentsInfo(students);
        System.out.println("Cписок студентов после отчисления:");
        removeStudents(students);
        printStudentsInfo(students);
        System.out.println("Cписок студентов после перевода на следующий курс:");
        nextCourse(students);
        printStudentsInfo(students);
        printStudents(students, 2);

    }
    //Добавить студента
    public static void addStudent(ArrayList<Student> students, String name, int numGroup, int course, int [] marks){
        Student str = new Student(name, numGroup, course, marks);
        try {
            for (int m : marks) {
                if ((m < 0) || (m > 5)) {
                    throw new MarksException ("Оценка должна быть целым положительным числом от 1 до 5 Студент");
                }
            }
            students.add(str);
        }
        catch(MarksException e){
            System.out.println("Студент "+ str.getName() + " не добавлен");
        }
    }

    //Вывести список студентов
    public static void printStudentsInfo(ArrayList<Student> students){
        for(Student st: students){
            System.out.printf("Студент: %s Курс обучения: %d Средний балл %.2f\n",st.getName(), st.getCourse(), st.getAverageMarcs());
        }
    }
    //Удалить студента
    public static void removeStudents(ArrayList<Student> students){
        ListIterator<Student> iterator = students.listIterator();
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
        System.out.printf("Список студентов, обучающихся на курсе %d:\n", course);
        for (Student st: students){
            if(st.getCourse() == course){
                System.out.println(st.getName());
            }
        }
    }
}


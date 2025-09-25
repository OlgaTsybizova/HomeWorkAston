package org.example.lesson6.Student;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class Student {
    private String name;
    private int numGroup;
    private int course;
    private Map<String, List<Integer>> marksStudent = new HashMap<String, List<Integer>>();


    public Student(String name, int numGroup, int course){
        this.name = name;
        this. numGroup = numGroup;
        this.course = course;
    }

    //Создать список оценок по предметам для студента
    public void createMarks(String subject, List<Integer> marks) {
        try{
            for(Integer m: marks) {
                if (m < 0 || m > 5) {
                    throw new MarksException("Оценка должна быть целым положительным числом от 1 до 5. Получена: " + m);
                }
            }
            marksStudent.put(subject, marks);
        }
        catch(MarksException e){
            e.getInfo();
        }
    }

    /*public Student (String name, int numGroup, int course, Map<String, List<Integer>> marksStudent){
        this.name = name;
        this.numGroup = numGroup;
        this.course = course;
        for(int m: marks) {
            if((m>0)&&(m<=5)){this.marks = marks;}
            else{System.out.println("Оценка должна быть целым положительным числом от 1 до 5");}
        }
    }*/

    public String getName() {
        return name;
    }

    public int getNumGroup() {
        return numGroup;
    }

    public int getCourse() {
        return course;
    }

    public Map<String, List<Integer>> getMarksStudent() {
        return marksStudent;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAverageMarcs(){
        double sum = 0.0;
        int count = 0;
        for(Map.Entry<String, List<Integer>> item: marksStudent.entrySet()){
            for(Integer m: item.getValue()){
                sum = sum + m;
                count++;
            }
        }
        if(count ==0 || marksStudent == null){return 0.0;}
        return sum/count;

    }
}



package org.example.lesson6.Student;

public class Student {
    private String name;
    private int numGroup;
    private int course;
    private int [] marks;
    public Student (String name, int numGroup, int course, int [] marks){
        this.name = name;
        this.numGroup = numGroup;
        this.course = course;
        for(int m: marks) {
            if((m>0)&&(m<=5)){this.marks = marks;}
            else{System.out.println("Оценка должна быть целым положительным числом от 1 до 5");}
        }
    }

    public String getName() {
        return name;
    }

    public int getNumGroup() {
        return numGroup;
    }

    public int getCourse() {
        return course;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAverageMarcs(){
        double sum = 0;
        double avrMarks = 0;
        for(int a: marks){
            sum = a + sum;
        }
        return avrMarks = sum/(marks.length);
    }
}



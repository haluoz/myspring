package com.lxj.algorithm.sort;

public class Student implements Comparable{
    private String name;
    private Integer score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Student){
            Student s = (Student)o;
            if (this.score < s.score){
                return -1;
            }else if (this.score.equals(s.score)){
                return 0;
            } else {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

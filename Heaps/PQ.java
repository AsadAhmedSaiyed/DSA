import java.util.*;

public  class PQ {
  static class Student implements Comparable<Student>{//overriding
    String name;
    int rank;
    public Student(String name, int rank){
      this.name = name;
      this.rank = rank;
    }
    @Override
    public int compareTo(Student s2){
      return this.rank - s2.rank;
    } 
  }
  static class Marks implements Comparable<Marks>{
     String name;
     int score;
     public Marks(String name, int score){
      this.name = name;
      this.score = score;
     }
     @Override
     public int compareTo(Marks m2){
       return this.score - m2.score;
     } 
  }
  public static void main(String[] args) {
    PriorityQueue<Marks> pq2 = new PriorityQueue<>(); 
    PriorityQueue<Student> pq1 = new PriorityQueue<>();
    pq1.add(new Student("A",4));
    pq1.add(new Student("B",5));
    pq1.add(new Student("C",2));
    pq1.add(new Student("D",12));
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    pq.add(3);
    pq.add(4);
    pq.add(1);
    pq.add(7);
    while(!pq.isEmpty()){
      System.out.print(pq.peek() + " ");
      pq.remove();
    }
    pq2.add(new Marks("asad",99));
    pq2.add(new Marks("ahmed", 98));
    while(!pq2.isEmpty()){
      System.out.println(pq2.remove().score + " ");
    }
  }
}

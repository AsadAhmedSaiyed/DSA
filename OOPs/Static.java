public class Static {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.school = "KVS";
        Student s2 = new Student();

        System.out.println(s2.school);

        Student s3 = new Student();
         System.out.println(s3.school);
         s3.school = "JNV";
         System.out.println(s1.school);
    }
}

class Student{
    String name;
    int roll;

    static String school;

    void setName(String name){
        this.name = name;
    }

    String getName(){
        return this.name;
    }
}
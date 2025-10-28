public class Constructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        // Student s2 = new Student("asad");
        // Student s3 = new Student(123);
        // System.out.println(s2.name);
        // System.out.println(s3.roll);
        s1.name="asad";
        s1.roll = 123;
        s1.password ="abcd";
        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 80;
        Student s2 = new Student(s1);//copy
        s2.password="xyz";
        s1.marks[2] = 85; 
        for(int i=0;i<3;i++){
            System.out.println(s2.marks[i]);
        }
        
    }
}

class Student{
    String name;
    int roll;
    @SuppressWarnings("unused")
    String password;
    int marks[];

    //parameterized
    @SuppressWarnings("unused")
    Student(String name){
        marks = new int[3];
        this.name= name;
    }

    //non - parameterized
    Student(){
         marks = new int[3];
        System.out.println("Constructor is called...");
    }
    @SuppressWarnings("unused")
    Student(int roll){
         marks = new int[3];
        this.roll = roll;
    }

    //shallow copy constructor
    // Student(Student s1){
    //      marks = new int[3];
    //     this.name= s1.name;
    //     this.roll = s1.roll;
    //     this.marks =s1.marks;
    // } 

    //deep copy constructor
   
    @SuppressWarnings("ManualArrayToCollectionCopy")
    Student(Student s1){
        marks = new int[3];
        this.name = s1.name;
        this.roll = s1.roll;

        for(int i=0;i<marks.length;i++){
            this.marks[i] = s1.marks[i];
        }
    }
}

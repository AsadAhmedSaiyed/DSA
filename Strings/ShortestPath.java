public class ShortestPath {

    public static void shortestPath(String str){
        int y=0;
        int x=0;
        for(int i=0;i<str.length();i++){
            //north
            if(str.charAt(i) == 'N'){
                y++;
            }
            //south
            else if(str.charAt(i) == 'S'){
                y--;
            }
            //east
            else if(str.charAt(i) == 'E'){
                x++;
            }
            //wesst
            else{
                x--;
            }
        }
        int X2 = x*x;
        int Y2 = y*y;
        float sD= (float)Math.sqrt(X2+Y2);
        System.out.print("Shortest path : " + sD);
    }
    public static void main(String[] args) {
        // String path = "WNEENESENNN";
        //  String path = "NS";
        // shortestPath(path);

        String s1 = "Tony";
        String s2 = "Tony";
        //String s3 = new String("Tony");

        // if(s1 == s2){
        //     System.out.println("Equal");
        // }else{
        //     System.out.println("Not Equal");
        // }

        // if(s2 == s3){
        //     System.out.println("Equal");
        // }else{
        //     System.out.println("Not Equal");
        // }

        if(s1.equals(s2)){
            System.out.println("Equal");
        }else{
            System.out.println("Not Equal");   
        }
    }
}

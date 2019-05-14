public class JavaTest {

    public static void main(String[] args) {
        String[] strs = new String[10];
        int[] ints = new int[10];
        float[] fls = new float[10];
        Integer[] intgs = new Integer[10];

        if(strs[0]==null){
            System.out.println("String is null");
        }

        if(ints[0]==0){
            System.out.println("int is 0");
        }

        if(intgs[0]==null){
            System.out.println("intgs is null");
        }
        if(fls[0]==0f){
            System.out.println(fls[0]);
        }
    }
}

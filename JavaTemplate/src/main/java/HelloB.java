class HelloA {

    public HelloA() {
        System.out.println("HelloA");
    }
    
    { System.out.println("I'm A class"); }
    
    static { System.out.println("static A"); }

}

public class HelloB extends HelloA {
    public HelloB() {
        System.out.println("HelloB");
    }   //构造函数， 对象
    
    { System.out.println("I'm B class"); }      //构造语句块， 对象
    
    static { System.out.println("static B"); }   //静态语句块， 类
    
    public static void main1(String[] args) {
        System.out.println("-------main start-------");
        new HelloB();
        new HelloB();
        System.out.println("-------main end-------");
    }

    public static void main(String[] args) {
        int i,j,k;
        for(i=1;i<=1000;i++)
        {
            k=0;
            for(j=1;j<=i-1;j++)
                if(i%j==0) k+=j;
            if(k==i) System.out.println(i);
        }

    }

}
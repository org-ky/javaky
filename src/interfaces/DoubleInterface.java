public class DoubleInterface implements InterfaceA, InterfaceB{
    /*public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }*/
    
    @Override
    public int f(){
        int f = 0;
        System.out.println(DoubleInterface.class + " return " + f);
        
        return f;
    }
}

package com.company;

public class LambdaTest {

    static int x = 10;

    static void testCalculate(){
        Operationable operation = (x, y) -> x + y;
        System.out.println(operation.calculate(10, 20));
        Operationable operation1 = (x, y) -> x * y;
        System.out.println(operation1.calculate(10, 20));
    }

    static void testPrint(){
        Printable printable = System.out::println;
        //or
        //Printable printable = s -> System.out.println(s);
        printable.print("Hi Vsauce!");
    }

    static void testOperation1(){
        final int y = 20;
        Operationable1 op = () ->{
            x+=20;
            return x + y;
        };
        System.out.println(op.calculate());
    }

    static void testOperation2(){
        Operationable2<Integer> op = (x, y) -> {
            if(y == 0){
                System.out.println("Error");
                throw new RuntimeException();
            }
            else {
                return x / y;
            }
        };
        Operationable2<String> op1 = (x, y) -> x + y;
        System.out.println(op.devide(10, 5));
        System.out.println(op1.devide("10", "5"));
    }

    static void testExpression(){
        Expression expression = x -> x % 2 == 0;
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(sum(nums, expression));
        printOdd(nums, x -> x % 2 == 1);
    }

     private static int sum(int[] nums, Expression e){
        int sum = 0;
         for (int i = 0; i < nums.length; i++) {
             if(e.isEqual(nums[i])){
                 sum += nums[i];
             }
         }
         return sum;
     }

     private static void printOdd(int[] nums, Expression e){
         for (int i = 0; i < nums.length; i++) {
             if(e.isEqual(nums[i])){
                 System.out.println(nums[i]);
             }
         }
     }

     static void testMethodAsParam(){
         int[] nums = { -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
         System.out.println(sum(nums, LambdaTest::isEven));

         Expression expr = LambdaTest::isPositive;
         System.out.println(sum(nums, expr));
     }

    private static boolean isEven(int n){

        return n%2 == 0;
    }

    private static boolean isPositive(int n){

        return n > 0;
    }

    static void testConstructorAsParam(){
        UserBuilder userBuilder = User::new;
        User user = userBuilder.create("Tom");
        System.out.println(user.getName());
        //также можно сделать либо статическим методом класса-билдера или обычным конструктором
    }

    static void testLambdaAsReturn(){
        Operationable operationable = operation('+');
        System.out.println(operationable.calculate(5, 0));
        System.out.println(operation('-').calculate(2, 1));
    }

    private static Operationable operation(char sign){
        switch (sign){
            case '+': return  (x, y) -> x + y;
            case '-': return  (x, y) -> x - y;
            case '*': return  (x, y) -> x * y;
            default: return  (x, y) -> 0;
        }
    }
}

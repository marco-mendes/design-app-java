package laboratorio1.parte3.exemplo;

public class TestInterpreterPattern {

    public static void main(String[] args) {

        String input="2 1 5 + *";
        ExpressionParser expressionParser=new ExpressionParser();
        int result=expressionParser.parse(input);
        System.out.println("Final result: "+result);

    }


}
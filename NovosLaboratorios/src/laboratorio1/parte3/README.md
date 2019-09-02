## Design Pattern Interprete

### Material de preparação
[Pattern Interpreter](https://www.javacodegeeks.com/2015/09/interpreter-design-pattern.html)

### Introdução geral ao Pattern Interpreter
O Pattern Interpreter descreve como definir uma gramática para linguagens simples, representar sentenças na linguagem e interpretar essas sentenças, em outras palavras poderíamos 
definir sentenças personalizadas para a linguagem Java com um comportamento específico, no qual teríamos um interpretador que receberia essas sentenças e executaria a ação 
definida nessas sentenças na linguagem Java.

Ele é composto dos seguintes componentes:
 * Abstract Expression
 * TerminalExpression
 * NonterminalExpression
 * Context
 * Client
 
Cada um destes componentes foi abordado no material de preparação.

### Problema a ser resolvido
Suponhamos que nossa aplicação irá receber expressões matemáticas do Postfix e precisamos implementar alguma forma de nossa aplicação interpretar essas expressões.<br/>
Veremos como resolver este problema com o Pattern Interpreter nos próximos tópicos.

### Implementando o Pattern Interpreter
A interface abaixo irá definir um AbstractExpression que deve ser implementado pelos componentes TerminalExpression e NonterminalExpression 
```java
public interface Expression {
    int interpret();
}
```

Abaixo possuímos um TerminalExpression que ficará responsável por receber um valor do tipo String ou Int e retornar o mesmo como um número inteiro no método interpret():
```java
public class NumberExpression implements Expression{
    private int number;
    public NumberExpression(int number){
        this.number=number;
    }
    public NumberExpression(String number){
        this.number=Integer.parseInt(number);
    }
    @Override
    public int interpret(){
        return this.number;
    }
}
```


Em seguida criaremos 3 classes NonterminalExpression responsáveis pelas operações de Adição, Substração e Multiplicação dos valores de nossa expressão matemática Postfix.
```java
public class AdditionExpression implements Expression {
    private Expression firstExpression,secondExpression;
    public AdditionExpression(Expression firstExpression, Expression secondExpression){
        this.firstExpression=firstExpression;
        this.secondExpression=secondExpression;
    }
    @Override
    public int interpret(){
        return this.firstExpression.interpret()+this.secondExpression.interpret();
    }
    @Override
    public String toString(){
        return "+";
    }
}
```

```java
public class SubtractionExpression implements Expression{
    private Expression firstExpression,secondExpression;
    public SubtractionExpression(Expression firstExpression, Expression secondExpression){
        this.firstExpression=firstExpression;
        this.secondExpression=secondExpression;
    }
    @Override
    public int interpret(){
        return this.firstExpression.interpret()-this.secondExpression.interpret();
    }
    @Override
    public String toString(){
        return "-";
    }
}
```

```java
public class MultiplicationExpression implements Expression{
    private Expression firstExpression,secondExpression;
    public MultiplicationExpression(Expression firstExpression, Expression secondExpression){
        this.firstExpression=firstExpression;
        this.secondExpression=secondExpression;
    }
    @Override
    public int interpret(){
        return this.firstExpression.interpret()*this.secondExpression.interpret();
    }
    @Override
    public String toString(){
        return "*";
    }
}
```

Em todas as classes acima, declaramos duas variáveis ​​do tipo Expression e as inicializamos através do construtor de cada classe.<br/>
Em cada classe, chamamos o método interpret() das variáveis Expression, executamos a operação matemática correspondente e retornamos o resultado.

Abaixo está a classe de utilitário opcional que contém diferentes métodos de utilitário usados ​​para executar a expressão.
```java
public class ParserUtil {
    public static boolean isOperator(String symbol) {
        return (symbol.equals("+") || symbol.equals("-") || symbol.equals("*"));
    }
    public static Expression getExpressionObject(Expression firstExpression,Expression secondExpression,String symbol){
        if(symbol.equals("+"))
            return new AdditionExpression(firstExpression,secondExpression);
        else if(symbol.equals("-"))
            return new SubtractionExpression(firstExpression,secondExpression);
        else
            return new MultiplicationExpression(firstExpression,secondExpression);
    }
}
```

A classe ParserUtil que escrevemos acima tem dois método, o método isOperator() retornará um valor booleano verdadeiro se a String recebida por ele for um operador e o 
método getExpressionObject() retorna uma instância Expression com base nos dois objetos Expression e no símbolo da operação passado para ela.

Vamos agora escrever o analisador de expressões.

Na classe ExpressionParser abaixo, escrevemos um método parse() que gera um token de símbolo a partir da expressão passada para ele.<br/>
Em seguida ele percorre cada caracter e verifica com a classe ParserUtil se o caracter atual é um operador ou não.<br/>
Se o caracter não for um operador, ele cria um NumberExpression e o envia para o Stack com o método push().
Se for um operador, o código retira dois elementos do Stack, aplica o operador e envia o resultado para a Stack.
Neste exemplo utilizamos o método interpret() para executar as expressões criadas.
```java
import java.util.Stack;

public class ExpressionParser {
    Stack<Expression> stack=new Stack<>();
    public int parse(String str){
        String[] tokenList = str.split(" ");
        for (String symbol : tokenList) {
            if (!ParserUtil.isOperator(symbol)) {
                Expression numberExpression = new NumberExpression(symbol);
                stack.push(numberExpression);
                System.out.println(String.format("Pushed to stack: %d", numberExpression.interpret()));
            } else  if (ParserUtil.isOperator(symbol)) {
                Expression firstExpression = stack.pop();
                Expression secondExpression = stack.pop();
                System.out.println(String.format("Popped operands %d and %d",
                        firstExpression.interpret(), secondExpression.interpret()));
                Expression operator = ParserUtil.getExpressionObject(firstExpression, secondExpression, symbol);
                System.out.println(String.format("Applying Operator: %s", operator));
                int result = operator.interpret();
                NumberExpression resultExpression = new NumberExpression(result);
                stack.push(resultExpression);
                System.out.println(String.format("Pushed result to stack: %d", resultExpression.interpret()));
            }
        }
        int result= stack.pop().interpret();
        return result;
    }
}
```

Para testar nossa aplicação iremos utilizar nosso ExpressionParser que irá receber como parâmetro uma expressão matemática Postfix conforme o exemplo abaixo:
```java
public class TestInterpreterPattern {

    public static void main(String[] args) {

        String input="2 1 5 + *";
        ExpressionParser expressionParser=new ExpressionParser();
        int result=expressionParser.parse(input);
        System.out.println("Final result: "+result);

    }


}
```


### Exercício
Utilizando o Patter Interpreter crie uma sentença personalizada chamada **TextInterpreter**, essa sentença deve receber como parâmetro: um texto, uma lista de adjetivos, 
uma lista de artigos e uma lista de substantivos que serão informados logo abaixo.<br/>
Com base nos artigos, adjetivos e substantivos recebidos pelo TextInterpreter verifique quais foram encontrados no texto recebido.

Utilize os seguintes Artigos, Adjetivos e Substantivos para esse exercício:
 * Artigos: "o", "a", "os", "as", "do", "da", "dos", "das"<br/>
 * Adjetivos: "brasileiro", "brasileira", "bonito", "bonita", "alegre"<br/>
 * Substantivos: "livro", "caneta", "homem", "mulher", "biblioteca"

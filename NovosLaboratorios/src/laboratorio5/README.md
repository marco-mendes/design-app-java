## Introdução a coleções avançadas

### Material de preparação
[LinkedList](https://www.baeldung.com/java-linkedlist)<br/>
[LinkedHashMap](https://www.baeldung.com/java-linked-hashmap)<br/>
[Stack](https://www.baeldung.com/java-stack)<br/>
[ArrayDeque](https://www.baeldung.com/java-array-deque)

### Introdução
Neste laboratórios daremos uma introdução sobre algumas coleções mais avançadas do Java.<br/>
Abordaremos as seguintes coleções:
 * LinkedList
 * LinkedHashMap
 * Stack
 * ArrayDeque
 
 
### LinkedList
LinkedList é uma implementação de lista duplamente vinculada das interfaces List e Deque.<br/>
Ela implementa todas as operações de lista opcionais e permite todos os elementos incluindo valores nulos.

Um LinkedList consome mais memória que um ArrayList porém algumas operações do LinkedList como adicionar e remover itens é mais rápida que a de um ArrayList.

#### Criando um LinkedList
Um LinkedList pode ser criado da seguinte forma:
```java
LinkedList<Object> linkedList = new LinkedList<>();
```

#### Adicionando elementos ao LinkedList
O LinkedList implementa as interfaces List e Deque, com isso ele possui os métodos padrão de adição de elementos da interface List que são add() e addAll(), além de possuir também os 
métodos addFirst() e addLast() da interface Deque que adicionam um elemento no início ou no final da lista, respectivamente.<br/>
Exemplo de uso:
```java
import java.util.Arrays;
import java.util.LinkedList;

public class Exemplo1 {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Add interface List");

        linkedList.addAll(Arrays.asList("valor 1", "valor 2", "valor 3"));

        linkedList.addFirst("Primeiro da lista");
        linkedList.addLast("Ultimo da lista");

        linkedList.forEach(v -> System.out.println(v));

    }
    
}
```

#### Removendo elementos
A remoção de elementos de um LinkedList pode ser feita utilizando o método padrão remove(), além de podermos utilizar os métodos removeFirst() e removeLast() que removem o primeiro e 
ultimo elementos da lista respectivamente.<br/>
Exemplo de uso:
```java
import java.util.Arrays;
import java.util.LinkedList;

public class Exemplo2 {

    public static void main(String[] args) {
        
        LinkedList<Integer> lista = new LinkedList<>();
        lista.addAll(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        lista.remove(1);
        lista.removeFirst();
        lista.removeLast();
        
    }

}
```

#### Utilizando um LinkedList como uma Queue
Uma queue representa uma fila, nele possuímos os métodos poll() e pop() que recuperam o primeiro elemento da lista e o removem da mesma, a diferença entre eles é que caso o elemento 
esteja vazio o pop() lançará um NoSuchElementException (), já o poll() retornará nulo.<br/>
Exemplo de uso:
```java
import java.util.Arrays;
import java.util.LinkedList;

public class Exemplo3 {

    public static void main(String[] args) {
        LinkedList<String> lista = new LinkedList<>();
        lista.addAll(Arrays.asList("Valor 1", "Valor 2", "Valor 3", "Valor 4"));
        System.out.println(lista.poll());
        System.out.println(lista.pop());
        System.out.println(lista);
    }

}
```

#### Exercício 1
Com base no código abaixo crie um LinkedList utilizando a lista disponível no código abaixo, remova o primeiro e o ultimo elemento da LinkedList, após isso adicione um 
novo elemento no início da lista com o valor "Novo primeiro elemento" e no fim da lista adicione o valor "Novo ultimo valor".
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercicio1 {

    public static void main(String[] args) {
        List<String> valores = new ArrayList<>();
        valores.addAll(Arrays.asList("Primeiro valor", "Segundo valor", "Terceiro valor", "Quarto valor", "Ultimo valor"));
    }
    
}
```

### LinkedHashMap
A classe LinkedHashMap é muito semelhante ao HashMap na maioria dos aspectos. No entanto, o LinkedHashMap é baseado na tabela de hash e na lista vinculada para aprimorar 
a funcionalidade do HashMap.<br/>
Outra diferença entre LinkedHashMap e HashMap é que a ordem de iteração de um LinkedHashMap por padrão é a ordem de inserção dos elementos, já o HashMap não possui 
nenhuma garantia que a ordem permanecerá constante ao decorrer do tempo.

A criação de um LinkedHashMap é feita da mesma forma da criação de um HashMap.<br/>
Exemplo:
```java
import java.util.LinkedHashMap;

public class Exemplo4 {

    public static void main(String[] args) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("valor 1", "primeiro valor");
        linkedHashMap.put("valor 2", "segundo valor");
        linkedHashMap.put("valor 3", "terceiro valor");
        linkedHashMap.put("valor 4", "quarto valor");
    }
    
}
``` 

#### Exercício 2
Crie um LinkedHashMap no qual a chave é um número inteiro e o valor é uma String.<br/>
Insira 5 elementos no objeto criado, os valores podem ser definidos por você.


### Stack
O Stack é uma estrutura de dados genérica que representa uma coleção de objetos LIFO (último a entrar, primeiro a sair), podendo também ser comparado com a estrutura de dados 
de uma Pilha.<br/>

#### Criando um Stack
Um Stack pode ser criado da seguinte forma:
```java
Stack<Integer> intStack = new Stack();
```
Isso criará um Stack com a capacidade padrão de 10 posições.<br/>
Se o número de elementos adicionados exceder o tamanho total do Stack , essa capacidade será duplicada automaticamente porém é importante observar que seu tamanho nunca 
diminui após a remoção de algum elemento.

#### Adicionando valores a um Stack
Podemos adicionar valores a um Stack com os métodos **push()** e **addAll()**, o método **push()** adiciona um elemento ao Stack já o método **addAll()** adiciona uma lista 
de valores ao Stack como mostrado no exemplo abaixo:
```java
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Exemplo5 {

    public static void main(String[] args) {
        Stack<Integer> stackDeInteiros = new Stack();
        stackDeInteiros.push(1);
        System.out.println(stackDeInteiros);

        List<Integer> listaDeInteiros = Arrays.asList(2, 3, 4, 5, 6, 7, 8);
        stackDeInteiros.addAll(listaDeInteiros);
        System.out.println(stackDeInteiros);
    }

}
```

#### Obtendo elementos do Stack
Existem duas formas de obter os elementos armazenados no Stack:
 * Obter o ultimo elemento da lista e removê-lo da lista: Operação realizada com o método **pop()**.
 * Obter o ultimo elemento da lista sem removê-lo da lista: Operação realizada com o método **peek()**.

Exemplo de uso: 
```java
import java.util.Arrays;
import java.util.Stack;

public class Exemplo6 {

    public static void main(String[] args) {
        Stack<Integer> stackDeInteiros = new Stack();
        stackDeInteiros.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

        System.out.println(stackDeInteiros.peek());
        System.out.println(stackDeInteiros);

        System.out.println(stackDeInteiros.pop());
        System.out.println(stackDeInteiros);
    }

}
```

#### Removendo elementos de um Stack
Podemos remover elementos de um Stack com 3 métodos além do **pop()** que obtem e remove o ultimo elemento do Stack, são eles:
 * **removeElement()**: Remove um elemento especificado do Stack
 * **removeElementAt()**: Remove um elemento especificado do Stack pelo seu indice
 * **removeIf**: Nos permite criar uma filtragem com uma expressão lambda para remover todos os elementos filtrados por ela. 
 
Exemplo de uso:
```java
public class Exemplo7 {

    public static void main(String[] args) {
        Stack<String> stack1 = new Stack<>();
        stack1.push("Elemento 1");
        stack1.push("Elemento 2");
        stack1.push("Elemento 3");

        stack1.removeElement("Elemento 2");
        System.out.println(stack1);

        Stack<String> stack2 = new Stack<>();
        stack2.push("Elemento 1");
        stack2.push("Elemento 2");
        stack2.push("Elemento 3");

        stack2.removeElementAt(0);
        System.out.println(stack2);
        
        Stack<Integer> stack3 = new Stack<>();
        stack3.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        stack3.removeIf(element -> element > 5);
        System.out.println(stack3);

    }

}
```

#### Exercicio 3
Crie um Stack utilizando os elementos contidos na lista do código abaixo e remova qualquer elemento que seja um número impar.<br/>
Após isso obtenha o ultimo elemento do Stack e o imprima no console sem removê-lo do Stack.
```java
import java.util.Arrays;
import java.util.List;

public class Exercicio3 {

    public static void main(String[] args) {
        List<Integer> listaInteiros = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    }
    
}
```

### ArrayDeque
Um ArrayDeque é um tipo especial de matriz cultivável que permite adicionar ou remover um elemento no inicio ou no fim do objeto.<br/>

Seus principais métodos são:
 * **offerFirst()** ou **addFirst()**: Adiciona um elemento no começo da coleção. 
 * **pollFirst()** ou **removeFirst()**: Remove o primeiro elemento da coleção.
 * **peekFirst()** ou **getFirst()**: Obtem o primeiro elemento da coleção.
 * **offerLast()** ou **addLast()**: Adiciona um elemento no fim da coleção.
 * **pollLast()** ou **removeLast()**: Remove o ultimo elemento da coleção.
 * **peekLast()** ou **getLast()**: Obtem o ultimo elemento da coleção.
 
Uma implementação ArrayDeque pode ser usada como uma Stack ou pilha(último a entrar, primeiro a sair) ou uma Queue ou fila(primeiro a entrar, primeiro a sair).<br/>
Na lista dos principais método acima os métodos a esqueda são referentes a implementação de uso Stack, já os métodos a direita são referentes a implementação de uso Queue.
 
Exemplo de uso:
```java
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Exemplo9 {

    public static void usandoComoStack() {
        Deque<String> deque = new ArrayDeque<>();
        deque.addAll(Arrays.asList("Primeiro, Segundo, Terceiro, Quarto, Ultimo"));
        deque.offerFirst("Elemento entrou no lugar do primeiro elemento");
        deque.offerLast("Elemento entrou no lugar do ultimo elemento");
        //Removento primeiro elemento
        deque.pollFirst();
        //Removendo ultimo elemento
        deque.pollLast();
        System.out.println(String.format("Primeiro elemento: %s", deque.peekFirst()));
        System.out.println(String.format("Ultimo elemento: %s", deque.peekLast()));
    }

    public static void usandoComoQueue() {
        Deque<String> deque = new ArrayDeque<>();
        deque.addAll(Arrays.asList("Primeiro, Segundo, Terceiro, Quarto, Ultimo"));
        deque.addFirst("Elemento entrou no lugar do primeiro");
        deque.addLast("Elemento entrou no lugar do ultimo elemento");
        //Removento primeiro elemento
        deque.removeFirst();
        //Removendo ultimo elemento
        deque.removeLast();
        System.out.println(String.format("Primeiro elemento: %s", deque.getFirst()));
        System.out.println(String.format("Ultimo elemento: %s", deque.getLast()));
    }

    public static void main(String[] args) {
        usandoComoStack();
        usandoComoQueue();
    }
    
}
```

#### Exercício 4
Crie um ArrayDeque com base na lista disponibilizada no código abaixo, após isso obtenha o primeiro e ultimo elemento do ArrayDeque e os 
imprima no console, adicione também um novo elemento ao inicio e ao fim da coleção.
```java
import java.util.Arrays;
import java.util.List;

public class Exercicio4 {

    public static void main(String[] args) {
        List<String> lista = Arrays.asList("Posição 1", "Posição 2", "Posição 3", "Posição 4");        
    }
    
}
```

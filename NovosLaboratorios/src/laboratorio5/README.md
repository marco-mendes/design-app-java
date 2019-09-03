## Introduçao a coleções avançadas

### Material de preparação
[LinkedList](https://www.baeldung.com/java-linkedlist)<br/>
[LinkedHashMap](https://www.baeldung.com/java-linked-hashmap)<br/>
[Stack](https://www.baeldung.com/java-stack)<br/>
[ArrayDeque](https://www.baeldung.com/java-array-deque)

### Introdução
Neste laboratórios daremos uma introdução sobre algumas coleçõs mais avançadas do Java.<br/>
Abordaremos as seguintes coleções:
 * LinkedList
 * LikedHashMap
 * Stack
 * ArrayDeque
 
 
### LinkedList
LinkedList é uma implementação de lista duplamente vinculada dasinterfaces List e Deque.<br/>
Ela implementa todas as operações de lista opcionais e permite todos os elementos incluindo valores nulos.

Um LinkedList consome mais memória que um ArrayList porém algumas operações do LinkedList como adicionar e remover itens é mais rápida que em um ArrayList.

#### Criando um LinkedList
Um LinkedList pode ser criado da seguinte forma:
```java
LinkedList<Object> linkedList = new LinkedList<>();
```

#### Adicionando elementos ao LinkedList
O LinkedList implementa as interfaces List e Deque, com isso ele possui os métodos padrão de adição da interface List que são add() e addAll(), além de possuir também alguns 
métodos da interface Deque que são addFirst() e addLast() , que adicionam um elemento no início ou no final da lista, respectivamente.<br/>
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
A remoção de elementos de um LinkedList pode ser feita utilizando o método padrão remove(), além de por utilizar os métodos removeFirst() e removeLast() que removem o primeiro e 
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
Com base no código abaixo crie um LinkedList utilizando lista disponível criada no código abaixo, remova o primeiro e o ultimo elemento da LinkedList, após isso adicione um 
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


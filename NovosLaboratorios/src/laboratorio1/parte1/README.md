## Design Pattern Visitor

### Material de preparação
[Patter Visitor](https://www.geeksforgeeks.org/visitor-design-pattern/)<br/>
[Mais exemplos Patter Visitor](https://www.tutorialspoint.com/design_pattern/visitor_pattern.htm)

### Visão geral do Pattern Visitor
O Pattern Visitor permite que se crie uma nova operação sem que se mude a classe dos elementos sobre as quais ela opera.<br/>
Sendo uma maneira de separar um algoritmo da estrutura de um objeto. Um resultado prático é a habilidade de adicionar novas funcionalidades a estruturas de um 
objeto pré-existente sem a necessidade de modificá-las.

Os participantes deste Pattern são:
 * **Element**: Normalmente uma interface que define um método **accept()** que aceita como argumento um Visitor.
 * **Contrete Element**: Uma classe concreta que implementa uma interface Element
 * **Visitor**: Normalmente uma interface que declara um método **visit()** para cada classe concreta Concrete Element
 * **Concrete Visitor**: Uma classe concreta que implementa cada operação declarada por um visitor.
 
#### Problema a ser resolvido
Considere o seguinte cenário, possuímos uma classe **Nota Fiscal** no qual constantemente precisamos aplicar na mesma novos descontos referentes a impostos.<br/>
O grande problema é que sempre que um novo imposto for criado será necessário alterar a implementação da classe **Nota Fiscal**, poderíamos resolver este problema 
utilizando o Pattern Visitor para que possamos aplicar novos comportamentos a classe **Nota Fiscal** sem alterar a implementação original da mesma.<br/>
Veremos nos próximos tópicos a implementação deste Pattern.

### Estruturando nosso participante Element:
Como vimos o **Element** é basicamente uma interface que aplica o um método **accept()** recebendo como argumento um **visitor**.<br/> 
No exemplo abaixo criamos a interface **VisitableElement** para definir nosso participante **Element**, o mesmo recebe em seu método **accept()** nosso visitor 
**NotaFiscalVisitor** que será criado posteriormente.
```java
public interface VisitableElement {

     public void accept(NotaFiscalVisitor visitor);

}
```

### Estruturando nosso participante Concrete Element
Nosso participante **Concrete Element** será uma classe concreta que implementa nossa interface **VisitableElement** conforme o exemplo abaixo:
```java
import java.util.HashMap;
import java.util.Map;

public class NotaFiscal implements VisitableElement {

    private double valorBruto;
    private double valorLiquido;
    private Map<String, Double> descontos = new HashMap<>();

    public NotaFiscal(double valorNota) {
        this.valorBruto = valorNota;
        this.valorLiquido = valorNota;
    }

    public double getValorBruto() {
        return valorBruto;
    }

    public double getValorLiquido() {
        return valorLiquido;
    }

    public Map<String, Double> getDescontos() {
        return descontos;
    }

    public void adicionarDesconto(String nomeDesconto, Double valorDesconto) {
        this.descontos.put(nomeDesconto, valorDesconto);
        this.valorLiquido = this.valorLiquido - valorDesconto;
    }

    @Override
    public void accept(NotaFiscalVisitor visitor) {
        visitor.visit(this);
    }
}
```

### Estruturando nosso participante Visitor
Definiremos aqui a interface responsavel por representar nosso **Visitor**, a mesma recebe em seu método **visit()** um **Concrete Element** como parâmetro.
```java
public interface NotaFiscalVisitor {

    public void visit(NotaFiscal notaFiscal);

}
```

Uma observação importante é que nosso **Visitor** pode possuir um ou mais métodos **visit()**, cada um deles referente a um **Concrete Element** associado a uma 
implementação, em nosso exemplo teremos apenas o **Concrete Element** **NotaFiscal**.

### Estruturando nosso participante Concrete Visitor
O **Concrete Visitor** será responsável por armazenar nossa lógica de aplicação de impostos em nossa **Nota Fiscal**, abaixo alguns exemplos 
de implementação do mesmo:
```java
public class AplicarImpostoCOFINSVisitor implements NotaFiscalVisitor {

    private double percentualDesconto = 0.03;

    @Override
    public void visit(NotaFiscal notaFiscal) {
        double valorDesconto = notaFiscal.getValorBruto() * percentualDesconto;
        notaFiscal.adicionarDesconto("COFINS", valorDesconto);
        System.out.println(String.format("Adicionando desconto CONFIS no valor de %s", valorDesconto));
    }
}
```

```java
public class AplicarImpostoISSVisitor implements NotaFiscalVisitor {

    private double percentualDesconto = 0.02;

    @Override
    public void visit(NotaFiscal notaFiscal) {
        double valorDesconto = notaFiscal.getValorBruto() * percentualDesconto;
        notaFiscal.adicionarDesconto("ISS", valorDesconto);
        System.out.println(String.format("Adicionando desconto ISS no valor de %s", valorDesconto));
    }
}
```

### Testando a implementação
Podemos testar a implementação deste Pattern da seguinte forma:
```java
public class PatternVisitorMain {

    public static void main(String[] args) {
        NotaFiscal nota = new NotaFiscal(2000);
        nota.accept(new AplicarImpostoISSVisitor());
        System.out.println(String.format("Valor nota fiscal com o desconto ISS aplicado: %s", nota.getValorLiquido()));

        nota.accept(new AplicarImpostoCOFINSVisitor());
        System.out.println(String.format("Valor nota fiscal com o desconto COFINS aplicado: %s", nota.getValorLiquido()));

        System.out.println("Descontos aplicados na Nota Fiscal:");
        nota.getDescontos().forEach((key, value) -> {
            System.out.println(
                    String.format("Desconto: %s | Valor: %s", key, value)
            );
        });

        System.out.println(String.format("Valor bruto da Nota Fiscal: %s", nota.getValorBruto()));
        System.out.println(String.format("Valor líquido da Nota Fiscal: %s", nota.getValorLiquido()));
    }

}
```

Caso seja necessário adicionar novas operações de aplicação de impostos basta criar um novo **Concrete Visitor** e aplicá-lo a classe **NotaFiscal** através do método **accept()**.

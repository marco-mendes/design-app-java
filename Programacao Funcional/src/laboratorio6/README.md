# Laboratório Interface Funcional UnaryOperator - Protótipo

### Material de Preparação
[Uso Interface Funcional UnaryOperator com Exemplos](https://www.geeksforgeeks.org/unaryoperator-interface-in-java/)<br/>
[Vários exemplos de uso da Interface Funcional UnaryOperator](https://www.programcreek.com/java-api-examples/?api=java.util.function.UnaryOperator)

### Introdução
A Interface Funcional UnaryOperator faz parte do grupo de Interfaces Funcionais do tipo Operator.
<br/>As interfaces do tipo Operator são casos especiais da [Interface Funcional Function](https://github.com/corelioBH/design-app-java/tree/master/Programacao%20Funcional/src/laboratorio2), a diferença é que as Interfaces do tipo Operator recebem e retornam o mesmo tipo de valor.
<br/>Portanto, o UnaryOperator<T&gt; sobrecarrega o tipo Function<T, T> e assim herdando os seguintes métodos da interface funcional de Function:
 * apply()
 * andThen()
 * compose()

O uso de cada um desses é abordado no [Laboratório 2](https://github.com/corelioBH/design-app-java/tree/master/Programacao%20Funcional/src/laboratorio2).
<br/>Exemplos de uso dos mesmos podem ser observados nos materias de preparação.

Exemplo de uso básico do UnaryOperator:
 



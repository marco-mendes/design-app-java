# Laboratório Interface Funcional Consumer - Protótipo

### Material de Preparação
[Uso Interface Funcional Consumer com Exemplos](https://www.geeksforgeeks.org/java-8-consumer-interface-in-java-with-examples/)

### Introdução
A Interface Funcional Consumer representa uma função que aceita um argumento e produz um resultado.
<br/>No entanto, esse tipo de função não retorna nenhum valor.
<br/>A expressão lambda atribuída a um objeto do tipo Consumer é usada para definir o comportamento de seu método **accept()**, que eventualmente aplica a operação atribuída ao Consumer em seu argumento.
<br/>A interface Consumer é útil quando não precisamos retornar nenhum valor, pois a mesma funciona via efeitos colaterais.
<br/>Um exemplo de efeito colateral é passarmos uma lista como parâmetro ao método **accept()** e executarmos uma rotina de ordenação dessa lista através do Consumer, ao fim da execução da função nossa variável local referente a lista passada ao Consumer terá todos os seus valores alterados conforme o processamento realizado dentro do Consumer.

Exemplo de uso básico:
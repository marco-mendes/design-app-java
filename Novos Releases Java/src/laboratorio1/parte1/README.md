## Introdução ao Jshell

### Material de preparação
[Jshell](https://imasters.com.br/desenvolvimento/introducao-ao-java-9-jshell)<br/>


### Introdução
O Jshell foi um recurso introduzido no Java 9 com o intuito de ser um terminal interativo no qual podemos rodar código Java de maneira simples 
sem ter que ficar criando classes e métodos Main, dessa forma nos permitindo executar testes de maneira rápida e fácil.<br/>
Abordaremos aqui o uso básico do Jshell.


### Iniciando o Jshell
Com o JDK 9 ou superior instalado, basta executar o comando **jshell** para iniciá-lo.<br/>
Exemplo:<br/>
<img src="https://github.com/corelioBH/design-app-java/blob/master/Novos%20Releases%20Java/src/laboratorio1/parte1/exemplos/exemplo1.PNG"/>

### Fechando o Jshell
Para fechar o Jshell basta executar o seguinte comando: **/exit**<br/>
Exemplo:<br/>
<img src="https://github.com/corelioBH/design-app-java/blob/master/Novos%20Releases%20Java/src/laboratorio1/parte1/exemplos/exemplo2.PNG"/>

### Declarando variáveis
Para realizarmos a declaração de variáveis no Jshell não precisamos criar nenhuma classe, podemos simplesmente digitar a declaração normalmente no Jshell e pressionar a tecla ENTER para confirmar.<br/>
Exemplo declaração e variável:<br/> 
<img src="https://github.com/corelioBH/design-app-java/blob/master/Novos%20Releases%20Java/src/laboratorio1/parte1/exemplos/exemplo3.PNG"/><br/>
Note que ao definir um valor a uma variável o Jshell nos retorna o valor da mesma.

### Declarando métodos
Para realizarmos a declaração de métodos no Jshell não precisamos criar nenhuma classe, podemos simplesmente digitar a declaração normalmente no Jshell, a diferença da declaração de métodos para a 
declaração de variáveis é que o Jshell reconhece que o que está sendo digitado é um método, e ao pressionar a tecla ENTER o mesmo realiza uma quebra de linha até que o método que está 
sendo digitado seja corretamente finalizado.<br/>
Exemplo:<br/>
<img src="https://github.com/corelioBH/design-app-java/blob/master/Novos%20Releases%20Java/src/laboratorio1/parte1/exemplos/exemplo4.PNG"/>

### Invocando métodos
Conforme vimos no tópico acima, declaramos um método chamado **imprimeAlgo**, a invocação do mesmo pode ser realizada da mesma forma que realizamos dentro de uma classe Java.<br/>
Exemplo:<br/>
<img src="https://github.com/corelioBH/design-app-java/blob/master/Novos%20Releases%20Java/src/laboratorio1/parte1/exemplos/exemplo4.PNG"/>

#### Exercício 1
Com base no que foi apresentado até agora utilize o Jshell para declarar um método chamado **soma** que receba dois números inteiros e imprima o valor da soma dos números recebidos.<br/>
Após declarar o método **soma** o invoque utilizado quaisquer números inteiros como parâmetro para validar o funcionamento do mesmo.


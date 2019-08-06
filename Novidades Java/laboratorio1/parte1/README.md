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
<img src="./exemplos/exemplo01.PNG"/>

### Fechando o Jshell
Para fechar o Jshell basta executar o seguinte comando: **/exit**<br/>
Exemplo:<br/>
<img src="./exemplos/exemplo02.PNG"/>

### Declarando variáveis
Para realizarmos a declaração de variáveis no Jshell não precisamos criar nenhuma classe, podemos simplesmente digitar a declaração normalmente no Jshell e pressionar a tecla ENTER para confirmar.<br/>
Exemplo declaração e variável:<br/> 
<img src="./exemplos/exemplo03.PNG"/><br/>
Note que ao definir um valor a uma variável o Jshell nos retorna o valor da mesma.

### Declarando métodos
Para realizarmos a declaração de métodos no Jshell não precisamos criar nenhuma classe, podemos simplesmente digitar a declaração normalmente no Jshell, a diferença da declaração de métodos para a 
declaração de variáveis é que o Jshell reconhece que o que está sendo declarado é um método, e ao pressionar a tecla ENTER o mesmo realiza uma quebra de linha até que o método que está 
sendo declarado seja corretamente finalizado.<br/>
Exemplo:<br/>
<img src="./exemplos/exemplo04.PNG"/>

### Invocando métodos
Conforme vimos no tópico acima, declaramos um método chamado **imprimeAlgo**, a invocação do mesmo pode ser realizada da mesma forma que realizamos dentro de uma classe Java.<br/>
Exemplo:<br/>
<img src="./exemplos/exemplo05.PNG"/>

#### Exercício 1
Com base no que foi apresentado até agora utilize o Jshell para declarar um método chamado **soma** que receba dois números inteiros e imprima o valor da soma dos números recebidos.<br/>
Após declarar o método **soma** o invoque utilizado quaisquer números inteiros como parâmetro para validar o funcionamento do mesmo.

### Declarando classes
A declaração de classes no Jshell é bem semelhante a declaração de métodos, o Jshell reconhece que o que está sendo declarado é uma classe, e ao pressionar a tecla ENTER o mesmo realiza uma quebra de linha até que a classe que está 
sendo declarada seja corretamente finalizada.<br/>
Exemplo:<br/>
<img src="./exemplos/exemplo06.PNG"/>

#### Exercício 2
Utilizando o Jshell declare uma classe chamada **Produto**, a mesma deve possuir apenas dois atributos, um do tipo String chamado **nome** e outro do tipo Double chamado **preco**.<br/>
Esta classe deve possuir um Construtor com ambos os atributos e deve possuir também os métodos getters de ambos.

**Atenção, não feche o Jshell após realizar este exercício, a classe criada no mesmo será utilizada no Exercício 3**

### Editando declarações no Jshell
Para editar declarações no Jshell devemos primeiro obter o ID da declaração, podemos fazer isso utilizando o seguinte comando: **/list**<br/>
Conforme o exemplo abaixo o ID da classe declarada no tópico **Declarando Classes** possui o ID 1.<br/> 
<img src="./exemplos/exemplo07.PNG"/>

Suponhamos que queremos adicionar um método chamado **imprimePessoa** nessa classe, para isso teríamos que editar a mesma, porém como faríamos isso no Jshell?<br/>
Para realizar esse procedimento o Jshell disponibiliza o **Jshell Edit Pad**, este é o editor padrão do Jshell, para utilizá-lo basta executar o comando **/edit ID** passando como 
parâmetro o ID da declaração.<br/>
Exemplo<br/>
<img src="./exemplos/exemplo08.PNG"/>

Ao executar este comando veremos uma nova janela como esta:<br/>
<img src="./exemplos/exemplo09.PNG"/>

Para realizar uma edição nessa janela basta apenas editar o conteudo da declaração e logo em seguida clicar nos botões **Accept** e **Exit** para salvar as modificações.<br/>
Neste exemplo declaramos o método **imprimePessoa** para imprimir o nome da pessoa:<br/>
<img src="./exemplos/exemplo10.PNG"/>

Exemplo de uso do método declarado na edição:<br/>
<img src="./exemplos/exemplo11.PNG"/>

#### Exercício 3
Com base no tópico acima e utilizando a classe criada no **Exercício 2**, edite a classe Produto e crie um método chamado **imprimeProduto**, 
este método deve imprimir o nome e o preço do produto.
## Visão geral sobre testes de Performance

### Introdução

 Testes de performance são testes nos quais uma aplicação é submetida a uma carga de trabalho dentro de condições específicas por um tempo determinado com o objetivo de verificar os comportamentos diferentes que essas condições e cargas podem proporcionar. 

Com estes procedimentos, podemos observar o comportamento de todo o ambiente da aplicação, desde os defeitos de desempenho (como *timeouts* e tempo de resposta inaceitáveis), funcionais (como inconsistência de dados), estruturais (como *memory leak*, dados corrompidos e rede com problemas) e até mesmo de segurança (exposição dos dados, etc.). 



### Porquê devemos executar?

- Identificar e quantificar o risco dos serviços/aplicações;
- Definir configurações mínimas para rodar o sistema;
- Determinar tempos de respostas de uma forma que conseguimos “aferir”, são os chamados *throughputs;*
- Identificar os possíveis gargalos (*bottlenecks)* da aplicação;
- Gestão de configuração, comprar as diversas plataformas de hardware e Sistemas Operacionais.



### Quais são os benefícios?

- Melhoria da qualidade da aplicação para o usuário final;
- Aumento dos lucros, por estar prevendo falhas e corrigindo-as, antes do produto entrar em produção.



### Porquê é difícil de executar?

- Teste Complexo, exige expertise na área;
- Devem ser iniciados assim que os requisitos forem estabelecidos;
- Requer ferramentas de automação, e uma boa infraestrutura de hardware;
- Primordial um ambiente propício, com banda, configuração do sistema, acessos concorrentes, para que dessa forma os resultados sejam mais reais possíveis;
- Não se deve realizar estes tipos de testes em produção.



### O que podemos testar?

- Carga (Load): Identifica os níveis máximos, os quais um sistema/aplicação pode realizar com sucesso em termos de carga de trabalho(workload) e número de usuários virtuais(Virtual Users).
- Stress: É realizado para submeter o software a situações extremas. Basicamente, o teste de estresse baseia-se em testar os limites do software e avaliar seu comportamento. Assim, avalia-se até quando o software pode ser exigido e quais as falhas (se existirem) decorrentes do teste.
- Capacidade: Responsáveis por medir até aonde o seu sistema/aplicação é capaz de atuar sem falhas com dada “carga normal” até que o tempo de resposta seja inaceitável.



### Quais as diferenças entre *Testes de Performance* **x** *Testes Funcionais*?

**Performance** — Não testa o front, testa apenas os requisitos não funcionais **Funcional** — Testa o Front, bem como usabilidade e funcionalidades

**Performance** — Testa a escalabilidade da aplicação e monitora o uso dos recursos de hardware
**Funcional** — Não testa a escalabilidade da aplicação e monitora o uso dos recursos de hardware

**Performance** — Projetado para determinar como uma aplicação / sistema irá realizar ao longo do tempo
**Funcional** — Não pode determinar como uma aplicação / sistema irá realizar ao longo do tempo

**Performance** — Requer uma aplicação totalmente funcional para que os cenários sejam executados adequadamente
**Funcional** — Não requer uma aplicação totalmente funcional para que os cenários sejam executados adequadamente




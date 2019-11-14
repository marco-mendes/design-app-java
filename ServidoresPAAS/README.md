## Servidores PAAS(Platform as a Service)

### Introdução
PAAS(Platform as a Service ou Plataforma como Serviço) em computação, consiste no serviço propriamente dito de hospedagem e implementação de hardware e 
software, que é usado para prover aplicações por meio da Internet.

Neste laboratório exploraremos como operar servidores de aplicação em plataformas como serviços nativas de nuvem.

**Iniciativa CNCF**

Durante todo esse laboratório iremos explorar ferramentas da iniciativa CNCF (Cloud Native Computing Foundation), 
que foi desenhada para disseminar o uso de tecnologias de nuvem e também a sua adoção em ambientes locais (*on premises*).

!["Ferramentas da Plataforma CNCF"](https://landscape.cncf.io/images/landscape.png)

**Tecnologias Kubernetes**

Observe que uma tecnologias centrais do CNCF é o Kubernetes. 
O Kubernetes (comumente estilizado como K8s) é um sistema de orquestração de contêiners open-source que automatiza 
a implantação, o dimensionamento e a gestão de aplicações em contêiners.
Ele foi originalmente projetado pelo Google e agora é mantido pela Cloud Native Computing Foundation.
Ele funciona com uma variedade de ferramentas de conteinerização, incluindo o mais popular deles que é o Docker.

A base de operação do Kubernetes é a tecnologia de conteineres, que é representada na figura abaixo.

!["Arquiteturas de Conteineres"](https://d33wubrfki0l68.cloudfront.net/26a177ede4d7b032362289c6fccd448fc4a91174/eb693/images/docs/container_evolution.svg)

A arquitetura base do Kubernetes é mostrada na figura abaixo.

!["Arquitetura do Kubernetes"](http://blog.newrelic.com/wp-content/uploads/kubernetes_architecture.jpg)

Uma boa introdução ao Kubernetes e os conceitos dessa figura é fornecida [aqui](https://medium.com/google-cloud/kubernetes-101-pods-nodes-containers-and-clusters-c1509e409e16)

---

**Exercicio 1**

Para entendermos como Kubernetes opera em nível básico, vamos rodar um tutorial introdutório para implantar uma aplicação nesse ambiente.Para isso, rode esse guia no Katacoda:

[Implantação de GuestBook com o Kubernetes.](https://www.katacoda.com/courses/kubernetes/guestbook)

---

Nesse ponto, vamos avaliar o nosso entendimento inicial do Kubernetes. 
Você consegue explicar para o seu colega o que são os conceitos abaixo?

* Pods
* Nodes
* Clusters
* Services
* Controllers

(Dica: Veja a resposta no apêndice desse exercício)

**Tecnologias de PAAS de Conteineres Kubernetes**

Dentro do CNCF, vamos operar com o conceito de plataformas de serviços que nos permitem operar ambientes Kubernetes.
Exemplos dessas plataformas incluem o RedHat OpenShift ou Rancher.

Como exemplo, a arquitetura lógica do OpenShift é mostrada abaixo:

!["Arquitetura do OpenShift"](https://www.openshift.com/hubfs/images/illustrations/marketure-diagram.svg)

---

**Exercício 2**

Vamos conhecer o OpenShift. Para isso vamos rodar os seguintes tutoriais:

* Introdução ao OpenShift

https://www.katacoda.com/openshift/courses/introduction/getting-started

* Introdução à linguagem OpenShift Do

https://www.katacoda.com/openshift/courses/introduction/developing-with-odo


* Implantação de Imagens Docker com o OpenShift

https://www.katacoda.com/openshift/courses/introduction/deploying-images

---

---

**Exercício 3**

Vamos agora explorar como o OpenShift poderá implantar uma aplicação baseada em JBOSS EAP. O JBoss Enterprise Application Platform é uma plataforma Java EE que inclui suporte completo ao Java EE 8. Usaremos o JBoss EAP 7.2, que é a versão lançada em janeiro de 2019.


Rode agora o tutorial abaixo, que mostra como uma aplicação tradicional que roda com o JBOSS EAP poderia rodar no OpenShift
https://www.katacoda.com/openshift/courses/middleware/middleware-javaee8

---

**Computação Serverless**

Com o advento das plataformas de microsserviços e os PAAS, um estilo arquitetural que emergiu foram de nanosserviços, que são códigos stateless que operam em microconteineres extremamente performático. Por exemplo, iremos rodar microconteineres Java que rodam em menos que 15 milisegundos em consomem apenas 30MB de memória.

Um outro nome para  nanosserviços é computação serverless ou função como serviço (FAAS)

A CNCF mantém um repositório de ferramentas de apoio para esse modelo de computação aqui.

!["Tecnologias Serverless"](https://camo.githubusercontent.com/cf8850bf0659f87f8fe82f0fcdd79f01dbd95880/68747470733a2f2f6c616e6473636170652e636e63662e696f2f696d616765732f7365727665726c6573732e706e67)

**Tecnologia Quarkus**

O Quarkus é uma tecnologia que permite gerar código nativo (.EXE) para aplicações Java para a operação de conteineres performáticos que podem ser escalados com o Docker eo Kubernetes. 

!["Benchmarking de aplicações Quarkus"](https://quarkus.io/assets/images/quarkus_graphics_v3_bootmem_wide_03.png)

Mais informações sobre esse projeto estão aqui.
https://quarkus.io

---
**Exercício 4**

Rode os seguintes tutoriais para compreender como podemos trabalhar com computação Serverless no mundo Java.

Iniciando com o Quarkus

* https://www.katacoda.com/openshift/courses/middleware/middleware-quarkus

Quarkus para Desenvolvedores SpringBoot

* https://www.katacoda.com/openshift/courses/middleware/middleware-quarkus/spring

Aplicações Reativas com o Quarkus e o Kafka

* https://www.katacoda.com/openshift/courses/middleware/middleware-quarkus/kafka

Monitoração de Aplicações com o Quarkus, Grafana e o Prometheus

* https://www.katacoda.com/openshift/courses/middleware/middleware-quarkus/monitoring

---

### APÊNDICE A – Definições Kubernetes
**Nodes**<br/>
Um Node é a menor unidade de hardware de computação do Kubernetes. É uma representação de uma única máquina no seu cluster.<br/>
No exemplo abaixo possuímos uma representação visual de como seriam Nodes no Kubernetes:<br/>
!["Exemplo Nodes no Kubernetes"](https://miro.medium.com/max/3465/1*uyMd-QxYaOk_APwtuScsOg.png)

**Clusters**<br/>
Embora trabalhar com Nodes individuais possa ser útil, não é o caminho do Kubernetes. Em geral, você deve pensar no cluster como um todo, em vez de se preocupar com os estados 
individuais dos Nodes. No Kubernetes, os Nodes agrupam seus recursos para formar uma máquina mais poderosa.<br/>
No exemplo abaixo possuímos uma representação visual de como seria um Cluster no Kubernetes:<br/>
!["Exemplo Cluester no Kubernetes"](https://miro.medium.com/max/3270/1*KoMzLETQeN-c63x7xzSKPw.png)

**Pod**<br/>
Um Pod é a unidade básica de execução de um aplicativo Kubernetes e representa processos em execução no seu Cluster.<br/>
Um Pod representa uma unidade de implantação: uma única instância de um aplicativo no Kubernetes, que pode consistir em um único contêiner ou um pequeno número de contêineres 
fortemente acoplados e que compartilham recursos.<br/>
No exemplo abaixo possuímos uma representação visual de como seria um Pod no Kubernetes:<br/>
!["Exemplo Pod no Kubernetes"](https://miro.medium.com/max/6000/1*8OD0MgDNu3Csq0tGpS8Obg.png)

**Services**<br/>
No Kubernetes, um Service é uma abstração que define um conjunto lógico de Pods e uma política pela qual acessá-los.<br/>
No exemplo abaixo possuímos uma representação visual de como seria um Service no Kubernetes:<br/>
!["Exemplo Service no Kubernetes"](https://linuxacademy.com/site-content/uploads/2019/05/Screen-Shot-2019-04-17-at-10.58.43-AM-1024x769.png?x96242)

**Controllers**<br/>
No Kubernetes, os Controllers são loops de controle que observam o estado do cluster, e faça ou solicite alterações quando necessário. Cada Controller tenta mover o estado 
atual do Cluster para mais perto do estado desejado.<br/>
No exemplo abaixo possuímos uma representação visual de como seria um Controller no Kubernetes:<br/>
!["Exemplo Controller no Kubernetes"](https://miro.medium.com/max/911/1*iI8uFsPRBY5m_g_WW4huMQ.png)

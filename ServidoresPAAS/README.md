O objetivo desse laboratório é explorar como operar servidores de aplicação em plataformas como serviços nativas de nuvem.

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

**Tecnologias de PAAS de Conteineres Kubernetes**

Dentro do CNCF, vamos operar com o conceito de plataformas de serviços que nos permitem operar ambientes Kubernetes.
Exemplos dessas plataformas incluem o RedHat OpenShift ou Rancher.

---

**Exercício 2**

Vamos conhecer o OpenShift. Para isso vamos rodar os seguintes tutoriais:

* Inrodução ao OpenShift
https://www.katacoda.com/openshift/courses/introduction

* Introdução à linguagem OpenShift Do
https://www.katacoda.com/openshift/courses/introduction/developing-with-odo


* Implantação de Imagens Docker com o OpenShift
https://www.katacoda.com/openshift/courses/introduction/deploying-images

---

---

**Exercício 3**

Vamos agora explorar como o OpenShift poderá implantar uma aplicação baseada em JBOSS EAP. O JBoss Enterprise Application Platform é uma plataforma Java EE que inclui suporte completo ao Java EE 8. Usaremos o JBoss EAP 7.2, que é a versão lançada em janeiro de 2019.


Rode o tutorial abaixo, que mostra como uma aplicação tradicional que roda com o JBOSS EAP poderia rodar no OpenShift
https://www.katacoda.com/openshift/courses/middleware/middleware-javaee8


---

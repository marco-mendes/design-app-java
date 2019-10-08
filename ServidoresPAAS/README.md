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

Uma boa introdução ao Kubernetes é fornecida [aqui](https://medium.com/google-cloud/kubernetes-101-pods-nodes-containers-and-clusters-c1509e409e16)

Para entendermos como Kubernetes opera em nível básico, vamos rodar um tutorial introdutório para implantar uma aplicação nesse ambiente.
Para isso, rode esse guia no Katacoda [Implantação de GuestBook com o Kubernetes](https://www.katacoda.com/courses/kubernetes/guestbook)


**Tecnologias de PAAS de Conteineres Kubernetes**

Dentro do CNCF, iremos operar com o conceito de plataformas de serviços que nos permitem operar ambientes Kubernetes.

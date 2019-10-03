Nessa dinâmica iremos rodar uma aplicação de microsserviços com a seguinte arquitetura base.

<img src="https://www.jhipster.tech/images/microservices_architecture_2.png"/>

Iremos usar para isso um acelerador de produtividade chamado JHipster que gera uma aplicação com os módulos acima, sem dependências de códigos proprietários. 

O JHipster tem a sua documentação aqui - https://www.jhipster.tech.

Crie um arquivo chamado apps.jh na linha de comando. Esse arquivo possui comandos de uma DSL para a geração de aplicações Java da ferramenta JHipster. Ele irá gerar uma aplicação com dois Microsservicos: blog e post e um aplicação Web chamada gateway.

```jade
application {
  config {
    baseName gateway,
    packageName com.okta.developer.gateway,
    applicationType gateway,
    authenticationType oauth2,
    prodDatabaseType postgresql,
    searchEngine elasticsearch,
    serviceDiscoveryType eureka,
    testFrameworks [protractor]
  }
  entities Blog, Post, Tag, Product
}
application {
  config {
    baseName blog,
    packageName com.okta.developer.blog,
    applicationType microservice,
    authenticationType oauth2,
    prodDatabaseType postgresql,
    searchEngine elasticsearch,
    serverPort 8081,
    serviceDiscoveryType eureka
  }
  entities Blog, Post, Tag
}
application {
  config {
    baseName store,
    packageName com.okta.developer.store,
    applicationType microservice,
    authenticationType oauth2,
    databaseType mongodb,
    devDatabaseType mongodb,
    prodDatabaseType mongodb,
    enableHibernateCache false,
    searchEngine elasticsearch,
    serverPort 8082,
    serviceDiscoveryType eureka
  }
  entities Product
}
entity Blog {
  name String required minlength(3),
  handle String required minlength(2)
}
entity Post {
  title String required,
  content TextBlob required,
  date Instant required
}
entity Tag {
  name String required minlength(2)
}
entity Product {
  title String required,
  price BigDecimal required min(0),
  image ImageBlob
}
relationship ManyToOne {
  Blog{user(login)} to User,
  Post{blog(name)} to Blog
}
relationship ManyToMany {
  Post{tag(name)} to Tag{post}
}
paginate Post, Tag with infinite-scroll
paginate Product with pagination
microservice Product with store
microservice Blog, Post, Tag with blog
```

A sintaxe detalhada de cada comando é explicada aqui (https://www.jhipster.tech/jdl/).

Para gerar a aplicação rode o seguinte comando no seu shell.

```sh
jhipster import-jdl apps.jh
```

Finalmente, vamos rodar a aplicação. Ela depende de três servidores: Banco de Dados MongoDB, Registry de microsserviços JHipster e também o servidor de autenticação KeyCloak. Vamos rodar esses servidores com o auxílio do Docker Compose com os comandos abaixo a partir da raiz do diretório onde a aplicação foi gerada.

```
docker-compose -f gateway/src/main/docker/jhipster-registry.yml up -d
docker-compose -f gateway/src/main/docker/keycloak.yml up -d
docker-compose -f store/src/main/docker/mongodb.yml up -d
```

Configure o etc/hosts da sua máquina com a seguinte entrada.

```
127.0.0.1       keycloak
```

Para rodar os nossos microsserviços (blog, post) e aplicação Web gateway abra três terminais na linha de comando e rode os seguintes comandos .

```sh
cd ./blog
./mvnw
```

```sh
cd ./store
./mvnw
```

```sh
cd ./gateway
./mvwn
```

Abra seu navegador e acesse http://localhost: 8761. Faça login e você verá uma página de boas-vindas que mostra que o gateway e os dois aplicativos foram registrados.

Depois que tudo estiver em execução, abra um navegador, vá para http://localhost:8080 e clique em entrar. Você deve ser redirecionado para o inquilino do KeyCloack para fazer login e, em seguida, voltar para o gateway depois de inserir credenciais válidas. 

Explore a aplicação e o código fonte.

---

Colocamos aqui recursos adicionais de estudo do JHipster

* Livro do JHipster 5 - https://www.infoq.com/minibooks/jhipster-mini-book-5/
* Material de aprendizagem online - https://www.jhipster.tech
* Trabalho de aprendizagem colaborativo com o Spingular - https://www.spingular.com/#/
* Editor Visual da DSL do JHipster chamado JDL Studio - https://start.jhipster.tech/jdl-studio/
* Plugin para Eclipse - https://www.jhipster.tech/jhipster-ide/
* Guias online do JHipster com a plataforma do Google - https://github.com/jhipster/jhipster-guides




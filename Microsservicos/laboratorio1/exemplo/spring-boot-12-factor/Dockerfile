FROM openjdk:11

# Configurando Timezone para America/Sao_Paulo
RUN cp /usr/share/zoneinfo/America/Sao_Paulo /etc/localtime
RUN dpkg-reconfigure --frontend noninteractive tzdata

# Setando diretorio raiz
WORKDIR /home/binarios

# Copiando binario que sera utilizado para execucao no container
COPY ./target/12factor-0.0.1.jar /home/binarios/12factor-0.0.1.jar

# Comando a ser executado durante a inicializacao da aplicacao
CMD ["sh", "-c", "java -jar ./12factor-0.0.1.jar"]


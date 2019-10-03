docker build --tag=alpine-java:base --rm=true .
docker build --file=Dockerfile.maven --tag=maven:base --rm=true .
docker build --file=Dockerfile.app --tag=spring-data-rest:latest --rm=true .
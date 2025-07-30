FROM eclipse-temurin:21
LABEL maintainer="BKR6"
WORKDIR /SistemaEscolar
COPY SistemaEscolar .
ENTRYPOINT ["java","Main"]
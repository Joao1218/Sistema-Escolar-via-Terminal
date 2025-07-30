FROM eclipse-temurin:21

LABEL maintainer="BRK6"

# Diretório de trabalho para os fontes
WORKDIR /app

# Copia os fontes para o container
COPY SistemaEscolar/src /app/src

# Cria diretório para os arquivos compilados
RUN mkdir -p /app/bin

# Compila todos os arquivos Java
RUN find /app/src -name "*.java" | xargs javac -d /app/bin

# Define diretório onde estão os .class compilados
WORKDIR /app/bin

# Executa a classe Main (verifique o nome do pacote abaixo)
CMD ["java", "Main"]


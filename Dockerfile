FROM maven:3.9.4-openjdk-17-slim

# Installation des dépendances pour Selenium
RUN apt-get update && apt-get install -y \
    wget \
    gnupg \
    unzip \
    curl \
    xvfb \
    && rm -rf /var/lib/apt/lists/*

# Installation de Chrome
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list \
    && apt-get update \
    && apt-get install -y google-chrome-stable \
    && rm -rf /var/lib/apt/lists/*

# Installation de ChromeDriver
RUN CHROMEDRIVER_VERSION=`curl -sS chromedriver.storage.googleapis.com/LATEST_RELEASE` && \
    wget -N http://chromedriver.storage.googleapis.com/$CHROMEDRIVER_VERSION/chromedriver_linux64.zip && \
    unzip chromedriver_linux64.zip && \
    chmod +x chromedriver && \
    mv chromedriver /usr/local/bin/ && \
    rm chromedriver_linux64.zip

# Configuration de l'environnement
ENV DISPLAY=:99
ENV CHROME_BIN=/usr/bin/google-chrome
ENV CHROME_DRIVER=/usr/local/bin/chromedriver

# Script pour démarrer Xvfb
COPY docker-entrypoint.sh /usr/local/bin/
RUN chmod +x /usr/local/bin/docker-entrypoint.sh

# Répertoire de travail
WORKDIR /app

# Copier les fichiers du projet
COPY pom.xml .
COPY src ./src
COPY testng.xml .

# Télécharger les dépendances Maven
RUN mvn dependency:go-offline -B

# Exposer le port pour les rapports
EXPOSE 8080

# Point d'entrée
ENTRYPOINT ["/usr/local/bin/docker-entrypoint.sh"]
CMD ["mvn", "clean", "test"]

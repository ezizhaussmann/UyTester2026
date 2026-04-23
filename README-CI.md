# Configuration CI/CD pour Tests Selenium

Ce document explique comment configurer l'intégration continue pour vos tests Selenium.

## 🚀 Configuration GitHub Actions

### Prérequis
1. Ajouter les secrets dans votre repository GitHub :
   - `SLACK_WEBHOOK` : URL du webhook Slack pour les notifications
   - `EMAIL_USERNAME` : Email pour les notifications
   - `EMAIL_PASSWORD` : Mot de passe de l'email
   - `NOTIFICATION_EMAIL` : Email des destinataires

### Déclencheurs
- **Push** sur les branches `main` et `develop`
- **Pull Request** sur la branche `main`
- **Schedule** : Exécution quotidienne à 2h du matin

### Services
- Selenium Grid avec Chrome, Firefox et Edge
- Cache Maven pour optimiser les builds

## 🔧 Configuration Jenkins

### Prérequis
1. Installer les plugins Jenkins :
   - Pipeline
   - Slack Notification
   - Email Extension
   - HTML Publisher
   - Test Results Analyzer

### Variables d'environnement
- `SELENIUM_HUB_URL` : URL du Selenium Grid
- `EMAIL_RECIPIENTS` : Liste des emails pour notifications

### Étapes du Pipeline
1. **Checkout** : Récupération du code
2. **Setup Environment** : Préparation de l'environnement
3. **Start Selenium Grid** : Démarrage des conteneurs Selenium
4. **Run Tests** : Exécution des tests
5. **Generate Reports** : Génération des rapports
6. **Performance Analysis** : Analyse des performances

## 🐳 Configuration Docker

### Build de l'image
```bash
docker build -t uytester2026/selenium-tests:latest .
```

### Exécution avec Selenium Grid
```bash
# Démarrer Selenium Grid
docker-compose -f docker-compose.selenium.yml up -d

# Exécuter les tests
docker run --network uytester2026clone_selenium-network \
  -e webdriver.remote.url=http://selenium-hub:4444/wd/hub \
  uytester2026/selenium-tests:latest
```

## 📊 Rapports et Notifications

### Types de rapports générés
- **TestNG HTML** : Rapports détaillés des tests
- **Surefire XML** : Rapports au format XML
- **JaCoCo** : Couverture de code
- **Checkstyle** : Qualité du code

### Canaux de notification
- **Slack** : Notifications en temps réel
- **Email** : Rapports détaillés avec logs

### Messages d'alerte
- ✅ **Succès** : Tous les tests passent
- ⚠️ **Instable** : Certains tests échouent
- ❌ **Échec** : Build complet échoue

## 🛠️ Commandes utiles

### Exécution locale
```bash
# Tests standards
mvn clean test

# Tests avec Selenium Grid distant
mvn clean test -Dwebdriver.remote.url=http://localhost:4444/wd/hub

# Tests headless
mvn clean test -Dci.headless=true

# Tests avec timeout personnalisé
mvn clean test -Dci.timeout=600
```

### Rapports
```bash
# Générer les rapports TestNG
mvn surefire-report:report

# Rapport de couverture
mvn jacoco:report

# Rapport de qualité
mvn checkstyle:check
```

## 🔍 Monitoring et Debug

### Logs des tests
- **Console** : Logs en temps réel
- **TestNG Reports** : Logs détaillés par test
- **Selenium Grid** : Logs du navigateur

### Debug en CI
1. **Activer les logs détaillés** :
   ```bash
   mvn clean test -X
   ```

2. **Screenshots en cas d'échec** :
   ```java
   @AfterMethod
   public void captureScreenshot(ITestResult result) {
       if (result.getStatus() == ITestResult.FAILURE) {
           // Capture screenshot
       }
   }
   ```

## 📈 Performance et Optimisation

### Parallélisation
- **Tests en parallèle** : 4 threads par défaut
- **Navigateurs multiples** : Chrome, Firefox, Edge
- **Distribution** : Selenium Grid pour scalabilité

### Optimisations
- **Cache Maven** : Réduction du temps de build
- **Docker layers** : Optimisation des images
- **Timeouts** : Configuration adaptée aux environnements CI

## 🔄 Maintenance

### Mises à jour régulières
- **Dépendances** : Maven, Selenium, TestNG
- **Images Docker** : Sécurité et performance
- **Plugins CI** : Dernières versions et corrections

### Surveillance
- **Temps d'exécution** : Alertes si > 30 minutes
- **Taux de succès** : Monitoring de la stabilité
- **Ressources** : CPU, mémoire, stockage

## 🚨 Dépannage

### Problèmes courants
1. **Timeout Selenium** : Augmenter `ci.timeout`
2. **Échec de connexion** : Vérifier `webdriver.remote.url`
3. **Tests instables** : Ajouter des waits explicites
4. **Mémoire insuffisante** : Augmenter la RAM des conteneurs

### Support
- **Logs Jenkins** : Console output et build logs
- **GitHub Actions** : Actions tab et artifacts
- **Docker** : Container logs et health checks

# Guide d'Installation SafariDriver

## 🍎 Configuration SafariDriver pour macOS

### Prérequis
- macOS 10.11 (El Capitan) ou supérieur
- Safari 10.0 ou supérieur
- Xcode Command Line Tools
- Java 8 ou supérieur

## 📋 Étapes d'Installation

### 1. Installer les Command Line Tools
```bash
xcode-select --install
```

### 2. Activer l'Extension SafariDriver

#### Méthode 1: Via Safari Preferences (Recommandé)
1. Ouvrir Safari
2. Aller dans `Safari > Preferences` (ou `Safari > Settings`)
3. Cliquer sur l'onglet `Advanced`
4. Cocher `Show Develop menu in menu bar`
5. Aller dans `Develop > Allow Remote Automation`

#### Méthode 2: Via Terminal
```bash
# Activer l'extension SafariDriver
safaridriver --enable

# Vérifier le statut
safaridriver --status
```

### 3. Vérifier l'Installation
```bash
# Démarrer SafariDriver
safaridriver --port 4444

# Dans un autre terminal, tester
curl http://localhost:4444/status
```

## 🔧 Configuration dans le Code

### Configuration de Base
```java
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

// Options Safari
SafariOptions options = new SafariOptions();
options.setAutomaticInspection(true);

// Créer le driver
WebDriver driver = new SafariDriver(options);
```

### Configuration Avancée
```java
SafariOptions options = new SafariOptions();

// Activer le mode automatique
options.setAutomaticInspection(true);

// Activer les permissions (si nécessaire)
options.setCapability("safari:diagnose", true);

// Configuration du port
options.setCapability("safari:port", 4444);

WebDriver driver = new SafariDriver(options);
```

## ⚠️ Points Importants

### Limitations de SafariDriver
- **Pas de mode headless** : Safari ne supporte pas l'exécution headless
- **macOS uniquement** : SafariDriver fonctionne uniquement sur macOS
- **Permissions requises** : L'utilisateur doit autoriser l'automatisation
- **Une seule instance** : Impossible de lancer plusieurs instances Safari simultanément

### Sécurité et Permissions
```bash
# Accorder les permissions nécessaires
sudo xattr -r -d com.apple.quarantine /usr/bin/safaridriver

# Vérifier les permissions
ls -la /usr/bin/safaridriver
```

## 🐛 Dépannage

### Problèmes Courants

#### 1. "Could not create a session: SafariDriver requires that a Safari Web Extension be installed"
**Solution:**
```bash
# Réactiver l'extension
safaridriver --enable
```

#### 2. "SafariDriver cannot connect to Safari"
**Solution:**
```bash
# Redémarrer SafariDriver
safaridriver --port 4444 --diagnose
```

#### 3. "Permission denied"
**Solution:**
```bash
# Accorder les permissions système
sudo chmod +x /usr/bin/safaridriver
```

#### 4. Tests qui ne démarrent pas
**Solution:**
1. Vérifier que Safari est fermé
2. Activer "Allow Remote Automation" dans Safari
3. Redémarrer SafariDriver

### Logs et Debug
```bash
# Activer les logs détaillés
safaridriver --port 4444 --diagnose

# Logs dans le code Java
System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
```

## 🔄 Mises à Jour

### Mise à jour SafariDriver
```bash
# SafariDriver est inclus avec Safari
# Mettre à jour Safari met automatiquement à jour SafariDriver
softwareupdate --install Safari
```

### Vérification des Versions
```bash
# Version Safari
safari --version

# Version SafariDriver
safaridriver --version

# Version macOS
sw_vers
```

## 📱 Tests Mobile avec Safari

### Configuration pour iOS Simulator
```java
SafariOptions options = new SafariOptions();
options.setPlatformName("iOS");
options.setDeviceName("iPhone 14");

WebDriver driver = new SafariDriver(options);
```

### Tests Responsive Design
```java
// Redimensionner la fenêtre pour simuler mobile
driver.manage().window().setSize(new Dimension(375, 667));

// Ou via JavaScript
((JavascriptExecutor) driver)
    .executeScript("document.body.style.zoom = '0.8';");
```

## 🎯 Bonnes Pratiques

### 1. Configuration Robuste
```java
@BeforeMethod
public void setUp() {
    SafariOptions options = new SafariOptions();
    options.setAutomaticInspection(true);
    
    try {
        driver = new SafariDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    } catch (Exception e) {
        System.err.println("Erreur initialisation Safari: " + e.getMessage());
        throw e;
    }
}
```

### 2. Cleanup Approprié
```java
@AfterMethod
public void tearDown() {
    if (driver != null) {
        try {
            driver.quit();
        } catch (Exception e) {
            System.err.println("Erreur fermeture Safari: " + e.getMessage());
        }
    }
}
```

### 3. Gestion des Erreurs
```java
@Test
public void testWithRetry() {
    int maxRetries = 3;
    for (int i = 0; i < maxRetries; i++) {
        try {
            // Test logic here
            break;
        } catch (Exception e) {
            if (i == maxRetries - 1) throw e;
            System.out.println("Retry " + (i + 1) + " failed: " + e.getMessage());
        }
    }
}
```

## 📊 Performance

### Optimisations
- Utiliser les waits explicites plutôt qu'implicites
- Éviter les changements de fenêtre fréquents
- Limiter l'utilisation de JavaScript
- Fermer les onglets inutilisés

### Monitoring
```java
// Monitoring de la mémoire
Long memoryUsage = (Long) ((JavascriptExecutor) driver)
    .executeScript("return performance.memory.usedJSHeapSize;");

System.out.println("Mémoire utilisée: " + memoryUsage + " bytes");
```

## 🔗 Ressources Utiles

- [Documentation officielle Selenium](https://www.selenium.dev/documentation/)
- [Apple Developer Documentation](https://developer.apple.com/documentation/safariservices/safari_web_extensions)
- [SafariDriver GitHub](https://github.com/SeleniumHQ/selenium/tree/trunk/java/src/org/openqa/selenium/safari)

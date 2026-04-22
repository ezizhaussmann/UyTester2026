# Tests Selenium pour The Internet

Ce package contient une suite complète de tests Selenium WebDriver pour le site https://the-internet.herokuapp.com/

## Structure du package

```
org.tester.the_internet/
|-- BaseTest.java              # Classe de base avec configuration WebDriver
|-- HomePageTest.java          # Tests pour la page d'accueil
|-- LoginTest.java              # Tests pour la page de connexion
|-- DropdownTest.java          # Tests pour la page dropdown
|-- CheckboxesTest.java        # Tests pour la page checkboxes
|-- TablesTest.java             # Tests pour la page data tables
|-- AlertsTest.java             # Tests pour la page JavaScript alerts
|-- AddRemoveElementsTest.java  # Tests pour la page add/remove elements
|-- testng.xml                 # Fichier de configuration TestNG
|-- README.md                   # Ce fichier
```

## Prérequis

- Java 8 ou supérieur
- Selenium WebDriver
- TestNG
- ChromeDriver (pour Chrome)
- GeckoDriver (pour Firefox)

## Configuration

### Navigateurs supportés

- **Chrome** (par défaut)
- **Firefox** (pour tests cross-browser)

### Configuration des drivers

Assurez-vous que les drivers WebDriver sont dans votre PATH ou configurez-les dans votre code.

## Exécution des tests

### Exécuter tous les tests

```bash
mvn test -DsuiteXmlFile=src/test/java/org/tester/the_internet/testng.xml
```

### Exécuter une classe de test spécifique

```bash
mvn test -Dtest=HomePageTest
```

### Exécuter un test spécifique

```bash
mvn test -Dtest=HomePageTest#testHomePageTitle
```

## Tests disponibles

### HomePageTest
- `testHomePageTitle()` - Vérifie le titre de la page
- `testHomePageHeader()` - Vérifie les headers
- `testNumberOfExamples()` - Compte le nombre d'exemples
- `testSpecificExamplesExist()` - Vérifie des exemples spécifiques
- `testNavigationToExample()` - Teste la navigation
- `testFooterExists()` - Vérifie le footer
- `testPageLayout()` - Vérifie la structure de la page
- `testAllLinksAreClickable()` - Teste tous les liens

### LoginTest
- `testLoginPageTitle()` - Vérifie le titre
- `testLoginFormElementsExist()` - Vérifie les éléments du formulaire
- `testLoginWithValidCredentials()` - Teste connexion valide
- `testLoginWithInvalidUsername()` - Teste username invalide
- `testLoginWithInvalidPassword()` - Teste password invalide
- `testLoginWithEmptyCredentials()` - Teste identifiants vides
- `testLogoutFunctionality()` - Teste la déconnexion
- `testPasswordFieldMasking()` - Vérifie le masquage du password

### DropdownTest
- `testDropdownOptions()` - Vérifie les options du dropdown
- `testSelectOption1()` - Teste sélection option 1
- `testSelectOption2()` - Teste sélection option 2
- `testSelectByValue()` - Teste sélection par valeur
- `testSelectByIndex()` - Teste sélection par index
- `testMultipleSelectionNotSupported()` - Vérifie sélection multiple non supportée
- `testDefaultSelection()` - Vérifie sélection par défaut
- `testChangeSelection()` - Teste changement de sélection

### CheckboxesTest
- `testInitialState()` - Vérifie l'état initial
- `testCheckFirstCheckbox()` - Teste cocher première checkbox
- `testUncheckSecondCheckbox()` - Teste décocher deuxième checkbox
- `testToggleCheckboxes()` - Teste toggle des checkboxes
- `testMultipleClicksOnSameCheckbox()` - Teste multiples clics
- `testCheckboxAttributes()` - Vérifie les attributs
- `testCheckboxesAreClickable()` - Vérifie la cliquabilité

### TablesTest
- `testFirstTableHeaders()` - Vérifie les en-têtes du premier tableau
- `testFirstTableData()` - Vérifie les données du premier tableau
- `testSecondTableData()` - Vérifie les données du deuxième tableau
- `testTableSorting()` - Teste le tri du tableau
- `testTableLinks()` - Vérifie les liens du tableau
- `testDeleteButtons()` - Vérifie les boutons de suppression
- `testEditButtons()` - Vérifie les boutons d'édition
- `testSpecificDataRetrieval()` - Teste récupération de données spécifiques

### AlertsTest
- `testSimpleAlert()` - Teste alert simple
- `testConfirmAlertAccept()` - Teste alert confirmation (accept)
- `testConfirmAlertDismiss()` - Teste alert confirmation (dismiss)
- `testPromptAlertWithInput()` - Teste alert prompt avec entrée
- `testPromptAlertWithoutInput()` - Teste alert prompt sans entrée
- `testPromptAlertDismiss()` - Teste alert prompt (dismiss)
- `testMultipleAlertsSequence()` - Teste séquence d'alertes
- `testAlertHandlingTimeout()` - Teste gestion timeout

### AddRemoveElementsTest
- `testAddSingleElement()` - Teste ajout d'un seul élément
- `testAddMultipleElements()` - Teste ajout de plusieurs éléments
- `testDeleteSingleElement()` - Teste suppression d'un seul élément
- `testDeleteMultipleElements()` - Teste suppression de plusieurs éléments
- `testDeleteSpecificElement()` - Teste suppression d'élément spécifique
- `testAddDeleteSequence()` - Teste séquence add/delete
- `testElementOrder()` - Vérifie l'ordre des éléments
- `testRapidAddDelete()` - Teste add/delete rapide

## Configuration TestNG

Le fichier `testng.xml` permet de configurer :

- **Tests parallèles** : Exécution sur 2 threads
- **Paramètres** : Navigateur (chrome/firefox)
- **Suites de tests** : Groupement logique des tests
- **Tests rapides** : Pour le développement
- **Tests cross-browser** : Validation multi-navigateurs

## Bonnes pratiques

1. **Utilisation de BaseTest** : Tous les tests héritent de BaseTest pour la configuration commune
2. **Gestion des timeouts** : Temps d'attente implicite et explicite
3. **Nettoyage** : Fermeture automatique des navigateurs après chaque test
4. **Logging** : Messages clairs pour le suivi des tests
5. **Assertions** : Vérifications complètes avec messages d'erreur explicites

## Extensibilité

Pour ajouter de nouveaux tests :

1. Créer une nouvelle classe de test héritant de `BaseTest`
2. Implémenter les méthodes de test avec les annotations TestNG
3. Ajouter la nouvelle classe au fichier `testng.xml`
4. Suivre les conventions de nommage et de structure

## Rapports

TestNG génère automatiquement des rapports HTML dans `target/surefire-reports/` après exécution.

## Dépannage

### Problèmes courants

1. **Driver non trouvé** : Vérifiez que ChromeDriver/GeckoDriver est dans le PATH
2. **Timeout** : Ajustez les timeouts dans BaseTest si nécessaire
3. **Éléments non trouvés** : Vérifiez les sélecteurs CSS/XPath
4. **Tests instables** : Ajoutez des attentes explicites si nécessaire

@echo off
echo Génération des rapports de test...

echo.
echo 1. Exécution des tests avec TestNG...
mvn clean compile test-compile

echo.
echo 2. Exécution spécifique de TestNGRunner...
mvn test -Dtest=pageobjectdesignpattern_log.TestNGRunner -DforkCount=1

echo.
echo 3. Vérification des rapports générés...
if exist "test-output\ExtentReport.html" (
    echo ✓ Rapport Extent généré : test-output\ExtentReport.html
) else (
    echo ✗ Rapport Extent non trouvé
)

if exist "target\allure-results" (
    echo ✓ Résultats Allure générés : target\allure-results
    echo   Pour voir le rapport Allure, exécutez : mvn allure:serve
) else (
    echo ✗ Résultats Allure non trouvés
)

echo.
echo Rapports disponibles :
dir /b test-output\*.html 2>nul
echo.
pause
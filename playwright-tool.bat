@echo off
REM ============================================================
REM  playwright-tool.bat
REM  Usage : playwright-tool.bat [URL]
REM  Exemple : playwright-tool.bat https://demoqa.com
REM  Par defaut : https://google.com
REM ============================================================

SET URL=%1

IF "%URL%"=="" (
    SET URL=https://google.com
    echo Aucun argument fourni. URL par defaut : %URL%
) ELSE (
    echo URL fournie : %URL%
)

echo Lancement de Playwright CLI via Maven...
echo.

mvn exec:java ^
    -Dexec.mainClass="com.microsoft.playwright.CLI" ^
    -Dexec.args="codegen %URL%"

IF %ERRORLEVEL% NEQ 0 (
    echo.
    echo ERREUR : Le lancement de Playwright a echoue.
    echo Verifiez que Maven est installe et que la dependance Playwright est dans le pom.xml.
    pause
    exit /b 1
)

echo.
echo Playwright ferme avec succes.
pause

#!/bin/bash

# Démarrer Xvfb pour les tests headless
Xvfb :99 -screen 0 1920x1080x24 > /dev/null 2>&1 &
export DISPLAY=:99

# Attendre que Xvfb soit prêt
sleep 2

# Exécuter la commande passée en argument
exec "$@"

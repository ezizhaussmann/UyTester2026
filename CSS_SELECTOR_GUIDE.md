# Guide Complet des Locators Selenium

---
---

# PARTIE 1 — CSS SELECTOR

## 1. Par Tag
```css
input          /* tous les <input> */
button         /* tous les <button> */
a              /* tous les <a> */
table          /* tous les <table> */
div            /* tous les <div> */
```

---

## 2. Par ID
```css
#username      /* <input id="username"> */
#password      /* <input id="password"> */
#login         /* <button id="login"> */
```

---

## 3. Par Class
```css
.delete                /* <a class="delete"> */
.success               /* <div class="success"> */
.checkbox              /* <img class="checkbox"> */
.checkbox.cbs          /* <img class="checkbox cbs">  — 2 classes */
.fa.fa-trash           /* <i class="fa fa-trash">     — 2 classes */
```

---

## 4. Par Attribut
```css
input[name='username']         /* <input name="username"> */
input[name='password']         /* <input name="password"> */
input[type='checkbox']         /* <input type="checkbox"> */
input[type='submit']           /* <input type="submit"> */
input[name='save']             /* <input name="save"> */

/* Attribut CONTIENT une valeur (*=) */
a[href*='action=delete']       /* href contient 'action=delete' */
a[href*='action=add']          /* href contient 'action=add' */
a[href*='logout']              /* href contient 'logout' */

/* Attribut COMMENCE par une valeur (^=) */
a[href^='https']               /* href commence par 'https' */
input[name^='customer']        /* name commence par 'customer' */

/* Attribut FINIT par une valeur ($=) */
a[href$='.php']                /* href finit par '.php' */
input[name$='email']           /* name finit par 'email' */
```

---

## 5. Parent → Enfant
```css
table tbody tr td              /* td dans table > tbody > tr */
div.success span               /* span dans <div class="success"> */
form input                     /* input dans un form */
ul li a                        /* a dans li dans ul */
```

---

## 6. Enfant Direct ( > )
```css
div > input                    /* input directement dans div (pas imbriqué) */
table > tbody > tr             /* tr directement dans tbody */
```

---

## 7. Combinaisons Tag + Class + Attribut
```css
input[name='save']                         /* <input name="save"> */
a.delete[href*='action=delete']            /* <a class="delete" href="...action=delete..."> */
img.checkbox.cbs[rel='#customer_status']   /* <img class="checkbox cbs" rel="#customer_status"> */
input[type='submit'][value='Login']        /* <input type="submit" value="Login"> */
div.success                                /* <div class="success"> */
```

---

## 8. Nth-child (position dans la liste)
```css
tr:nth-child(1)                /* première ligne du tableau */
tr:nth-child(2)                /* deuxième ligne */
tr:last-child                  /* dernière ligne */
tr:first-child                 /* première ligne */
```

---

## 9. Exemples Réels sur CubeCart
```css
/* Login */
input#username                             /* champ username */
input#password                             /* champ password */
input[id='login']                          /* bouton login */

/* Dashboard */
a[href*='logout']                          /* lien logout */
a[href*='_g=customers']                    /* lien Customer List */

/* Formulaire Add Customer */
input[name='customer[first_name]']         /* champ prénom */
input[name='customer[last_name]']          /* champ nom */
input[name='customer[email]']              /* champ email */
input[name='save']                         /* bouton Save */
img.checkbox.cbs[rel='#customer_status']   /* checkbox status */

/* Liste Customers */
a.delete[href*='action=delete']            /* bouton delete par client */
div.success                                /* message de succès */
table tbody tr                             /* lignes du tableau */
```

---

## 10. Astuce Chrome - Trouver le CSS Selector
```
1. Clic droit sur l'élément  →  Inspecter
2. Dans le HTML, clic droit sur la ligne  →  Copy  →  Copy selector
3. Ou utilise Ctrl+F dans l'onglet Elements pour tester ton selector
```

---
---

# PARTIE 2 — NAME

> Le locator `name` cible les éléments HTML qui ont un attribut `name="..."`.
> C'est très utilisé pour les formulaires : input, select, textarea.

## Comment le trouver ?
```
1. Clic droit sur l'élément  →  Inspecter
2. Cherche l'attribut  name="..."  dans le HTML

   Exemple :
   <input name="username">
   <input name="customer[email]">
   <select name="country">
```

## Syntaxe en Selenium Java
```java
/*
driver.findElement(By.name("username"));
driver.findElement(By.name("password"));
driver.findElement(By.name("customer[email]"));*/

```

## Exemples HTML → Selenium
```
HTML                                          SELENIUM
<input name="username">              →   By.name("username")
<input name="password">              →   By.name("password")
<input name="customer[first_name]">  →   By.name("customer[first_name]")
<input name="customer[email]">       →   By.name("customer[email]")
<select name="country">              →   By.name("country")
<input name="save">                  →   By.name("save")
```

## Quand utiliser name ?
```
✅ Formulaires de login         →  name="username", name="password"
✅ Formulaires d'ajout          →  name="customer[first_name]"
✅ Boutons submit               →  name="save", name="delete"
❌ Liens <a>                    →  les liens n'ont pas de name
❌ Éléments sans attribut name  →  utilise id ou css à la place
```

---
---

# PARTIE 3 — LINK TEXT

> Le locator `linkText` cible les éléments `<a>` (liens) par leur **texte visible exact**.
> `partialLinkText` cible par une **partie** du texte visible.

## Comment le trouver ?
```
1. Clic droit sur le lien  →  Inspecter
2. Regarde le texte entre les balises <a> ... </a>

   Exemple :
   <a href="...">Customer List</a>
   →  linkText = "Customer List"
```

## Syntaxe en Selenium Java
```java
// Texte EXACT
/*
driver.findElement(By.linkText("Customer List"));
driver.findElement(By.linkText("Add Customer"));
driver.findElement(By.linkText("Logout"));

// Texte PARTIEL
driver.findElement(By.partialLinkText("Customer"));
driver.findElement(By.partialLinkText("Log"));*/

```

## Exemples HTML → Selenium
```
HTML                                          SELENIUM
<a href="...">Customer List</a>      →   By.linkText("Customer List")
<a href="...">Add Customer</a>       →   By.linkText("Add Customer")
<a href="...">Logout</a>             →   By.linkText("Logout")
<a href="...">View Orders (25)</a>   →   By.partialLinkText("Orders")
```

## Quand utiliser linkText ?
```
✅ Liens avec texte fixe et connu        →  "Customer List", "Logout"
✅ Menus de navigation                   →  "Dashboard", "Orders"
❌ Liens avec texte dynamique            →  "Order #12345" → utilise partialLinkText
❌ Boutons <button> ou <input>           →  ce n'est pas un <a>, utilise css ou xpath
❌ Liens avec icônes sans texte visible  →  utilise css ou xpath
```

---
---

# PARTIE 4 — XPATH

> XPath est le locator le plus puissant.
> Il permet de naviguer dans toute la structure HTML comme un arbre :
> parents, enfants, frères, suivants, précédents...

## Structure de base
```
//tag[@attribut='valeur']

//   →  cherche partout dans la page
tag  →  le nom de la balise HTML (input, a, div, button...)
@    →  indique un attribut
```

---

## 1. Par attribut
```xpath
//input[@name='username']           ← <input name="username">
//input[@id='password']             ← <input id="password">
//input[@type='submit']             ← <input type="submit">
//a[@class='delete']                ← <a class="delete">
//div[@class='success']             ← <div class="success">
```

---

## 2. Par texte visible — text()
```xpath
//a[text()='Customer List']         ← lien avec texte exact "Customer List"
//button[text()='Login']            ← bouton avec texte "Login"
//td[text()='Anton']                ← cellule avec texte "Anton"
```

---

## 3. contains() — contient une valeur
```xpath
/* Sur le texte */
//a[contains(text(),'Customer')]         ← lien qui contient "Customer"
//div[contains(text(),'success')]        ← div qui contient "success"

/* Sur un attribut */
//a[contains(@href,'action=delete')]     ← href contient "action=delete"
//a[contains(@href,'logout')]            ← href contient "logout"
//div[contains(@class,'success')]        ← class contient "success"
```

---

## 4. starts-with() — commence par
```xpath
//input[starts-with(@name,'customer')]   ← name commence par "customer"
//a[starts-with(@href,'https')]          ← href commence par "https"
```

---

## 5. Parent → Enfant ( / )
```xpath
//table/tbody/tr/td                 ← td dans table > tbody > tr
//form/input[@name='username']      ← input dans un form
//div[@class='success']/span        ← span dans div.success
```

---

## 6. Descendant ( // )
```xpath
//table//input                      ← input n'importe où dans table
//div[@id='content']//a             ← tous les liens dans div#content
```

---

## 7. Position — index
```xpath
//table/tbody/tr[1]                 ← première ligne
//table/tbody/tr[2]                 ← deuxième ligne
//table/tbody/tr[last()]            ← dernière ligne
(//a[@class='delete'])[1]           ← premier lien delete de la page
(//a[@class='delete'])[2]           ← deuxième lien delete
```

---

## 8. FOLLOWING-SIBLING — frère suivant
> Cible un élément qui est au **même niveau** (même parent)
> et qui vient **après** l'élément trouvé.

### Visualisation
```html
<tr>
    <td>Anton</td>           ← élément de départ
    <td>Koshko</td>          ← following-sibling::td[1]
    <td>anton@gmail.com</td> ← following-sibling::td[2]
    <td><a class="delete">   ← following-sibling::td[3]
</tr>
```

### Syntaxe
```xpath
//td[text()='Anton']/following-sibling::td[1]
← trouve "Koshko" (le TD juste après "Anton")

//td[text()='Anton']/following-sibling::td[2]
← trouve "anton@gmail.com" (le 2ème TD après "Anton")

//label[text()='Email']/following-sibling::input
← trouve l'input qui suit le label "Email"

//td[text()='Anton']/following-sibling::td//a[@class='delete']
← trouve le bouton delete sur la ligne du client "Anton"
```

---

## 9. PRECEDING-SIBLING — frère précédent
> Cible un élément qui est au **même niveau** (même parent)
> et qui vient **avant** l'élément trouvé.

### Visualisation
```html
<tr>
    <td>Anton</td>           ← preceding-sibling::td[1] de "Koshko"
    <td>Koshko</td>          ← élément de départ
    <td>anton@gmail.com</td>
</tr>
```

### Syntaxe
```xpath
//td[text()='Koshko']/preceding-sibling::td[1]
← trouve "Anton" (le TD juste avant "Koshko")

//input[@name='save']/preceding-sibling::input[1]
← trouve l'input juste avant le bouton save
```

---

## 10. FOLLOWING — n'importe où après
> Cible **n'importe quel élément** qui vient après dans toute la page,
> peu importe le niveau — pas forcément le même parent.

### Différence avec following-sibling
```
following-sibling  →  même parent uniquement, même niveau
following          →  n'importe où après dans toute la page
```

### Syntaxe
```xpath
//label[text()='Username']/following::input[1]
← trouve le 1er input n'importe où après le label "Username"

//h2[text()='Customer List']/following::table[1]
← trouve le 1er tableau après le titre "Customer List"
```

---

## 11. PRECEDING — n'importe où avant
> Cible **n'importe quel élément** qui vient avant dans toute la page.

```xpath
//input[@name='save']/preceding::input[1]
← trouve le 1er input avant le bouton save

//div[@class='success']/preceding::form[1]
← trouve le formulaire avant le message de succès
```

---

## 12. PARENT — remonter au parent direct
> Remonte d'un seul niveau vers le parent de l'élément trouvé.

```xpath
//input[@name='username']/parent::div
← trouve le div parent de l'input username

//a[@class='delete']/parent::td
← trouve le td qui contient le lien delete
```

---

## 13. ANCESTOR — remonter vers n'importe quel ancêtre
> Remonte vers n'importe quel ancêtre : parent, grand-parent, arrière-grand-parent...

### Différence avec parent
```
parent    →  remonte d'un seul niveau
ancestor  →  remonte autant de niveaux que nécessaire
```

### Syntaxe
```xpath
//input[@name='username']/ancestor::form
← trouve le formulaire qui contient l'input username (peu importe la profondeur)

//a[@class='delete']/ancestor::tr
← trouve la ligne du tableau qui contient le lien delete

//span[text()='Error']/ancestor::div[@class='error-box']
← trouve le div.error-box qui contient le span "Error"
```

---

## 14. Combinaisons avancées
```xpath
/* Trouver le bouton delete sur la ligne du client "Anton" */
//tr[td[text()='Anton']]//a[@class='delete']

/* Trouver l'input email dans un formulaire spécifique */
//form[@id='add-customer']//input[@name='customer[email]']

/* Trouver un élément par 2 attributs (AND) */
//input[@type='text' and @name='username']

/* Trouver un élément par l'un ou l'autre (OR) */
//button[@id='login' or text()='Login']

/* Trouver le 2ème lien delete de la liste */
(//a[@class='delete'])[2]
```

---

## 15. Exemples Réels sur CubeCart en XPath
```xpath
/* Login */
//input[@id='username']
//input[@id='password']
//input[@id='login']

/* Navigation */
//a[text()='Customer List']
//a[contains(@href,'logout')]

/* Formulaire Add Customer */
//input[@name='customer[first_name]']
//input[@name='customer[email]']
//input[@name='save']

/* Trouver la ligne du client "Anton" */
//tr[td[text()='Anton']]

/* Trouver le bouton delete du client "Anton" */
//tr[td[text()='Anton']]//a[@class='delete']

/* Supprimer le premier client de la liste */
(//a[@class='delete'])[1]
```

---

## 16. Comment trouver un XPath dans Chrome
```
Méthode 1 — Automatique :
1. Clic droit sur l'élément  →  Inspecter
2. Clic droit sur la ligne HTML  →  Copy  →  Copy XPath
                                           ou  Copy full XPath

Méthode 2 — Tester dans la Console :
1. Ouvre DevTools  →  onglet Console
2. Tape :  $x("//input[@name='username']")
3. Si trouvé, l'élément s'affiche dans la console

Méthode 3 — Chercher dans Elements :
1. Ouvre DevTools  →  onglet Elements  →  Ctrl+F
2. Tape ton XPath directement
3. Chrome surligne l'élément trouvé en bleu
```

---
---

# RÉSUMÉ — Quand utiliser quoi ?

```
Locator              Quand utiliser
─────────────────────────────────────────────────────────────────────
id                   Toujours en priorité si l'élément a un id unique
name                 Formulaires avec attribut name
linkText             Liens <a> avec texte exact connu
partialLinkText      Liens <a> avec texte partiel ou dynamique
cssSelector          Rapide, lisible — recommandé pour la plupart des cas
xpath                Quand css ne suffit pas, navigation complexe
─────────────────────────────────────────────────────────────────────
following-sibling    Frère après — même parent, même niveau
preceding-sibling    Frère avant — même parent, même niveau
following            N'importe quel élément après dans la page
preceding            N'importe quel élément avant dans la page
parent               Remonter d'un seul niveau vers le parent
ancestor             Remonter vers n'importe quel ancêtre
─────────────────────────────────────────────────────────────────────
```

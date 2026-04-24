package testng_tests;

/**
 * ═══════════════════════════════════════════════════════════════════
 *            GUIDE COMPLET DES LOCATORS SELENIUM
 * ═══════════════════════════════════════════════════════════════════
 *
 * ───────────────────────────────────────────────────────────────────
 * PARTIE 1 — CSS SELECTOR
 * ───────────────────────────────────────────────────────────────────
 *
 * 1. Par TAG
 *    input          →  tous les <input>
 *    button         →  tous les <button>
 *    a              →  tous les <a>
 *    table          →  tous les <table>
 *
 * 2. Par ID
 *    #username      →  <input id="username">
 *    #password      →  <input id="password">
 *    #login         →  <button id="login">
 *
 * 3. Par CLASS
 *    .delete              →  <a class="delete">
 *    .success             →  <div class="success">
 *    .checkbox.cbs        →  <img class="checkbox cbs">  (2 classes)
 *    .fa.fa-trash         →  <i class="fa fa-trash">     (2 classes)
 *
 * 4. Par ATTRIBUT
 *    input[name='username']       →  valeur exacte
 *    a[href*='action=delete']     →  href CONTIENT  'action=delete'
 *    a[href^='https']             →  href COMMENCE  par 'https'
 *    a[href$='.php']              →  href FINIT     par '.php'
 *
 * 5. PARENT → ENFANT
 *    table tbody tr td            →  td dans table > tbody > tr
 *    div.success span             →  span dans <div class="success">
 *
 * 6. ENFANT DIRECT  ( > )
 *    div > input                  →  input directement dans div
 *    table > tbody > tr           →  tr directement dans tbody
 *
 * 7. COMBINAISONS
 *    a.delete[href*='action=delete']           →  class + attribut
 *    img.checkbox.cbs[rel='#customer_status']  →  2 classes + attribut
 *    input[type='submit'][value='Login']        →  2 attributs
 *
 * 8. NTH-CHILD  (position)
 *    tr:nth-child(1)              →  première ligne
 *    tr:nth-child(2)              →  deuxième ligne
 *    tr:last-child                →  dernière ligne
 *    tr:first-child               →  première ligne
 *
 * 9. EXEMPLES REELS CUBECART
 *    input#username                            →  champ username
 *    input#password                            →  champ password
 *    a[href*='logout']                         →  lien logout
 *    input[name='customer[first_name]']        →  champ prénom
 *    input[name='customer[email]']             →  champ email
 *    input[name='save']                        →  bouton Save
 *    img.checkbox.cbs[rel='#customer_status']  →  checkbox status
 *    a.delete[href*='action=delete']           →  bouton delete
 *    div.success                               →  message succès
 *
 * 10. COMMENT TROUVER dans Chrome
 *    1. Clic droit sur l'élément  →  Inspecter
 *    2. Clic droit sur la ligne HTML  →  Copy  →  Copy selector
 *    3. Ctrl+F dans l'onglet Elements pour tester
 *
 * ───────────────────────────────────────────────────────────────────
 * PARTIE 2 — NAME
 * ───────────────────────────────────────────────────────────────────
 *
 * Cible les éléments HTML qui ont un attribut  name="..."
 * Très utilisé pour les formulaires : input, select, textarea
 *
 * COMMENT TROUVER :
 *    Inspecter l'élément  →  cherche  name="..."  dans le HTML
 *    Exemple :  <input name="username">
 *               <input name="customer[email]">
 *
 * SYNTAXE JAVA :
 *    By.name("username")
 *    By.name("password")
 *    By.name("customer[first_name]")
 *    By.name("customer[email]")
 *    By.name("save")
 *
 * EXEMPLES :
 *    <input name="username">              →  By.name("username")
 *    <input name="customer[first_name]">  →  By.name("customer[first_name]")
 *    <input name="save">                  →  By.name("save")
 *
 * QUAND UTILISER :
 *    ✔  Formulaires de login      →  name="username", name="password"
 *    ✔  Formulaires d'ajout       →  name="customer[first_name]"
 *    ✔  Boutons submit            →  name="save"
 *    ✘  Liens <a>                 →  les liens n'ont pas de name
 *
 * ───────────────────────────────────────────────────────────────────
 * PARTIE 3 — LINK TEXT
 * ───────────────────────────────────────────────────────────────────
 *
 * Cible les éléments <a> par leur texte visible.
 * linkText        →  texte EXACT
 * partialLinkText →  texte PARTIEL
 *
 * COMMENT TROUVER :
 *    Inspecter le lien  →  regarde le texte entre <a> ... </a>
 *    Exemple :  <a href="...">Customer List</a>
 *               →  linkText = "Customer List"
 *
 * SYNTAXE JAVA :
 *    By.linkText("Customer List")         →  texte exact
 *    By.linkText("Logout")                →  texte exact
 *    By.partialLinkText("Customer")       →  texte partiel
 *    By.partialLinkText("Log")            →  texte partiel
 *
 * EXEMPLES :
 *    <a href="...">Customer List</a>    →  By.linkText("Customer List")
 *    <a href="...">Add Customer</a>     →  By.linkText("Add Customer")
 *    <a href="...">View Orders (25)</a> →  By.partialLinkText("Orders")
 *
 * QUAND UTILISER :
 *    ✔  Liens avec texte fixe connu      →  "Customer List", "Logout"
 *    ✔  Menus de navigation              →  "Dashboard", "Orders"
 *    ✘  Boutons <button> ou <input>      →  utilise css ou xpath
 *    ✘  Liens avec icônes sans texte     →  utilise css ou xpath
 *
 * ───────────────────────────────────────────────────────────────────
 * PARTIE 4 — XPATH
 * ───────────────────────────────────────────────────────────────────
 *
 * Le locator le plus puissant.
 * Permet de naviguer dans toute la structure HTML comme un arbre.
 *
 * STRUCTURE DE BASE :
 *    //tag[@attribut='valeur']
 *    //   →  cherche partout dans la page
 *    tag  →  nom de la balise HTML
 *    @    →  indique un attribut
 *
 * 1. PAR ATTRIBUT
 *    //input[@name='username']        →  <input name="username">
 *    //input[@id='password']          →  <input id="password">
 *    //a[@class='delete']             →  <a class="delete">
 *
 * 2. PAR TEXTE VISIBLE  text()
 *    //a[text()='Customer List']      →  lien avec texte exact
 *    //button[text()='Login']         →  bouton avec texte "Login"
 *    //td[text()='Anton']             →  cellule avec texte "Anton"
 *
 * 3. contains()  —  CONTIENT une valeur
 *    //a[contains(text(),'Customer')]       →  texte contient "Customer"
 *    //a[contains(@href,'action=delete')]   →  href contient "action=delete"
 *    //div[contains(@class,'success')]      →  class contient "success"
 *
 * 4. starts-with()  —  COMMENCE PAR
 *    //input[starts-with(@name,'customer')] →  name commence par "customer"
 *    //a[starts-with(@href,'https')]        →  href commence par "https"
 *
 * 5. PARENT → ENFANT  ( / )
 *    //table/tbody/tr/td              →  td dans table > tbody > tr
 *    //form/input[@name='username']   →  input dans un form
 *
 * 6. DESCENDANT  ( // )
 *    //table//input                   →  input n'importe où dans table
 *    //div[@id='content']//a          →  tous les liens dans div#content
 *
 * 7. POSITION  (index)
 *    //table/tbody/tr[1]              →  première ligne
 *    //table/tbody/tr[last()]         →  dernière ligne
 *    (//a[@class='delete'])[1]        →  premier lien delete de la page
 *    (//a[@class='delete'])[2]        →  deuxième lien delete
 *
 * ───────────────────────────────────────────────────────────────────
 * 8. FOLLOWING-SIBLING  —  frère SUIVANT (même niveau, même parent)
 * ───────────────────────────────────────────────────────────────────
 *
 * Visualisation :
 *    <tr>
 *        <td>Anton</td>            ← élément de départ
 *        <td>Koshko</td>           ← following-sibling::td[1]
 *        <td>anton@gmail.com</td>  ← following-sibling::td[2]
 *        <td><a class="delete">    ← following-sibling::td[3]
 *    </tr>
 *
 * Syntaxe :
 *    //td[text()='Anton']/following-sibling::td[1]
 *    → trouve "Koshko" (le TD juste après "Anton")
 *
 *    //td[text()='Anton']/following-sibling::td[2]
 *    → trouve "anton@gmail.com" (le 2ème TD après "Anton")
 *
 *    //label[text()='Email']/following-sibling::input
 *    → trouve l'input qui suit le label "Email"
 *
 *    //td[text()='Anton']/following-sibling::td//a[@class='delete']
 *    → trouve le bouton delete sur la ligne du client "Anton"
 *
 * ───────────────────────────────────────────────────────────────────
 * 9. PRECEDING-SIBLING  —  frère PRÉCÉDENT (même niveau, même parent)
 * ───────────────────────────────────────────────────────────────────
 *
 * Visualisation :
 *    <tr>
 *        <td>Anton</td>    ← preceding-sibling::td[1] de "Koshko"
 *        <td>Koshko</td>   ← élément de départ
 *        <td>anton@gmail.com</td>
 *    </tr>
 *
 * Syntaxe :
 *    //td[text()='Koshko']/preceding-sibling::td[1]
 *    → trouve "Anton" (le TD juste avant "Koshko")
 *
 *    //input[@name='save']/preceding-sibling::input[1]
 *    → trouve l'input juste avant le bouton save
 *
 * ───────────────────────────────────────────────────────────────────
 * 10. FOLLOWING  —  n'importe où APRÈS dans la page
 * ───────────────────────────────────────────────────────────────────
 *
 * Différence avec following-sibling :
 *    following-sibling  →  même parent uniquement
 *    following          →  n'importe où après dans toute la page
 *
 * Syntaxe :
 *    //label[text()='Username']/following::input[1]
 *    → trouve le 1er input n'importe où après le label "Username"
 *
 *    //h2[text()='Customer List']/following::table[1]
 *    → trouve le 1er tableau après le titre "Customer List"
 *
 * ───────────────────────────────────────────────────────────────────
 * 11. PRECEDING  —  n'importe où AVANT dans la page
 * ───────────────────────────────────────────────────────────────────
 *
 *    //input[@name='save']/preceding::input[1]
 *    → trouve le 1er input avant le bouton save
 *
 * ───────────────────────────────────────────────────────────────────
 * 12. PARENT  —  remonter au parent DIRECT
 * ───────────────────────────────────────────────────────────────────
 *
 *    //input[@name='username']/parent::div
 *    → trouve le div parent de l'input username
 *
 *    //a[@class='delete']/parent::td
 *    → trouve le td qui contient le lien delete
 *
 * ───────────────────────────────────────────────────────────────────
 * 13. ANCESTOR  —  remonter vers n'importe quel ANCÊTRE
 * ───────────────────────────────────────────────────────────────────
 *
 * Différence avec parent :
 *    parent    →  remonte d'un seul niveau
 *    ancestor  →  remonte autant de niveaux que nécessaire
 *
 * Syntaxe :
 *    //input[@name='username']/ancestor::form
 *    → trouve le formulaire qui contient l'input (peu importe la profondeur)
 *
 *    //a[@class='delete']/ancestor::tr
 *    → trouve la ligne du tableau qui contient le lien delete
 *
 *    //span[text()='Error']/ancestor::div[@class='error-box']
 *    → trouve le div.error-box qui contient le span "Error"
 *
 * ───────────────────────────────────────────────────────────────────
 * 14. COMBINAISONS AVANCÉES
 * ───────────────────────────────────────────────────────────────────
 *
 *    //tr[td[text()='Anton']]//a[@class='delete']
 *    → bouton delete sur la ligne du client "Anton"
 *
 *    //input[@type='text' and @name='username']
 *    → 2 attributs avec AND
 *
 *    //button[@id='login' or text()='Login']
 *    → l'un ou l'autre avec OR
 *
 *    (//a[@class='delete'])[2]
 *    → le 2ème lien delete de la liste
 *
 * ───────────────────────────────────────────────────────────────────
 * 15. EXEMPLES REELS CUBECART EN XPATH
 * ───────────────────────────────────────────────────────────────────
 *
 *    //input[@id='username']                          →  champ username
 *    //input[@id='password']                          →  champ password
 *    //a[text()='Customer List']                      →  lien Customer List
 *    //a[contains(@href,'logout')]                    →  lien logout
 *    //input[@name='customer[first_name]']            →  champ prénom
 *    //input[@name='customer[email]']                 →  champ email
 *    //input[@name='save']                            →  bouton Save
 *    //tr[td[text()='Anton']]                         →  ligne du client Anton
 *    //tr[td[text()='Anton']]//a[@class='delete']     →  delete du client Anton
 *    (//a[@class='delete'])[1]                        →  1er client de la liste
 *
 * ───────────────────────────────────────────────────────────────────
 * 16. COMMENT TROUVER UN XPATH dans Chrome
 * ───────────────────────────────────────────────────────────────────
 *
 *    Méthode 1 — Automatique :
 *       Clic droit  →  Inspecter  →  Clic droit sur HTML  →  Copy XPath
 *
 *    Méthode 2 — Tester dans la Console :
 *       Ouvre Console  →  tape :  $x("//input[@name='username']")
 *       Si trouvé, l'élément s'affiche
 *
 *    Méthode 3 — Chercher dans Elements :
 *       Onglet Elements  →  Ctrl+F  →  tape ton XPath
 *       Chrome surligne l'élément en bleu
 *
 * ═══════════════════════════════════════════════════════════════════
 * RÉSUMÉ — QUAND UTILISER QUOI ?
 * ═══════════════════════════════════════════════════════════════════
 *
 *    id                →  priorité si l'élément a un id unique
 *    name              →  formulaires avec attribut name
 *    linkText          →  liens <a> avec texte exact connu
 *    partialLinkText   →  liens <a> avec texte partiel ou dynamique
 *    cssSelector       →  rapide, lisible — recommandé en général
 *    xpath             →  navigation complexe, parent/enfant
 *    ──────────────────────────────────────────────────────────────
 *    following-sibling →  frère après  (même parent, même niveau)
 *    preceding-sibling →  frère avant  (même parent, même niveau)
 *    following         →  n'importe quel élément après dans la page
 *    preceding         →  n'importe quel élément avant dans la page
 *    parent            →  remonter d'un seul niveau
 *    ancestor          →  remonter vers n'importe quel ancêtre
 *
 * ═══════════════════════════════════════════════════════════════════
 */
public class LocatorGuide {
}

# Simulation_reseau_routier
TP Compléments Objet

Sommaire:
  1) Enoncé 
  2) Conventions utilisées et situation exemple
  
  
  
# 1) Enoncé

Simulation d'un réseau routier

Le but du TP est de réaliser un simulateur de réseau routier (sans chercher de réalisme par rapport à un vrai réseau). Le critère principal d'évaluation - en dehors du respect des normes de programmation en Java (modularité, encapsulation, traitement d'exceptions) - sera la clarté et l'évolutivité de votre conception en termes de hiérarchie de classes.

Eléments du domaine à réaliser:

1. Le réseau routier est constitué des " segments de routes " connectés par des " jonctions ". Un segment de route (toujours à deux voies de circulation, une dans chaque sens) est caractérisé par sa longueur, exprimée dans une certaine unité. Deux segments ne sont jamais reliés directement mais par le biais d'une "jonction " de longueur un. Parmi les jonctions, les "jonctions simples " relient deux segments (par exemple deux segments de route séparés par un passage piéton protégé par des feux) et les " barrières " qui sont des jonctions à un seul segment servant à fermer une route. Les carrefours sont des jonctions plus complexes : un carrefour connecte au moins 3 segments de route. On peut avoir des carrefours en T à 3 routes, ou à 4 au plus. Lorsqu'une voiture arrive à un carrefour, on tire de façon uniforme parmi les autres segments de route celui sur lequel la voiture continuera son trajet. Tout carrefour est supposé être régulé par des feux de circulation (voir ci-dessous).
2. Les voitures sont des éléments circulant sur le réseau. Une voiture a un identifiant et une longueur d'une unité. Elle a une vitesse maximale et un état courant (le segment de route et sa position sur ce segment, son sens de déplacement et sa vitesse courante). Les vitesses sont exprimées en unités de longueur parcourues par unité de temps. La vitesse est constante pendant une unité de temps et peut changer (instantanément !) entre deux unités de temps, par exemple pour ralentir ou s'arrêter à un feu. Une voiture roule au maximum de ses possibilités, selon les indications du réseau.
3. Les sémaphores, parmi lesquels les feux bicolores ou tricolores, ou des panneaux de limitation de vitesse, qui régulent la circulation aux abords des carrefours ou des passages piétons. Un sémaphore est posé à une extrémité de segment de route et orienté vers l'intérieur de ce segment. Il est visible par toute voiture située sur ce segment et allant dans sa direction. Un feu bicolore peut prendre la couleur vert (la voiture qui voit le feu continue à sa vitesse courante) ou rouge (la voiture s'arrête instantanément quand elle arrive au niveau du feu). Quand un feu tricolore prend la couleur orange, la vitesse de la voiture est immédiatement divisée par deux.
4. Les capteurs comprennent notamment les capteurs de présence et les capteurs de vitesse. Un capteur est placé sur un tronçon d'une voie de la route et est associée à un " élément de régulation " et des sémaphores. Un capteur de présence signale le passage d'une voiture pendant l'unité de temps courante et la vitesse de la voiture qui passe dessus.
5. Les "éléments de régulation " : un "élément de régulation " et une fonction qu'on associe à une configuration physique donnée (segments de route, capteurs et sémaphores) pour réguler la circulation aux carrefours ou aux passages piétons. La fonction est activée par un capteur et pourra elle-même activer des sémaphores. Un élement de régulation différent peut être utilisé sur une portion du réseau qui aurait besoin d'un algorithme différent, par exemple pour imposer des priorités entre routes. Par exemple, un carrefour peut être équipé de feux de signalisation qui changent de couleur de façon périodique, indépendamment du trafic routier. Un autre carrefour du même type peut être contrôlé par des feux qui ne changent de couleur que si on détecte un véhicule en attente sur une autre voie. Un dernier exemple est celui qui permettrait qu'un capteur de vitesse détectant une voiture qui va trop vite active un feu rouge. Idem pour un piéton activant un capteur pour un passage piéton.

Ce ne sont que des exemples. Il ne vous est demandé que deux ou trois exemples simples qui montrent la flexibilité de votre simulateur. Votre projet ne sera pas évalué sur la correction ou vraisemblance des algorithmes de régulation.

L'écoulement du temps pendant la simulation est discret (par opposition à "continu"): on ne regarde pas ce qui se passe pendant une unité de temps. A chaque unité de temps, chaque voiture se déplace suivant son état et celui du réseau. L'ordre de traitement des voitures pendant l'unité de temps est arbitraire. A la fin de l'unité de temps , les éléments actionnent les sémaphores en fonction des informations fournies par les capteurs. Votre système doit signaler les risques de collisions: on considère qu'il y a risque de collision si pendant l'unité de temps écoulée, deux voitures sont passées sur un même capteur. On veut aussi être notifié automatiquement si une voiture essaye de franchir une barrière, de passer un feu rouge ou est repérée par un capteur de vitesse.

Travail demandé
Modéliser et programmer les éléments présentés ci-dessus de manière à pouvoir simuler le trajet d'une ou plusieurs voitures sur un réseau routier précédemment construit:
1. Proposer une hiérarchie de classes Java, décrite en UML. On ne fera pas apparaître les classes d'exceptions ou des classes " techniques " (entrées/sorties, comparateurs, etc).
2. L'ensemble des sources de votre programme et du programme de test. Pour faciliter la correction, votre dossier comportera un schéma décrivant le réseau routier simulé.

Les interfaces graphiques sont interdites: consacrez-vous à l'essentiel! Le réseau routier est défini au lancement de l'éxecution et ne peut pas être modifié après coup. Il est construit par programme: il n,est pas lu dans un fichier ou construit interactivement. Il est recommandé de pouvoir construire facilement des portions de réseau sans être obligé de revenir aux éléments de base, par exemple pour construire facilement des carrefours à 3 routes avec tel type de régulation, etc. Vous pouvez ne pas modéliser des configurations de réseaux ou de circulation trop complexes à modéliser (en les signalant dans le dossier remis).

# 2) Conventions utilisées et situation exemple


# Simulation_reseau_routier
TP Compléments Objet

Sommaire:
  1) Enoncé
  2) Conventions utilisées

Simulation d'un réseau routier

Le but du TP est de réaliser un simulateur de réseau routier (sans chercher de réalisme par rapport à un vrai réseau). Le critère principal d'évaluation - en dehors du respect des normes de programmation en Java (modularité, encapsulation, traitement d'exceptions) - sera la clarté et l'évolutivité de votre conception en termes de hiérarchie de classes.

Eléments du domaine à réaliser:

1. Le réseau routier est constitué des " segments de routes " connectés par des " jonctions ". Un segment de route (toujours à deux voies de circulation, une dans chaque sens) est caractérisé par sa longueur, exprimée dans une certaine unité. Deux segments ne sont jamais reliés directement mais par le biais d'une "jonction " de longueur un. Parmi les jonctions, les "jonctions simples " relient deux segments (par exemple deux segments de route séparés par un passage piéton protégé par des feux) et les " barrières " qui sont des jonctions à un seul segment servant à fermer une route. Les carrefours sont des jonctions plus complexes : un carrefour connecte au moins 3 segments de route. On peut avoir des carrefours en T à 3 routes, ou à 4 au plus. Lorsqu'une voiture arrive à un carrefour, on tire de façon uniforme parmi les autres segments de route celui sur lequel la voiture continuera son trajet. Tout carrefour est supposé être régulé par des feux de circulation (voir ci-dessous).
2. Les voitures sont des éléments circulant sur le réseau. Une voiture a un identifiant et une longueur d'une unité. Elle a une vitesse maximale et un état courant (le segment de route et sa position sur ce segment, son sens de déplacement et sa vitesse courante). Les vitesses sont exprimées en unités de longueur parcourues par unité de temps. La vitesse est constante pendant une unité de temps et peut changer (instantanément !) entre deux unités de temps, par exemple pour ralentir ou s'arrêter à un feu. Une voiture roule au maximum de ses possibilités, selon les indications du réseau.
3. Les sémaphores, parmi lesquels les feux bicolores ou tricolores, ou des panneaux de limitation de vitesse, qui régulent la circulation aux abords des carrefours ou des passages piétons. Un sémaphore est posé à une extrémité de segment de route et orienté vers l'intérieur de ce segment. Il est visible par toute voiture située sur ce segment et allant dans sa direction. Un feu bicolore peut prendre la couleur vert (la voiture qui voit le feu continue à sa vitesse courante) ou rouge (la voiture s'arrête instantanément quand elle arrive au niveau du feu). Quand un feu tricolore prend la couleur orange, la vitesse de la voiture est immédiatement divisée par deux.
4. Les capteurs comprennent notamment les capteurs de présence et les capteurs de vitesse. Un capteur est placé sur un tronçon d'une voie de la route et est associée à un " élément de régulation " et des sémaphores. Un capteur de présence signale le passage d'une voiture pendant l'unité de temps courante et la vitesse de la voiture qui passe dessus.
5. Les "éléments de régulation " : un "élément de régulation " et une fonction qu'on associe à une configuration physique donnée (segments de route, capteurs et sémaphores) pour réguler la circulation aux carrefours ou aux passages piétons. La fonction est activée par un capteur et pourra elle-même activer des sémaphores. Un élement de régulation différent peut être utilisé sur une portion du réseau qui aurait besoin d'un algorithme différent, par exemple pour imposer des priorités entre routes. Par exemple, un carrefour !!PAS FINI!!


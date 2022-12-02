package application.roadNetwork;

@FunctionalInterface
public interface RegulateInterface { // Permet aux capteurs de donner les infos aux sémaphores.
    void regulate();
}

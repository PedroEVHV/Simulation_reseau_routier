package application.roadNetwork;

@FunctionalInterface
public interface InteractInterface { // Permet aux sémaphores d'intéragir avec les véhicules.
    void interact(Vehicle vehicle);
}

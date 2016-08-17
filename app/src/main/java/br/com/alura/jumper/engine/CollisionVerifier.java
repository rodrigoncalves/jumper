package br.com.alura.jumper.engine;

import br.com.alura.jumper.elements.Bird;
import br.com.alura.jumper.elements.Tubes;

public class CollisionVerifier {
    private final Bird bird;
    private final Tubes tubes;

    public CollisionVerifier(Bird bird, Tubes tubes) {
        this.bird = bird;
        this.tubes = tubes;
    }

    public boolean hasCollision() {
        return tubes.hasCollisionWith(bird);
    }
}

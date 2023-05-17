import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    @org.junit.jupiter.api.Test
    void find() {

    }

    @org.junit.jupiter.api.Test
    void insert() {
        Tree<Integer, String> arbol = new Tree<>();
        arbol.insert(1,"root",null);
        arbol.insert(2,"izquierdo",1);
        arbol.insert(3,"derecho",1);

        // Verificar que los nodos se insertaron correctamente
        assertEquals("root", arbol.find(1));
        assertEquals("izquierdo", arbol.find(2));
        assertEquals("derecho", arbol.find(3));

    }

    @org.junit.jupiter.api.Test
    void delete() {
    }
}
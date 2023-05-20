import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    @Test
    void find() {
        Tree<Integer, String> arbol = new Tree<>();

        arbol.insert(1,"root",null);
        arbol.insert(2,"izquierdo",1);
        arbol.insert(3,"derecho",1);

        assertEquals("root", arbol.find(1));
        assertEquals("izquierdo", arbol.find(2));
        assertEquals("derecho", arbol.find(3));


    }

    @Test
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

    @Test
    void delete() {
        Tree<Integer, String> arbol = new Tree<>();
        arbol.insert(1,"root",null);
        arbol.insert(2,"izquierdo",1);
        arbol.insert(3,"derecho",1);

        arbol.delete(3);

        assertNull(arbol.find(3));

    }

    @Test
    void size() {
        Tree<Integer, String> arbol = new Tree<>();
        arbol.insert(1,"root",null);
        arbol.insert(2,"izquierdo",1);
        arbol.insert(3,"derecho",1);

        assertEquals(3, arbol.size());

    }

    @Test
    void countLeaf() {
        Tree<Integer, String> arbol = new Tree<>();
        arbol.insert(1,"root",null);
        arbol.insert(2,"izquierdo",1);
        arbol.insert(3,"derecho",1);

        assertEquals(2, arbol.countLeaf());

    }

    @Test
    void countCompleteElements() {
        Tree<Integer, String> arbol = new Tree<>();
        arbol.insert(1,"root",null);
        arbol.insert(2,"izquierdo",1);
        arbol.insert(3,"derecho",1);
        arbol.insert(4,"izquierdo",2);
        arbol.insert(5,"derecho",2);
        arbol.insert(6,"izquierdo",3);
        arbol.insert(7,"derecho",3);

        // Ahora, los nodos 1, 2 y 3 son nodos completos, ya que todos tienen dos hijos.
        // Por lo tanto, debería haber 3 nodos completos en el árbol.
        assertEquals(3, arbol.countCompleteElements());
    }

}
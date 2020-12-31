

public class Trabalenguas {

    public static void main(String args[]) {
        BTree tree;
        try {
            // Se modifico el codigo para que se todo se agregue al subA
            tree = new BTree("Tres");

            BTree subA = new BTree("tristes");
            tree.insert(subA, BTree.LEFT_SIDE);

            BTree temp = new BTree("tigres");
            subA.insert(temp, BTree.LEFT_SIDE); //Cambio de direccion

            //BTree temporal = new BTree("tigres");
            //tree.insert(temporal, BTree.RIGHT_SIDE);

            temp = new BTree("comian");
            subA.insert(temp, BTree.RIGHT_SIDE);//Cambio de direccion

            //INCORRRECTO
            //temporal = new BTree("trigo");
            //subarbol.insert(temporal, BTree.RIGHT_SIDE);

            //Creacion del subarbol derecho y se añaden los nodos que hacian falta
            BTree subA2 = new BTree("trigo");
            tree.insert(subA2, BTree.RIGHT_SIDE);

            BTree temp2 = new BTree("en un");
            subA2.insert(temp2, BTree.LEFT_SIDE);

            temp2 = new BTree("trigal");
            subA2.insert(temp2, BTree.RIGHT_SIDE);

            /*
            * Faltan dos nodos
            * nodo -> En un
            * nodo -> trigal
             */


        } catch (BTreeException ex) {
            System.out.println(ex.getMessage());
            return;
        }


        System.out.println("RECORRIDO PREORDEN ------------------");
        tree.preorder();
        System.out.println("RECORRIDO ENORDEN ------------------");
        tree.inorder();
        System.out.println(" RECORRIDO POSTORDEN------------------");
        tree.postorder();


        //este codigo obtiene los nodos del arbol
        System.out.println("------------------");
        System.out.println((new StringBuilder())
                .append("Nodos Arbol Binario = ").append(tree.size()).toString());
        System.out.println("------------------");

        //Este codigo obtiene el tamaño de la altura del arbol
        System.out.println("------------------");
        System.out.println((new StringBuilder())
                .append("altura Arbol Binario = ").append(tree.height()).toString());
        System.out.println("------------------");
    }
}


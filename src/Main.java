
public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        ArvoreBinariaBusca aBB = new ArvoreBinariaBusca();
        aBB.inserir(5);
        aBB.inserir(3);
        aBB.inserir(4);
        aBB.inserir(1);
        aBB.inserir(2);
        aBB.inserir(8);
        aBB.inserir(9);
        aBB.inserir(7);
        aBB.inserir(6);
        System.out.println("Fazendo impressões...");
        aBB.imprimirEmOrdem();
        aBB.imprimirPreOrdem();
        aBB.imprimirPosOrdem();
        System.out.println("\nBuscando o valor 5...");
        System.out.println(aBB.buscar(5));
        System.out.println("\nA altura da árvore é: " + aBB.altura());
        System.out.println("O número total de nós da árvore é: " + aBB.contarNos());
        System.out.println("O número total de nós folha da árvore é: " + aBB.contarFolhas());

        System.out.println("A profundidade do valor 9 é: " + aBB.profundidade(9));

        System.out.println("\nBuscando outro elemento...");
        if (aBB.buscar(100)) {
            System.out.println("Valor encontrado");
        } else {
            System.out.println("Número não existe na árvore.");
        }

        System.out.println("\nRemovendo o valor 1...");
        aBB.remover(1);
        aBB.imprimirEmOrdem();
    }
}
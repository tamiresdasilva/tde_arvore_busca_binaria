public class ArvoreBinariaBusca {
    private No raiz = null;

    public ArvoreBinariaBusca() {
    }

    public void inserir(int valor) {
        this.raiz = this.inserirRec(this.raiz, valor);
    }

    private No inserirRec(No raiz, int valor) {
        if (raiz == null) {
            raiz = new No(valor);
            return raiz;
        } else {
            if (valor < raiz.valor) {
                raiz.esquerda = this.inserirRec(raiz.esquerda, valor);
            } else if (valor > raiz.valor) {
                raiz.direita = this.inserirRec(raiz.direita, valor);
            }

            return raiz;
        }
    }

    public void remover(int valor) {
        this.raiz = this.removerRec(this.raiz, valor);
    }

    private No buscarMenor(No raiz) {
        while(raiz.esquerda != null) {
            raiz = raiz.esquerda;
        }

        return raiz;
    }

    private No removerRec(No raiz, int valor) {
        if (raiz == null) {
            return raiz;
        } else {
            if (valor < raiz.valor) {
                raiz.esquerda = this.removerRec(raiz.esquerda, valor);
            } else if (valor > raiz.valor) {
                raiz.direita = this.removerRec(raiz.direita, valor);
            } else {
                if (raiz.esquerda == null && raiz.direita == null) {
                    return null;
                }

                if (raiz.esquerda == null) {
                    return raiz.direita;
                }

                if (raiz.direita == null) {
                    return raiz.esquerda;
                }

                No sucessor = this.buscarMenor(raiz.direita);
                raiz.valor = sucessor.valor;
                raiz.direita = this.removerRec(raiz.direita, sucessor.valor);
            }

            return raiz;
        }
    }

    public boolean buscar(int valor) {
        return this.buscarRecursivo(this.raiz, valor);
    }

    private boolean buscarRecursivo(No no, int valor) {
        if (no == null) {
            return false;
        } else if (valor == no.valor) {
            return true;
        } else {
            return valor < no.valor ? this.buscarRecursivo(no.esquerda, valor) : this.buscarRecursivo(no.direita, valor);
        }
    }

    public void imprimirEmOrdem() {
        System.out.print("Em ordem: ");
        this.imprimirEmOrdemRecursivo(this.raiz);
        System.out.println();
    }

    private void imprimirEmOrdemRecursivo(No no) {
        if (no != null) {
            this.imprimirEmOrdemRecursivo(no.esquerda);
            System.out.print(no.valor + " ");
            this.imprimirEmOrdemRecursivo(no.direita);
        }

    }

    public void imprimirPreOrdem() {
        System.out.print("Pré-ordem: ");
        this.imprimirPreOrdemRecursivo(this.raiz);
        System.out.println();
    }

    private void imprimirPreOrdemRecursivo(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            this.imprimirPreOrdemRecursivo(no.esquerda);
            this.imprimirPreOrdemRecursivo(no.direita);
        }

    }

    public void imprimirPosOrdem() {
        System.out.print("Pós-ordem: ");
        this.imprimirPosOrdemRecursivo(this.raiz);
        System.out.println();
    }

    private void imprimirPosOrdemRecursivo(No no) {
        if (no != null) {
            this.imprimirPosOrdemRecursivo(no.esquerda);
            this.imprimirPosOrdemRecursivo(no.direita);
            System.out.print(no.valor + " ");
        }

    }

    private int alturaRecursiva(No no){
        if (no == null){
            return -1;
        }
        int alturaEsquerda = alturaRecursiva(no.esquerda);
        int alturaDireita = alturaRecursiva(no.direita);
        return Math.max(alturaEsquerda, alturaDireita) + 1;
    }

    public int altura() {
        return alturaRecursiva(this.raiz);
    }

    private int contarNosRecursivo(No no){
        if (no == null){
            return 0;
        }
        return 1 + contarNosRecursivo(no.esquerda) + contarNosRecursivo(no.direita);
    }

    public int contarNos() {
        return contarNosRecursivo(this.raiz);
    }

    private int contarFolhasRecursivo(No no){
        if (no == null){
            return 0;
        }
        if (no.esquerda == null && no.direita == null){
            return 1;
        }
        return contarFolhasRecursivo(no.esquerda) + contarFolhasRecursivo(no.direita);
    }

    public int contarFolhas(){
        return contarFolhasRecursivo(this.raiz);
    }

    private int profundidadeNoRecursiva(No no, int valor, int profundidade){
        if (no == null){
            return -1;
        }
        if (no.valor == valor){
            return profundidade;
        }else if ( valor < no.valor){
            return profundidadeNoRecursiva(no.esquerda, valor, profundidade + 1);
        } else {
            return profundidadeNoRecursiva(no.direita, valor, profundidade + 1);
        }
    }

    public int profundidade(int valor){
        return profundidadeNoRecursiva(this.raiz, valor, 0);
    }
}

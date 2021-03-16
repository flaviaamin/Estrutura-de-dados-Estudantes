package ed.lista;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import modelo.Estudante;

public class ListaDupla<K, V> implements Map<Integer, Estudante> {

    private NoDuplo inicio;
    private NoDuplo fim;
    private int tamanho = 0;

    public ListaDupla() {
        inicio = null;
        fim = null;
    }

    /**
     * Exibição dos estudantes em ordem crescente de número de matricula
     */
      public void imprimirLista() {
        NoDuplo aux = inicio;
        System.out.println("Lista ordenada: ");
        while (aux != null) {
            System.out.println(aux.getEstudante().toString());
            aux = aux.getProx();
        }
    }

      /**
       * Pesquisa pelos estudantes do curso Engenharia de Software
       * @return 
       */
    public int pesquisaES() {
        NoDuplo aux = inicio;
        int contES = 0;
        while (aux != null) {
            if (aux.getEstudante().getCurso().compareTo("Engenharia de Software") == 0) {
                contES++;
            }
            aux = aux.getProx();
        }
        return contES;
    }
/**
 * Remove estudantes com número de matrícula igual ou inferior ao número
de matrícula 202050000
 * @return 
 */
    public int remove202050000() {
        NoDuplo aux = inicio;
        int contInferior = 0;
        while (aux != null) {
            if (aux.getEstudante().getMatricula() <= 202050000) {
                remove(aux.getEstudante().getMatricula());
                contInferior++;
            }
            aux = aux.getProx();
        }
        return contInferior;

    }

    /**
     * Inserção dos estudantes
     * @param key
     * @param estudante
     * @return 
     */
    @Override
    public Estudante put(Integer key, Estudante estudante) {
        
        NoDuplo novo = new NoDuplo(estudante); // criar um nó a partir de um estudante
        
        NoDuplo ondeInserir = noDeInsersao(novo); // descobrir 
        if (inicio == null) { // esta vazia, 
            inicio = novo;
            fim = novo;
            System.out.println("comecei");
        } else {
            if (ondeInserir == null) {
                inicio.setAnt(novo);
                novo.setProx(inicio);
                inicio = novo;
            } else {
                novo.setProx(ondeInserir.getProx());
                novo.setAnt(ondeInserir);
                if (ondeInserir.getProx() != null) {
                    ondeInserir.getProx().setAnt(novo);
                }

                ondeInserir.setProx(novo);
                if (ondeInserir == fim) {
                    fim = novo;
                }
            }

        }
        tamanho++;

        return novo.getEstudante();

    }

   
    
     /**
     * Recebe o estudante e retorna o no que o contem
     * @param estudante
     * @return 
     */
    private NoDuplo pesquisa(Estudante estudante) {
        NoDuplo aux = inicio;
        while (aux != null) {
            if (aux.getEstudante() == estudante) {
                return aux;
            }
            aux = aux.getProx();
        }
        return null;
    }

    /**
     * Recebe o estudante e retorna o no que o contem
     * @param estudante
     * @return 
     */
    public NoDuplo pesquisa(int  matricula) {
        NoDuplo aux = inicio;
        while (aux != null) {
            if (aux.getEstudante().getMatricula() == matricula) {
                return aux;
            }
            aux = aux.getProx();
        }
        return null;
    }

     
    /**
     * Descobre onde será inserido em ordem crescente
     * @param novo
     * @return no para ligar ao novo
     */
    private NoDuplo noDeInsersao(NoDuplo novo) {
        NoDuplo aux = inicio;
        boolean encontrou = false;
        while (aux != null && encontrou == false) {
            if (aux.getEstudante().compareTo(novo.getEstudante()) == 1) { // tem uma matricula maior do que o novo
                encontrou = true;
            } else {
                aux = aux.getProx();
            }

        }
        if (!encontrou) { //nao encontrou matricula maior antes
            return fim;// inserir no final

        } else {
            return aux.getAnt(); //se encontrou, insere antes 
        }
    }

    @Override
    public int size() {
        return this.tamanho;
    }

    /**
     * Identifica se uma matricula esta contida na lista
     * @param key
     * @return 
     */
    @Override
    public boolean containsKey(Object key) {
        NoDuplo aux = inicio;
        while (aux != null) {
            if (aux.getEstudante().getMatricula() == (Integer) key) {
                return true;
            }
            aux = aux.getProx();
        }
        return false;
    }

    /**
     * Verifica se o estudante esta lista
     * @param value
     * @return 
     */
    @Override
    public boolean containsValue(Object value) {
        NoDuplo aux = inicio;
        while (aux != null) {
            if (aux.getEstudante() == value) {
                return true;
            }
            aux = aux.getProx();
        }
        return false;
    }

    
    
    /**
     * Recebe o valor e retorna o estudante cadastrado na lista
     * @param key
     * @return 
     */
    @Override
    public Estudante get(Object key) {
        
        
        
        NoDuplo aux = inicio;
        while (aux != null) {
            if (aux.getEstudante().getMatricula() == (Integer) key) {
                return aux.getEstudante();
            }
            aux = aux.getProx();
        }
        return null;
        
              
    }

   

    /**
     * Limpa toda a lista, do inicio até o fim
     */
    @Override
    public void clear() {
        NoDuplo aux = inicio;
        while (aux != null) {
            remove(aux);
            aux = aux.getProx();
        }
    }

    /**
     * Metodo que serve para retornar todas as chaves (matriculas) contidas na
     * lista
     *
     * @return um conjunto de chaves
     */
    @Override
    public Set<Integer> keySet() {
        Set<Integer> chaves = new HashSet<>();
        NoDuplo aux = inicio;
        while (aux != null) {
            chaves.add(aux.getEstudante().getMatricula());
            aux = aux.getProx();
        }

        return chaves;
    }

    /**
     * Retorna uma coleção com todos os estudantes da lista
     *
     * @return
     */
    @Override
    public Collection<Estudante> values() {

        Collection<Estudante> estudantes = new ArrayList<>();
        NoDuplo aux = inicio;
        while (aux != null) {
            estudantes.add(aux.getEstudante());
            aux = aux.getProx();
        }
        return estudantes;
    }

   

    /**
     *Recebe a chave e remove 
     * @param key
     * @return retorna o estudante que foi removido
     */
    @Override
    public Estudante remove(Object key) {
        NoDuplo aux = pesquisa((Integer) key); // busca na lista com a chave e armazena em aux
        if (aux != null) { // se o no existir
            if (aux == inicio && aux == fim) { //unico no da lista
                inicio = null;
                fim = null;
            } else if (aux == inicio) { //primeiro no da lista
                inicio.getProx().setAnt(null);
                inicio = inicio.getProx();
            } else if (aux == fim) { // utimo da lista
                fim.getAnt().setProx(null);
                fim = fim.getAnt();
            } else {// no meio da lista
                aux.getAnt().setProx(aux.getProx());
                aux.getProx().setAnt(aux.getAnt());
            }
            return aux.getEstudante();
        }
        return null;
    }
    
    
     @Override
    public Set<Entry<Integer, Estudante>> entrySet() {
        return null;
    }
    
     @Override
    public void putAll(Map<? extends Integer, ? extends Estudante> m) {

    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}

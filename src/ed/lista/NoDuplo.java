package ed.lista;

import modelo.Estudante;

public class NoDuplo{
	private Estudante estudante;
	private NoDuplo prox;
	private NoDuplo ant;
	
	public NoDuplo(Estudante info){
		this.estudante = info;
		ant = null;
		prox = null;
	}
	
	
	public void setProx(NoDuplo n){prox = n;}
	public void setAnt(NoDuplo n){ant = n;}
	public void setEstudante(Estudante i) {estudante = i;}
	public NoDuplo getProx() {return prox;}
	public NoDuplo getAnt(){return ant;}
	public Estudante getEstudante(){return estudante;}
	
}
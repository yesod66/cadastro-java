package br.com.cadastrosistemas.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.cadastrosistemas.dao.SistemaDaoImpl;
import br.com.cadastrosistemas.modelo.Sistema;
import br.com.cadastrosistemas.util.Filtro;

@ManagedBean
@ViewScoped
public class PesquisaSistemaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	SistemaDaoImpl dao = new SistemaDaoImpl();
	private Filtro filtro;
	private boolean showTable = false;
	private List<Sistema> sistemaFiltrado;
	
	public PesquisaSistemaBean() {
		filtro = new Filtro();
	}
	
	
	public void inicializar() {
		
		sistemaFiltrado = dao.filtrados(this.filtro);
		
		
	}

	public void pesquisar() {
		sistemaFiltrado = dao.filtrados(filtro);
		showTable = true;
	}

	public void limpar() {
		sistemaFiltrado = null;
	}
	
	public Filtro getFiltro() {
		return filtro;
	}

	public void setFiltro(Filtro filtro) {
		this.filtro = filtro;
	}

	public List<Sistema> getSistemaFiltrado() {
		return sistemaFiltrado;
	}

	public void setSistemaFiltrado(List<Sistema> sistemaFiltrado) {
		this.sistemaFiltrado = sistemaFiltrado;
	}


	public boolean isShowTable() {
		return showTable;
	}


	public void setShowTable(boolean showTable) {
		this.showTable = showTable;
	}


	
	
}

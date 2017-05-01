package br.com.cadastrosistemas.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.cadastrosistemas.dao.SistemaDaoImpl;
import br.com.cadastrosistemas.modelo.Sistema;

@ManagedBean
@ViewScoped
public class CadastroSistemaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Sistema sistema;
	SistemaDaoImpl dao = new SistemaDaoImpl();
	
	public CadastroSistemaBean() {
		sistema = new Sistema();
	}
	
	public void salvar() {
		dao.salvar(this.sistema);
		sistema = new Sistema();
		System.out.println("clicou");
		
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	
	

}

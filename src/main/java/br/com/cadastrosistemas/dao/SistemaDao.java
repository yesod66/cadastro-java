package br.com.cadastrosistemas.dao;

import java.util.List;

import br.com.cadastrosistemas.modelo.Sistema;

public interface SistemaDao {

	public Sistema salvar(Sistema sistema);
	public void alterar(Sistema sistema);
	public void excluir(Sistema sistema);
	public Sistema porId(Long id);
	public List<Sistema> listarTodos(Sistema sistema);
	
}

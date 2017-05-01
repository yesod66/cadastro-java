package br.com.cadastrosistemas.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.cadastrosistemas.enume.Status;

@Entity
@Table(name = "sistema")
public class Sistema implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricao;
	private String sigla;
	private String email;
	private String url;
	private Status status = Status.ATIVO;
	private String responsavelUltimaAlteracao;
	private Date dataUltimaAlteracao;
	private String justificativaUltimaAlteracao;
	private String justificativaNova;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	@Column(length = 100)
	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	@Column(length = 10)
	public String getSigla() {
		return sigla;
	}


	public void setSigla(String sigla) {
		this.sigla = sigla;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}

	@Enumerated(EnumType.STRING)
	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}

	@Column(name = "responsavel_ultima_alteracao")
	public String getResponsavelUltimaAlteracao() {
		return responsavelUltimaAlteracao;
	}


	public void setResponsavelUltimaAlteracao(String responsavelUltimaAlteracao) {
		this.responsavelUltimaAlteracao = responsavelUltimaAlteracao;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_ultima_alteracao")
	public Date getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}


	public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	@Column(columnDefinition = "text")
	public String getJustificativaUltimaAlteracao() {
		return justificativaUltimaAlteracao;
	}


	public void setJustificativaUltimaAlteracao(String justificativaUltimaAlteracao) {
		this.justificativaUltimaAlteracao = justificativaUltimaAlteracao;
	}

	@Column(columnDefinition = "text")
	public String getJustificativaNova() {
		return justificativaNova;
	}


	public void setJustificativaNova(String justificativaNova) {
		this.justificativaNova = justificativaNova;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sistema other = (Sistema) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}

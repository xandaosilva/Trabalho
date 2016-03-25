package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer codigo;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="porcentagemDoCurso")
	private Double porcentagemDoCurso;
	
	@Column(name="porcentagemPorAtividade")
	private Double porcentagemPorAtividade;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="regulamento")
	private String regulamento;
	
	@ManyToOne
	@JoinColumn(name="modalidade",referencedColumnName="codigo")
	private Modalidade modalidade;

	public Categoria() {
	}

	public Categoria(Integer codigo, String nome, Double porcentagemDoCurso, 
			Double porcentagemPorAtividade,String descricao, 
			String regulamento, Modalidade modalidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.porcentagemDoCurso = porcentagemDoCurso;
		this.porcentagemPorAtividade = porcentagemPorAtividade;
		this.descricao = descricao;
		this.regulamento = regulamento;
		this.modalidade = modalidade;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPorcentagemDoCurso() {
		return porcentagemDoCurso;
	}

	public void setPorcentagemDoCurso(Double porcentagemDoCurso) {
		this.porcentagemDoCurso = porcentagemDoCurso;
	}

	public Double getPorcentagemPorAtividade() {
		return porcentagemPorAtividade;
	}

	public void setPorcentagemPorAtividade(Double porcentagemPorAtividade) {
		this.porcentagemPorAtividade = porcentagemPorAtividade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getRegulamento() {
		return regulamento;
	}

	public void setRegulamento(String regulamento) {
		this.regulamento = regulamento;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Categoria other = (Categoria) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}	
}
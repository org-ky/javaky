package com.orgky.examples.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Iva")
public class Iva {

	@Id
	@Column(name="idIva")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIva;
	
	private String descrizione;
	
	private String aliquota;

	public int getIdIva() {
		return idIva;
	}

	public void setIdIva(int idIva) {
		this.idIva = idIva;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getAliquota() {
		return aliquota;
	}

	public void setAliquota(String aliquota) {
		this.aliquota = aliquota;
	}
	
	@Override
	public String toString(){
		return "idIva="+idIva+", descrizione="+descrizione+", aliquota="+aliquota;
	}
}

package com.orgky.examples.service;

import java.util.List;

import com.orgky.examples.model.Iva;

public interface IvaService {

	public void addIva(Iva p);
	public void updateIva(Iva p);
	public List<Iva> listIvas();
	public Iva getIvaById(int id);
	public void removeIva(int id);
}

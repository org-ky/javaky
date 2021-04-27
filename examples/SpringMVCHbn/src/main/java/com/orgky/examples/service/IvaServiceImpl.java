package com.orgky.examples.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.orgky.examples.dao.IvaDAO;
import com.orgky.examples.model.Iva;

public class IvaServiceImpl implements IvaService{
	
	private IvaDAO ivaDAO;

	public void setIvaDAO(IvaDAO ivaDAO) {
		this.ivaDAO = ivaDAO;
	}

	@Override
	@Transactional
	public void addIva(Iva p) {
		this.ivaDAO.addIva(p);
	}

	@Override
	@Transactional
	public void updateIva(Iva p) {
		this.ivaDAO.updateIva(p);
	}

	@Override
	@Transactional
	public List<Iva> listIvas() {
		return this.ivaDAO.listIvas();
	}

	@Override
	@Transactional
	public Iva getIvaById(int id) {
		return this.ivaDAO.getIvaById(id);
	}

	@Override
	@Transactional
	public void removeIva(int id) {
		this.ivaDAO.removeIva(id);
	}

}

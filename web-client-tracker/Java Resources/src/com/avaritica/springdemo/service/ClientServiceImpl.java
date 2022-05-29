package com.avaritica.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaritica.springdemo.dao.ClientDAO;
import com.avaritica.springdemo.entity.Client;

//add service annotation to enable component scaning and implement service function
@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientDAO clientDAO;
	
	@Transactional
	public List<Client> getClients() {		
		return clientDAO.getClients();
	}

	@Override
	@Transactional
	public void saveClient(Client client) {
		clientDAO.saveClient(client);
		
	}

	@Override
	@Transactional
	public Client getClients(int id) {
		return clientDAO.getClients(id);
	}

	@Override
	@Transactional
	public void deleteClient(int id) {
		clientDAO.deleteClient(id);
		
	}

	@Override
	@Transactional
	public List<Client> searchClients(String clientName) {
		return clientDAO.searchClients(clientName);
	}
}

package com.avaritica.springdemo.service;

import java.util.List;

import com.avaritica.springdemo.entity.Client;

public interface ClientService {

		public List<Client> getClients();
		
		public void saveClient(Client client);

		public Client getClients(int id);

		public void deleteClient(int id);

		public List<Client> searchClients(String clientName);
		
			
}

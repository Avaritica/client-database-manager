package com.avaritica.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avaritica.springdemo.entity.Client;


//add repository annotation to component scan+DAO implementation specific functions
@Repository
public class ClientDAOImpl implements ClientDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	//add transactional annotation to simplify transaction
	@Override
	public List<Client> getClients() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query....sort by last name
		Query<Client> query = currentSession.createQuery("from client order by lastName",Client.class);
		
		//execute the query to get the result
		List<Client> clients = query.getResultList();
		
		//return the retrieved data
		return clients;
	}

	@Override
	public void saveClient(Client client) {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save/update the client
		currentSession.saveOrUpdate(client);		
	}

	@Override
	public Client getClients(int id) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//retrieve the object from the database using the id as primary key
		Client client = currentSession.get(Client.class, id);
		
		//return the retrieved data
		return client;
	}

	@Override
	public void deleteClient(int id) {
		//get the current session from factory
		Session session = sessionFactory.getCurrentSession();
	
		//retrieve the object from the database
		Client client = session.get(Client.class, id);
		
		//delete the object from the database using id
		session.delete(client);
		
	}

	@Override
	public List<Client> searchClients(String clientName) {
		//get the current session from factory
		Session session = sessionFactory.getCurrentSession();
		
		Query<Client> query = null;
		
		//perform the search only if the given 'clientName' is not empty
		if(clientName!=null && clientName.isBlank()==false) {
			//search for firstName or lastName...case insensitive
			query = session.createQuery
					("from client where lower(firstName) like :theName or lower(lastName) like :theName",Client.class);
			query.setParameter("theName", "%"+clientName.toLowerCase()+"%");			
		} else {
			//given 'clientName' is empty so return all clients
			query = session.createQuery("from client",Client.class);
		}
		
		//execute the query and get result list.
		List<Client> clients = query.getResultList();
		return clients;
	}
}

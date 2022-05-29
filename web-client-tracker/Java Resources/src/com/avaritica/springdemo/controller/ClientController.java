package com.avaritica.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.avaritica.springdemo.dao.ClientDAO;
import com.avaritica.springdemo.entity.Client;
import com.avaritica.springdemo.service.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	//need to inject the DAO into the controller
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/list")
	public String listClient(Model theModel) {
		
		//get the clients from the service
		List<Client> clients = clientService.getClients();
		
		//add the clients to the model
		theModel.addAttribute("clients",clients);
		
		return "list-clients";
	}
	
	@RequestMapping("/AddNewClient")
	public String showAddClientForm(Model model) {
		
		//create model attribute to bind data
		Client newClient = new Client();
		
		model.addAttribute("client",newClient);
		return "client-form";
	}
	
	@PostMapping("/saveClient")
	public String saveClient(@ModelAttribute("client") Client client) {
		
		clientService.saveClient(client);
		return "redirect:/client/list";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("clientID") int id,Model model ) {
		
		//get the client from the service
		Client client = clientService.getClients(id);
		
		//set client as a model attribute to pre-populate the form
		model.addAttribute("client",client);
		
		//send over to the html form
		return "client-form-update";
	}
	
	@RequestMapping("/delete")
	public String deleteClient(@RequestParam("clientID") int id) {
		clientService.deleteClient(id);
		
		return "redirect:/client/list";
	}
	
	@PostMapping("/searchClient")
	public String searchClient(@RequestParam("theSearchName") String clientName,Model model) {
		
		//search clients from the service
		List<Client> clients = clientService.searchClients(clientName);
		
		//add the clients to the model
		model.addAttribute("clients",clients);
		
		return "list-clients";
	}
}

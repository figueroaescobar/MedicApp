package com.medic;

import static  org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.medic.model.Usuario;
import com.medic.repo.IUsuarioRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicApplicationTests {
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired
	private IUsuarioRepo repo;

	@Test
	public void crearUsusrio() {
		Usuario us = new Usuario();
		us.setIdUsuario(1);
		us.setUsername("jfigueroa@gmail.com");
		us.setPassword(bcrypt.encode("felipe0512"));
		us.setEnabled(true);
		
		Usuario retorno = repo.save(us);
		
		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));
	}

}

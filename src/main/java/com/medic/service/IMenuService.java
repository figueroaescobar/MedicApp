package com.medic.service;

import java.util.List;

import com.medic.model.Menu;

public interface IMenuService extends ICRUD<Menu> {
	
	List<Menu> listarMenuPorUsuario(String nombre);

}

package com.medic.service;

import com.medic.model.ResetToken;

public interface IResetTokenService {
	
	ResetToken findByToken(String token);
	
	void guardar(ResetToken token);
	
	void eliminar(ResetToken token);

}

package com.irandoo.xhep.anth.service;

import com.irandoo.xhep.anth.model.JwtToken;

/**
 * @description: 重新拉取token
 * @author sun
 *
 */

public interface JwtTokenService {
	
   /**
    *  重新拉取token
    * @param refreshToken
    * @return
    */
  public JwtToken JwtToken(String refreshToken);
}

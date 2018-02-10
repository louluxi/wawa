package com.irandoo.xhep.base.service;

import java.util.List;

import com.irandoo.xhep.base.model.Merch;
import com.irandoo.xhep.base.model.MerchType;

public interface MerchService extends BaseService<Merch>{

	/**
	    * 商品类别下拉
	    * @return
	    */
		List<MerchType> selMerchType ();
}

package com.irandoo.xhep.base.mapper;

import java.util.List;

import com.irandoo.xhep.base.model.MerchType;

public interface MerchMapper extends BaseMapper {

	/**
	    * 商品类别下拉
	    * @return
	    */
		List<MerchType> selMerchType ();
}

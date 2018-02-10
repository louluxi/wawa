package com.irandoo.xhep.base.action;


import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.support.alipay.AliPayStringUtil;
import com.irandoo.xhep.base.model.Dictionary;
import com.irandoo.xhep.base.model.Merch;
import com.irandoo.xhep.base.model.MerchType;
import com.irandoo.xhep.base.service.MerchService;
import com.irandoo.xhep.base.util.ImageUploadUtil;
import com.irandoo.xhep.sys.service.DictionaryService;
@Controller("merchAction")
@Scope("prototype")
public class MerchAction extends BaseAction {


	private static final long serialVersionUID = -5769291852194590076L;
	private Log logger = LogFactory.getLog(MerchAction.class); 
    @Autowired
    private MerchService merchService;
    private Merch merch;
    @Autowired
	private DictionaryService dictionaryService;
    private List<Dictionary> merchStrutsList;
    private List<MerchType> merchTypeList;
    
    private File uploadfile;

	private String uploadfileFileName;

	private String uploadfileContentType;
	
	private File merchDescfile;

    private String merchDescfileFileName;

	private String merchDescfileContentType;
	/**
	 * 加载数据
	 * @return
	 */
	public String getAjaxData() {
	   String jsonData = merchService.getInfoListStr(getConditionMap());
	   return toJsonData(jsonData);
	}
	/**
	 * 删除
	 * @return
	 */
	public String delete() {
		logger.debug("enter delete");
		boolean result = true;
		String id = request.getParameter("ids");
	    try {
			merchService.deleteById(Long.valueOf(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
		}
	    logger.debug("exit delete");

		return result(result);
	}
	/**
	 * 跳转
	 * 
	 * @return
	 */
	public String getInfoById() {
		logger.debug("enter getInfoById");
		
		String id = request.getParameter("id");
		String opt = request.getParameter("opt");
		merchStrutsList = dictionaryService.getByDescript("是否");
		merchTypeList = merchService.selMerchType();
		if (StringUtils.isEmpty(opt)) {
			return ERROR;
		}
		// 商品添加
		if (ADD.equals(opt)) {
			merch = new Merch();
			request.setAttribute("title", "商品添加");
		}
		//商品更新
		else if (UPDATE.equals(opt)) {
			merch = merchService.getInfoById(Long.parseLong(id));
			request.setAttribute("title", "商品更新");
		}
		//视图
		else if (VIEW.equals(opt)) {
			merch = merchService.getInfoById(Long.parseLong(id));
			request.setAttribute("title", "视图");
		}
		else {
			request.setAttribute("title", "�û�����");
		}
		return SUCCESS;
	}
	/**
	 * 保存和更新
	 * @return
	 */
	public String saveOrUpdate() {
		logger.debug("enter saveOrUpdate");
		String merch_desc = request.getParameter("merch_desc");
		logger.info("merch_desc:"+merch_desc);
		if (merch == null) {
			merch = new Merch();
		}
		if (merch.getId() == null) {
			try {
				if (AliPayStringUtil.isEmpty(merch_desc)) {
					merch.setMerch_desc(merch_desc);
				}
				if (uploadfile != null) {
					String cosName = ImageUploadUtil.upload(uploadfile,this.uploadfileFileName,"other");
					merch.setIcon_path(cosName);
				}
				if (merchDescfile != null) {
					String cosName = ImageUploadUtil.upload(merchDescfile,this.merchDescfileFileName,"other");
					merch.setMerch_desc_img(cosName);
				}
				merchService.insert(merch);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return SUCCESS;
			}
			return SUCCESS;
		}else {
			try {
				if (AliPayStringUtil.isEmpty(merch_desc)) {
					merch.setMerch_desc(merch_desc);
				}
				if (uploadfile != null) {
					String cosName = ImageUploadUtil.upload(uploadfile,this.uploadfileFileName,"other");
					merch.setIcon_path(cosName);
				}
				if (merchDescfile != null) {
					String cosName = ImageUploadUtil.upload(merchDescfile,this.merchDescfileFileName,"other");
					merch.setMerch_desc_img(cosName);
				}
				merchService.update(merch);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return SUCCESS;
			}
			return SUCCESS;
		}
	}
	/**
	 *跳转
	 * 
	 * @return
	 */
	public String toLoadList() {
		merchStrutsList = dictionaryService.getByDescript("是否");
		request.setAttribute("title", "商品");
		return SUCCESS;
	}
	public void setMerch(Merch merch) {
		this.merch = merch;
	}
	public Merch getMerch() {
		return merch;
	}
	public List<Dictionary> getMerchStrutsList() {
		return merchStrutsList;
	}
	public void setMerchStrutsList(List<Dictionary> merchStrutsList) {
		this.merchStrutsList = merchStrutsList;
	}
	public List<MerchType> getMerchTypeList() {
		return merchTypeList;
	}
	public void setMerchTypeList(List<MerchType> merchTypeList) {
		this.merchTypeList = merchTypeList;
	}
	public File getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(File uploadfile) {
		this.uploadfile = uploadfile;
	}
	public String getUploadfileFileName() {
		return uploadfileFileName;
	}
	public void setUploadfileFileName(String uploadfileFileName) {
		this.uploadfileFileName = uploadfileFileName;
	}
	public String getUploadfileContentType() {
		return uploadfileContentType;
	}
	public void setUploadfileContentType(String uploadfileContentType) {
		this.uploadfileContentType = uploadfileContentType;
	}
	public File getMerchDescfile() {
		return merchDescfile;
	}
	public void setMerchDescfile(File merchDescfile) {
		this.merchDescfile = merchDescfile;
	}
	
	public String getMerchDescfileFileName() {
		return merchDescfileFileName;
	}
	public void setMerchDescfileFileName(String merchDescfileFileName) {
		this.merchDescfileFileName = merchDescfileFileName;
	}
	public String getMerchDescfileContentType() {
		return merchDescfileContentType;
	}
	public void setMerchDescfileContentType(String merchDescfileContentType) {
		this.merchDescfileContentType = merchDescfileContentType;
	}
	
}

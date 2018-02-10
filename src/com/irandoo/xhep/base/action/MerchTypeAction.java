package com.irandoo.xhep.base.action;

import java.io.File;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.xhep.base.model.MerchType;
import com.irandoo.xhep.base.service.MerchTypeService;
import com.irandoo.xhep.base.util.ImageUploadUtil;

@Controller("merchTypeAction")
@Scope("prototype")
public class MerchTypeAction extends BaseAction {

	
	private static final long serialVersionUID = 2068663466194911220L;
	private Log logger = LogFactory.getLog(MerchTypeAction.class);
    @Autowired
	private MerchTypeService merchTypeService;
    
    private MerchType merchType;
    
    private File uploadfile;

   	private String uploadfileFileName;

   	private String uploadfileContentType;
    
    /**
	 * 获取数据
	 * @return
	 */
	public String getAjaxData() {
		logger.debug("enter getAjaxData");
		String jsonData = merchTypeService.getInfoListStr(getConditionMap());
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
			merchTypeService.deleteById(Long.valueOf(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
		}
	    logger.debug("exit delete");

		return result(result);
	}
	/**
	 * 不同类型的跳转
	 * 
	 * @return
	 */
	public String getInfoById() {
		logger.debug("enter getInfoById");
		String id = request.getParameter("id");
		String opt = request.getParameter("opt");
		if (StringUtils.isEmpty(opt)) {
			return ERROR;
		}
		// 商品类别添加
		if (ADD.equals(opt)) {
			merchType = new MerchType();
			request.setAttribute("title", "商品类别添加");
		}
		// 商品类别更新
		else if (UPDATE.equals(opt)) {
			merchType = merchTypeService.getInfoById(Long.parseLong(id));
			request.setAttribute("title", "商品类别更新");
		}
		// 视图
		else if (VIEW.equals(opt)) {
			merchType = merchTypeService.getInfoById(Long.parseLong(id));
			request.setAttribute("title", "视图");
		}
		else {
			request.setAttribute("title", "不知道");
		}
		return SUCCESS;
	}
	/**
	 * 保存并更新
	 * @return
	 */
	public String saveOrUpdate() {
		logger.debug("enter saveOrUpdate");
		if (merchType == null) {
			merchType = new MerchType();
		}
		if (merchType.getId() == null) {
			try {
				if (uploadfile != null) {
					String cosName = ImageUploadUtil.upload(uploadfile,this.uploadfileFileName,"merthType"); 
				    merchType.setIcon_path(cosName);
				}
				merchTypeService.insert(merchType);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return SUCCESS;
			}
			return SUCCESS;
		}else {
			try {
				if (uploadfile != null) {
					String cosName = ImageUploadUtil.upload(uploadfile,this.uploadfileFileName,"merthType"); 
				    merchType.setIcon_path(cosName);
				}
				merchTypeService.update(merchType);
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
		logger.debug("enter toLoadList");
		request.setAttribute("title", "管理页面");
		return SUCCESS;
	}
	public MerchType getMerchType() {
		return merchType;
	}
	public void setMerchType(MerchType merchType) {
		this.merchType = merchType;
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

	

}

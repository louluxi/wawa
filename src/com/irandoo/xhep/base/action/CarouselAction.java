package com.irandoo.xhep.base.action;


import java.io.File;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.xhep.base.model.Carousel;
import com.irandoo.xhep.base.model.Dictionary;
import com.irandoo.xhep.base.service.CarouselService;
import com.irandoo.xhep.base.service.DeviceService;
import com.irandoo.xhep.base.util.ImageUploadUtil;
import com.irandoo.xhep.sys.service.DictionaryService;


@Controller("carouselAction")
@Scope("prototype")
public class CarouselAction extends BaseAction{

	
	private static final long serialVersionUID = -2524104690633582447L;
	private Log logger = LogFactory.getLog(CarouselAction.class);
    @Autowired
    private CarouselService carouselService;
    
    private Carousel carousel;
    
    private File uploadfile;

	private String uploadfileFileName;

	private String uploadfileContentType;

	@Autowired
	private DictionaryService dictionaryService;
    
	private List<Dictionary> carouserlStateList;//设备状态
    /**
	 * 加载数据
	 * 
	 * @return
	 */
	public String getAjaxData() {
		String jsonData = carouselService.getInfoListStr(getConditionMap());
		return toJsonData(jsonData);
	}
    
	/**
	 * 不同的跳转
	 * @return
	 */
	public String getInfoById() {
		logger.debug("enter getInfoById");
		carouserlStateList = dictionaryService.getByDescript("轮播内容状态");
		String id = request.getParameter("id");
		String opt = request.getParameter("opt");
		if (StringUtils.isEmpty(opt)) {
			return ERROR;
		}
		// 轮播图添加
		if (ADD.equals(opt)) {
			carousel = new Carousel();
			request.setAttribute("title", "轮播图添加");
		}
		// 轮播图更新
		else if (UPDATE.equals(opt)) {
			carousel = carouselService.getInfoById(Long.parseLong(id));	
			request.setAttribute("title", "轮播图更新");
		}
		//视图
		else if (VIEW.equals(opt)) {
			
		}
		else {
			request.setAttribute("title", "视图");
		}
		return SUCCESS;
	}
	/**
	 * 保存和更新
	 * @return
	 */
	public String saveOrUpdate() {
		logger.debug("enter saveOrUpdate");
		if (carousel == null) {
			carousel = new Carousel();
		}
		if (carousel.getId() == null) {
			try {	
				if (uploadfile != null) {
					String cosName = ImageUploadUtil.upload(uploadfile,this.uploadfileFileName,"ad");
					carousel.setIcon_path(cosName);
				}
				carouselService.insert(carousel);
			} catch (Exception e) {
				e.printStackTrace();
				return SUCCESS;
			}
			return SUCCESS;
		}else {
			try {
				if (uploadfile != null) {
					String cosName = ImageUploadUtil.upload(uploadfile,this.uploadfileFileName,"ad");
					carousel.setIcon_path(cosName);
				}
               carouselService.update(carousel);
			} catch (Exception e) {
				e.printStackTrace();
				return SUCCESS;
			}
			return SUCCESS;
		}
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
			carouselService.deleteById(Long.valueOf(id));
		} catch (Exception e) {
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
	public String toLoadList() {
		
		carouserlStateList = dictionaryService.getByDescript("轮播内容状态");
		logger.info(carouserlStateList.get(0).getDictName());
		request.setAttribute("title", "房间");
		return SUCCESS;
	}
	public Carousel getCarousel() {
		return carousel;
	}

	public void setCarousel(Carousel carousel) {
		this.carousel = carousel;
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

	public List<Dictionary> getCarouserlStateList() {
		return carouserlStateList;
	}

	public void setCarouserlStateList(List<Dictionary> carouserlStateList) {
		this.carouserlStateList = carouserlStateList;
	}



}

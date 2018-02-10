package com.irandoo.xhep.base.action;

import java.io.File;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.xhep.base.model.Carousel;
import com.irandoo.xhep.base.model.RoomClass;
import com.irandoo.xhep.base.service.RoomClassService;
import com.irandoo.xhep.base.util.ImageUploadUtil;

@Controller("roomClassAction")
@Scope("prototype")
public class RoomClassAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3575331121660915536L;

	private Log logger = LogFactory.getLog(RoomClassAction.class);
	
	@Autowired
	private RoomClassService roomClassService;
	
	private RoomClass roomClass;
	
	private File uploadfile;

	private String uploadfileFileName;

	private String uploadfileContentType;
	 /**
		 * 加载数据
		 * 
		 * @return
		 */
		public String getAjaxData() {
			String jsonData = roomClassService.getInfoListStr(getConditionMap());
			return toJsonData(jsonData);
		}
		/**
		 * 不同的跳转
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
				roomClass = new RoomClass();
				request.setAttribute("title", "商品类别添加");
			}
			// 商品类别更新
			else if (UPDATE.equals(opt)) {
				roomClass = roomClassService.getInfoById(Long.parseLong(id));	
				request.setAttribute("title", "商品类别更新");
			}
			//视图
			else if (VIEW.equals(opt)) {
				/*user = userService.getInfoById(Long.parseLong(id));
				request.setAttribute("title", "视图");*/
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
			if (roomClass == null) {
				roomClass = new RoomClass();
			}
			if (roomClass.getId() == null) {
				try {	
					if (uploadfile != null) {
						String cosName = ImageUploadUtil.upload(uploadfile,this.uploadfileFileName,"ad");
						roomClass.setClass_icon(cosName);
					}
					roomClassService.insert(roomClass);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return SUCCESS;
				}
				return SUCCESS;
			}else {
				try {
					if (uploadfile != null) {
						String cosName = ImageUploadUtil.upload(uploadfile,this.uploadfileFileName,"other");
						roomClass.setClass_icon(cosName);
					}
					roomClassService.update(roomClass);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return SUCCESS;
				}
				return SUCCESS;
			}
		}
		/**
		 * 跳转
		 * 
		 * @return
		 */
		public String toLoadList() {
			request.setAttribute("title", "房间类别");
			return SUCCESS;
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
		    	roomClassService.deleteById(Long.valueOf(id));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result = false;
			}
		    logger.debug("exit delete");

			return result(result);
		}
		
		
		public RoomClass getRoomClass() {
			return roomClass;
		}
		public void setRoomClass(RoomClass roomClass) {
			this.roomClass = roomClass;
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

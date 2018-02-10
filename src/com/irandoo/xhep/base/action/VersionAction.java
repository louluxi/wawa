package com.irandoo.xhep.base.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.irandoo.xhep.base.model.Dictionary;
import com.irandoo.xhep.base.model.Version;
import com.irandoo.xhep.base.service.VersionService;
import com.irandoo.xhep.sys.service.DictionaryService;

@Controller("verAction")
@Scope("prototype")
public class VersionAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8977956292363033604L;
	
	private Log logger = LogFactory.getLog(VersionAction.class);
	
	@Autowired
    private VersionService versionService;
	
	private Version version;
	
	@Autowired
	private DictionaryService dictionaryService;
	
	private List<Dictionary> statusList;
	 /**
		 * 加载数据
		 * 
		 * @return
		 */
		public String getAjaxData() {
			String jsonData = versionService.getInfoListStr(getConditionMap());
			return toJsonData(jsonData);
		}
		/**
		 * 更新版本状态
		 * @return
		 */
		public String updatePutaway() {
			boolean result = true;
			String id = request.getParameter("id");
			String stauts = request.getParameter("stauts");
			Version version = new Version();
			version.setId(Long.valueOf(id));
			version.setStatus(stauts);
		    try {
		    	versionService.update(version);
			} catch (Exception e) {
				e.printStackTrace();
				result = false;
			}

			return result(result);
		}
		
		/**
		 * 不同的跳转
		 * @return
		 */
		public String getInfoById() {
			logger.debug("enter getInfoById");
			String id = request.getParameter("id");
			String opt = request.getParameter("opt");
			statusList = dictionaryService.getByDescript("版本状态");
			if (StringUtils.isEmpty(opt)) {
				return ERROR;
			}
			// 轮播图添加
			if (ADD.equals(opt)) {
				version = new Version();
				request.setAttribute("title", "版本添加");
			}
			// 轮播图更新
			else if (UPDATE.equals(opt)) {
				version = versionService.getInfoById(Long.parseLong(id));
				logger.info(version);
				request.setAttribute("title", "版本更新");
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
		 * 跳转
		 * 
		 * @return
		 */
		public String toLoadList() {
			statusList = dictionaryService.getByDescript("版本状态");
			request.setAttribute("title", "版本管理");
			return SUCCESS;
		}
		
		/**
		 * 保存和更新
		 * @return
		 */
		public String saveOrUpdate() {
			logger.debug("enter saveOrUpdate");

			if (version == null) {
				version = new Version();
			}
			if (version.getId() == null) {
				try {	
					versionService.insert(version);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return SUCCESS;
				}
				return SUCCESS;
			}else {
				try {
					versionService.update(version);
				} catch (Exception e) {
					// TODO Auto-generated catch block
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
		    	versionService.deleteById(Long.valueOf(id));
			} catch (Exception e) {
				e.printStackTrace();
				result = false;
			}
		    logger.debug("exit delete");

			return result(result);
		}
		public Version getVersion() {
			return version;
		}
		public void setVersion(Version version) {
			this.version = version;
		}
		public List<Dictionary> getStatusList() {
			return statusList;
		}
		public void setStatusList(List<Dictionary> statusList) {
			this.statusList = statusList;
		}
		
}

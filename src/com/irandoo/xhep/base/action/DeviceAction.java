package com.irandoo.xhep.base.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.xhep.base.model.Device;
import com.irandoo.xhep.base.model.Dictionary;
import com.irandoo.xhep.base.service.DeviceService;
import com.irandoo.xhep.sys.service.DictionaryService;

@Controller("deviceAction")
@Scope("prototype")
public class DeviceAction extends BaseAction {

	private static final long serialVersionUID = -1697506258396824112L;
	private Log logger = LogFactory.getLog(DeviceAction.class);
	@Autowired
	private DeviceService deviceService;
	private Device device;
	private List<Dictionary> deviceTypeList;//设备类型
	private List<Dictionary> deviceStatusList;//设备状态
	@Autowired
	private DictionaryService dictionaryService;
	/**
	 * 加载数据
	 * @return
	 */
	public String getAjaxData() {
		String jsonData = deviceService.getInfoListStr(getConditionMap());
	    return toJsonData(jsonData);
	}
	/**
	 * 删除数据
	 * @return
	 */
	public String delete() {
		logger.debug("enter delete");
		boolean result = true;
		String id = request.getParameter("ids");
	    try {
			deviceService.deleteById(Long.valueOf(id));
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
	    logger.debug("exit delete");

		return result(result);
	}
	/**
	 * 查看数据
	 * @return
	 */
	public String getInfoById() {
		logger.debug("enter getInfoById");
		String id = request.getParameter("id");
		String opt = request.getParameter("opt");
		deviceTypeList = dictionaryService.getByDescript("设备类型");
		deviceStatusList = dictionaryService.getByDescript("设备状态");
		if (StringUtils.isEmpty(opt)) {
			return ERROR;
		}
		// 新增页面
		if (ADD.equals(opt)) {
			device = new Device();
			request.setAttribute("title", "设备新增");
		}
		// 修改页面
		else if (UPDATE.equals(opt)) {
			device = deviceService.getInfoById(Long.parseLong(id));	
			request.setAttribute("title", "设备修改");
		}
		// 分配页面
		else if (VIEW.equals(opt)) {
			/*user = userService.getInfoById(Long.parseLong(id));
			request.setAttribute("title", "分配页面");*/
		}
		else {
			request.setAttribute("title", "用户新增");
		}
		return SUCCESS;
	}
	/**
	 * 保存数据
	 * @return
	 */
	public String saveOrUpdate() {
		logger.debug("enter saveOrUpdate");
		if (device == null) {
			device = new Device();
		}
		if (device.getId() == null) {
			try {
				deviceService.insert(device);
			} catch (Exception e) {
				e.printStackTrace();
				return SUCCESS;
			}
			return SUCCESS;
		}else {
			try {
				deviceService.update(device);
			} catch (Exception e) {
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
		deviceTypeList = dictionaryService.getByDescript("设备类型");
		deviceStatusList = dictionaryService.getByDescript("设备状态");
		request.setAttribute("title", "设备");
		return SUCCESS;
	}
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}
	public List<Dictionary> getDeviceTypeList() {
		return deviceTypeList;
	}
	public void setDeviceTypeList(List<Dictionary> deviceTypeList) {
		this.deviceTypeList = deviceTypeList;
	}
	public List<Dictionary> getDeviceStatusList() {
		return deviceStatusList;
	}
	public void setDeviceStatusList(List<Dictionary> deviceStatusList) {
		this.deviceStatusList = deviceStatusList;
	}
	
} 

package com.irandoo.xhep.base.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.irandoo.xhep.base.model.Dictionary;
import com.irandoo.xhep.base.model.Role;
import com.irandoo.xhep.base.model.User;
import com.irandoo.xhep.base.model.UserRole;
import com.irandoo.xhep.base.service.UserRoleService;
import com.irandoo.xhep.base.service.UserService;
import com.irandoo.xhep.base.util.ExcelException;
import com.irandoo.xhep.base.util.ExcelUitl;
import com.irandoo.xhep.base.util.MD5;
import com.irandoo.xhep.sys.service.DictionaryService;
import com.irandoo.xhep.sys.service.RoleService;

/**
 * 用户管理控制类
 * 
 * @author ager
 *
 */
@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction {

	private static final long serialVersionUID = -1350801866160866958L;
	private Log logger = LogFactory.getLog(UserAction.class);
	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private DictionaryService dictionaryService;
	
	private User user;
	
	private List<Dictionary> genderList;
	
	private List<Dictionary> userTypeList;
	
	private List<Role> roleList;
	
	
	/**
	 * 替换所有用户的二维码信息
	 * @return 
	 */
	public String  replaceAllIcon() {
		logger.debug("enter replaceAllIcon");
		logger.info("enter replaceAllIcon");
		boolean result = true;
		try {
			userService.repalce();
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result(result);
	}
	/**
	 * 跳转
	 * 
	 * @return
	 */
	public String toLoadList() {
		userTypeList = dictionaryService.getByDescript("用户类型");
		genderList = dictionaryService.getByDescript("用户状态");
		request.setAttribute("title", "用户");
		return SUCCESS;
	}

	/**
	 * 加载数据
	 * 
	 * @return
	 */
	public String getAjaxData() {
		String jsonData = userService.getInfoListStr(getConditionMap());
		return toJsonData(jsonData);
	}

	/**
	 * 根据用户编码判断用户是否存在
	 * 
	 * @return
	 */
	public String checkCode() {
		String user_code = request.getParameter("user_code");
		List<User> userList = userService.getInfoByCode(user_code);
		Map<String, Object> result = new HashMap<String, Object>();
		if (userList.size() > 0) {
			result.put("result", "true");
			result.put("user", userList.get(0));
		} else {
			result.put("result", "false");
			result.put("user", user);
		}
		String json = "";
		try {
			json = JSON.toJSONString(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toJsonData(json);
	}

	/**
	 * 保存数据
	 * 
	 * @return
	 */
	public String saveOrUpdate() {
		logger.debug("enter saveOrUpdate");
		if (user == null) {
			user = new User();
		}
		if(null != user.getUser_pwd()&&!"".equals(user.getUser_pwd())){
			String pwd = user.getUser_pwd();
			user.setUser_pwd(pwd.substring(pwd.indexOf(',')+1, pwd.length()).trim());
		}
		if(null != user.getUser_code()&&null != user.getUser_pwd()){
			user.setStatus(5);
			user.setUser_pwd(MD5.MD5Encode(user.getUser_code() + user.getUser_pwd()));
		}else{
			user.setStatus(4);
		}
		if (user.getId() == null) {
			try {
				userService.insert(user);
			} catch (Exception e) {
				e.printStackTrace();
				return SUCCESS;
			}
		} else {
			try {
				userService.update(user);
			} catch (Exception e) {
				e.printStackTrace();
				return SUCCESS;
			}
		}
		String role = user.getRole();
		if(null != role && !"".equals(role)&& !"null".equals(role)){
			userRoleService.deleteByUserId(user.getId());
			String[] roleArr = role.split(",");
			for(String roleId:roleArr){
				UserRole userRole = new UserRole();
				userRole.setRole_id(Long.valueOf(roleId.trim()));
				userRole.setUser_id(user.getId());
				userRoleService.insert(userRole);
			}
		}
		return SUCCESS;
	}

	public String updateUser() {
		try {
			userService.update(user);
			HttpSession session = request.getSession(false);
			session.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String getUserRole(){
		String user_id = request.getParameter("userId");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("user_id", user_id);
		List<UserRole> userRoleList = userRoleService.getAllList(map);
		String json = "";
		try {
			json = JSON.toJSONString(userRoleList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toJsonData(json);
	}
	
	/**
	 * 查看数据
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
		userTypeList = dictionaryService.getByDescript("用户类型");
		genderList = dictionaryService.getByDescript("用户状态");
		Map<String,Object> map = new HashMap<String,Object>();
		roleList = roleService.getAllList(map);
		// 新增页面
		if (ADD.equals(opt)) {
			user = new User();
			request.setAttribute("title", "用户新增");
		}
		// 修改页面
		else if (UPDATE.equals(opt)) {
			user = userService.getInfoById(Long.parseLong(id));
			request.setAttribute("title", "用户修改");
		}
		// 分配页面
		else if (VIEW.equals(opt)) {
			user = userService.getInfoById(Long.parseLong(id));
			request.setAttribute("title", "用户分配");
		}
		else {
			request.setAttribute("title", "用户新增");
		}
		return SUCCESS;
	}

	/**
	 * 跳转
	 * 
	 * @return
	 */
	public String toImport() {
		request.setAttribute("title", "用户");
		return SUCCESS;
	}

	public String importData() {
		if (uploadfile != null) {
			try {
				InputStream in = new FileInputStream(uploadfile);
				LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
				fieldMap.put("用户账号", "user_code");
				fieldMap.put("用户密码", "user_pwd");
				fieldMap.put("企业名称", "business_name");
				fieldMap.put("企业邮箱", "business_email");
				fieldMap.put("部门", "department");
				fieldMap.put("职务", "post");
				fieldMap.put("姓名", "user_name");
				fieldMap.put("性别", "gender");
				fieldMap.put("联系电话", "user_tel");
				fieldMap.put("联系人邮箱","user_email");
				fieldMap.put("用户类型","user_type");
				String[] temp = {};
				List<User> userList = ExcelUitl.excelToList(in, "User", User.class, fieldMap, temp);
				for(User user: userList){
					if(null != user.getUser_code() && !"".equals(user.getUser_code())&& !"null".equals(user.getUser_code())&&null != user.getUser_pwd() && !"".equals(user.getUser_pwd())&& !"null".equals(user.getUser_pwd())){
						String password = MD5.MD5Encode(user.getUser_code().trim() + user.getUser_pwd().trim());
						user.setUser_pwd(password);
						user.setStatus(5);
						userTypeList = dictionaryService.getByDescriptAndDictName("用户类型", user.getUser_type());
						genderList = dictionaryService.getByDescriptAndDictName("性别", user.getGender());
						if(userTypeList.size()>0){
							user.setUser_type(userTypeList.get(0).getDictId());
						}
						if(genderList.size()>0){
							user.setGender(genderList.get(0).getDictId());
						}
						List<User> checkUser = userService.getInfoByCode(user.getUser_code());
						if(checkUser.size()>0){
							user.setId(checkUser.get(0).getId());
							userService.update(user);
						}else{
							user.setStatus(0);
							user.setExpire_date(new Date());
							userService.insert(user);
						}
						String role = user.getRole();
						if(null != role && !"".equals(role)&& !"null".equals(role)){
							Map<String,Object> map = new HashMap<String,Object>();
							map.put("role_id", role);
							List<Role> roleList = roleService.getAllList(map);
							if(roleList.size() > 0){
								UserRole userRole = new UserRole();
								userRole.setRole_id(roleList.get(0).getId());
								userRole.setUser_id(user.getId());
								userRoleService.insert(userRole);
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void exportData() {
		List<User> userList = userService.getAllList(getConditionMap());
		LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
		fieldMap.put("user_code", "用户账号");
		fieldMap.put("business_name", "企业名称");
		fieldMap.put("business_email", "企业邮箱");
		fieldMap.put("department", "部门");
		fieldMap.put("post", "职务");
		fieldMap.put("user_name", "姓名");
		fieldMap.put("genderShow", "性别");
		fieldMap.put("user_tel", "联系电话");
		fieldMap.put("user_email","联系人邮箱");
		fieldMap.put("typeShow","用户类型");
		if (userList.size() > 0) {
			try {
				ExcelUitl.listToExcel(userList, fieldMap, "用户信息", response);
			} catch (ExcelException e) {
				e.printStackTrace();
			}
		}
	}

	 public String download() throws Exception{
	    	String fileName ="用户信息.xls";
	    	//要下载的哪个文件
	    	String path = ServletActionContext.getServletContext().getRealPath(File.separator);//得到项目的根目录
	    	InputStream is = new FileInputStream(path+File.separator + "upload"+File.separator + fileName);
	    	//下载到哪里？客户端
	    	HttpServletResponse response = ServletActionContext.getResponse();
	    	OutputStream os = response.getOutputStream();
	    	//弹出下载的框filename:提示用户下载的文件名
	    	response.addHeader("content-disposition", "attachment;filename="+java.net.URLEncoder.encode(fileName,"utf-8"));
	    	byte[] b = new byte[1024];
	    	int size = is.read(b);
	    	while(size>0){
	    	    os.write(b,0,size);
	    	    size = is.read(b);
	    	}
	    	is.close();
	    	os.close();
	    	return null;
	    }
	
	/**
	 * 跳转
	 * 
	 * @return
	 */
	public String toRecovery() {
		String idarr = request.getParameter("ids");
		request.setAttribute("ids", idarr);
		request.setAttribute("title", "住户");
		return SUCCESS;
	}

	/**
	 * 删除数据
	 * 
	 * @return
	 */
	public String delete() {
		logger.debug("enter delete");
		boolean result = true;
		String id = request.getParameter("ids");

		try {
			userRoleService.deleteByUserId(Long.valueOf(id));
			userService.deleteOne(Long.valueOf(id));
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}

		logger.debug("exit delete");

		return result(result);
	}

	private File uploadfile;

	private String uploadfileFileName;

	private String uploadfileContentType;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public List<Dictionary> getUserTypeList() {
		return userTypeList;
	}

	public void setUserTypeList(List<Dictionary> userTypeList) {
		this.userTypeList = userTypeList;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<Dictionary> getGenderList() {
		return genderList;
	}

	public void setGenderList(List<Dictionary> genderList) {
		this.genderList = genderList;
	}
}

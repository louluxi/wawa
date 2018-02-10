package com.irandoo.xhep.base.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.xhep.base.model.Dictionary;
import com.irandoo.xhep.base.model.Member;
import com.irandoo.xhep.base.service.MemberService;
import com.irandoo.xhep.sys.service.DictionaryService;

/**
 *  会员管理action
 * @author sun
 *
 */
@Controller("memberAction")
@Scope("prototype")
public class MemberAction extends BaseAction{

	private static final long serialVersionUID = -1685556258396824112L;
	private Log logger = LogFactory.getLog(MemberAction.class);
	@Autowired
	private MemberService memberService;
	
	private Member member;

	@Autowired
	private DictionaryService dictionaryService;
	
	private List<Dictionary> strutsList;
	
	/**
	 * 跳转
	 * 
	 * @return
	 */
	public String toLoadList() {
		strutsList = dictionaryService.getByDescript("用户状态");
		return SUCCESS;
	}

	
	/**
	 * 获取数据
	 * @return
	 */
	public String getAjaxData() {
		String jsonData = memberService.getInfoListStr(getConditionMap());
	    return toJsonData(jsonData);
	}
	
	
	
	public String delete() {
		logger.debug("enter delete");
		boolean result = true;
		String id = request.getParameter("ids");
	    try {
	    	memberService.deleteById(Long.valueOf(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
		}
	    logger.debug("exit delete");

		return result(result);
	}
	/**
	 * �鿴���
	 * @return
	 */
	public String getInfoById() {
		logger.debug("enter getInfoById");
		String id = request.getParameter("id");
		String opt = request.getParameter("opt");
		if (StringUtils.isEmpty(opt)) {
			return ERROR;
		}
		// ����ҳ��
		if (ADD.equals(opt)) {
			member = new Member();
			request.setAttribute("title", "�û�����");
		}
		// 会员详细查看
		else if (UPDATE.equals(opt)) {
			member = memberService.getInfoById(Long.parseLong(id));	
			request.setAttribute("title", "会员详细查看");
		}
		// ����ҳ��
		else if (VIEW.equals(opt)) {
			/*user = userService.getInfoById(Long.parseLong(id));
			request.setAttribute("title", "�û�����");*/
		}
		else {
			request.setAttribute("title", "�û�����");
		}
		return SUCCESS;
	}
	
	
	/**
	 * 增加修改套餐
	 * @return
	 */
	public String saveOrUpdate() {
		logger.debug("enter saveOrUpdate");
		if (member == null) {
			member = new Member();
		}
		if (member.getId() == null) {
			try {
				memberService.insert(member);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return SUCCESS;
			}
			return SUCCESS;
		}else {
			try {
				memberService.update(member);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return SUCCESS;
			}
			return SUCCESS;
		}
	}
	
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}


	public List<Dictionary> getStrutsList() {
		return strutsList;
	}


	public void setStrutsList(List<Dictionary> strutsList) {
		this.strutsList = strutsList;
	}
	
	

}

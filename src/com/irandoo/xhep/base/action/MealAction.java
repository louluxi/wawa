package com.irandoo.xhep.base.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.irandoo.xhep.base.model.Dictionary;
import com.irandoo.xhep.base.model.Meal;
import com.irandoo.xhep.base.service.MealService;
import com.irandoo.xhep.sys.service.DictionaryService;

@Controller("mealAction")
@Scope("prototype")
public class MealAction extends BaseAction{

	private static final long serialVersionUID = -1685306258396824112L;
	private Log logger = LogFactory.getLog(MealAction.class);
	@Autowired
	private MealService mealService;
	
	private Meal meal;

	@Autowired
	private DictionaryService dictionaryService;
	
	private List<Dictionary> mealStrutsList;//设备状态
	/**
	 * 跳转
	 * 
	 * @return
	 */
	public String toLoadList() {
		mealStrutsList = dictionaryService.getByDescript("套餐状态");
		request.setAttribute("title", "套餐管理");
		return SUCCESS;
	}
	
	
	
	/**
	 * 加载数据
	 * @return
	 */
	public String getAjaxData() {
		logger.debug("enter getAjaxData");
		String jsonData = mealService.getInfoListStr(getConditionMap());
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
			mealService.deleteById(Long.valueOf(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
		}
	    logger.debug("exit delete");

		return result(result);
	}
	/**
	 * 不同的标题跳转
	 * @return
	 */
	public String getInfoById() {
		logger.debug("enter getInfoById");
		mealStrutsList = dictionaryService.getByDescript("套餐状态");
		String id = request.getParameter("id");
		String opt = request.getParameter("opt");
		if (StringUtils.isEmpty(opt)) {
			return ERROR;
		}
		// 套餐添加
		if (ADD.equals(opt)) {
			meal = new Meal();
			request.setAttribute("title", "套餐添加");
		}
		// 套餐更新
		else if (UPDATE.equals(opt)) {
			meal = mealService.getInfoByMealId(Long.parseLong(id));	
			request.setAttribute("title", "套餐更新");
		}
		//跳转
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
	 * 更新和保存
	 * @return
	 */
	public String saveOrUpdate() {
		logger.debug("enter saveOrUpdate");
		if (meal == null) {
			meal = new Meal();
		}
		if (meal.getId() == null) {
			try {
				mealService.insert(meal);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return SUCCESS;
			}
			return SUCCESS;
		}else {
			try {
				mealService.update(meal);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return SUCCESS;
			}
			return SUCCESS;
		}
	}

	public Meal getMeal() {
		return meal;
	}
	public void setMeal(Meal meal) {
		this.meal = meal;
	}



	public List<Dictionary> getMealStrutsList() {
		return mealStrutsList;
	}



	public void setMealStrutsList(List<Dictionary> mealStrutsList) {
		this.mealStrutsList = mealStrutsList;
	}

	
	
	
	
	
}

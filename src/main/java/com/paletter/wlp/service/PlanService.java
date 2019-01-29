package com.paletter.wlp.service;

import java.util.List;

import com.paletter.easy.web.server.annotation.WebMapping;
import com.paletter.wlp.dao.PlanDao;
import com.paletter.wlp.entity.Plan;

public class PlanService {

	@WebMapping("/plan/list")
	public static List<Plan> queryPlanList(String date) {
		Plan query = new Plan();
		query.setDate(date);
		return PlanDao.selectList(query);
	}
	
	@WebMapping("/plan/save")
	public void savePlan(Plan plan) {
		if (plan.getId() != null) {
			PlanDao.update(plan);
		} else {
			PlanDao.insert(plan);
		}
	}
	
	@WebMapping("/plan/delete")
	public void deletePlan(Integer id) {
		PlanDao.delete(id);
	}
}

package com.paletter.wlp.dao;

import java.sql.Connection;
import java.util.List;

import com.google.common.collect.Lists;
import com.paletter.easy.sql.EasyConnection;
import com.paletter.easy.sql.EasySql;
import com.paletter.wlp.entity.Plan;

public class PlanDao {

	public static List<Plan> selectList(Plan query) {
		
		List<Plan> resultList = Lists.newArrayList();
		
		try {
			
			Connection conn = EasyConnection.getConn();
			
			String sql = "select * from plan where date = ?";
			resultList = EasySql.queryList(conn, sql, Plan.class, query.getDate());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultList;
	}
	
	public static void insert(Plan plan) {
		
		Connection conn = EasyConnection.getConn();
		
		EasySql.insert(conn, plan, "plan");
	}
	
	public static void update(Plan plan) {
		
		Connection conn = EasyConnection.getConn();
		
		EasySql.update(conn, plan, "plan", "id=" + plan.getId());
	}
	
	public static void delete(int id) {

		Connection conn = EasyConnection.getConn();
		
		EasySql.delete(conn, "plan", "id=" + id);
	}
}

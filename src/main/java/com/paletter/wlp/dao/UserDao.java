package com.paletter.wlp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.google.common.collect.Lists;
import com.paletter.easy.sql.EasyConnection;
import com.paletter.wlp.entity.User;

public class UserDao {

	public static List<User> selectAll() {
		
		List<User> resultList = Lists.newArrayList();
		
		try {
			
			Connection conn = EasyConnection.getConn();
			
			Statement stat = conn.createStatement();
			String sql = "select * from `user`";
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String upwd = rs.getString(3);
				
				User user = new User();
				user.setId(id);
				user.setName(name);
				user.setPwd(upwd);
				resultList.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultList;
	}
	
	public static List<User> selectList(User query) {
		
		List<User> resultList = Lists.newArrayList();
		
		try {
			
			Connection conn = EasyConnection.getConn();
			
			String sql = "select * from `user` where name = ?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, query.getName());
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String upwd = rs.getString(3);
				
				User user = new User();
				user.setId(id);
				user.setName(name);
				user.setPwd(upwd);
				resultList.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultList;
	}
}

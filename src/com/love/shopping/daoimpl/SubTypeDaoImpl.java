package com.love.shopping.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.love.shopping.common.DbUtil;
import com.love.shopping.dao.SubTypeDao;
import com.love.shopping.po.SubType;

public class SubTypeDaoImpl implements SubTypeDao{

	public List<SubType> showAllSubTypeBySuperId(int superId) {
		List<SubType> subList = new ArrayList<SubType>();
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		DbUtil dbUtil = null;
		try {
			dbUtil = new DbUtil();
			String sql = "select * from tb_subType where superTypeId=?";
			pstmt = dbUtil.getCon().prepareStatement(sql);
			pstmt.setInt(1, superId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				SubType st = new SubType();
				st.setSubTypeId(rs.getInt(1));
				st.setSuperTypeId(rs.getInt(2));
				st.setTypeName(rs.getString(3));
				subList.add(st);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return subList;
	}
	
}

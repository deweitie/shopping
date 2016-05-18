package com.love.shopping.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.love.shopping.common.DbUtil;
import com.love.shopping.dao.SuperTypeDao;
import com.love.shopping.po.SuperType;

public class SuperTypeDaoImpl implements SuperTypeDao {

	public List<SuperType> showAllSuperType() {
		List<SuperType> superList = new ArrayList<SuperType>();
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		DbUtil dbUtil = null;
		try {
			dbUtil = new DbUtil();
			String sql = "select * from tb_superType";
			pstmt = dbUtil.getCon().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				SuperType st = new SuperType();
				st.setSuperTypeId(rs.getInt(1));
				st.setTypeName(rs.getString(2));
				superList.add(st);
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
		return superList;
	}
	
}

package com.love.shopping.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.love.shopping.common.DbUtil;
import com.love.shopping.dao.InformDao;
import com.love.shopping.po.Inform;

public class InformDaoImpl implements InformDao {

	public Inform getInformById(int informId) {
		Inform inform = new Inform();
		PreparedStatement pstmt = null;
		DbUtil dbUtil = null;
		ResultSet rs = null;
		String sql = "select * from tb_inform where informId=?";
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql);
			pstmt.setInt(1, informId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				inform.setInformId(rs.getInt("informId"));
				inform.setInformTitle(rs.getString(rs.getString("informTitle")));
				inform.setInformContent(rs.getString("informContent"));
				inform.setInformTime(rs.getString("informTime"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inform;
	}

	public List<Inform> showInformByInTime() {
		List<Inform> informList = new ArrayList<Inform>();
		return informList;
	}
	
}

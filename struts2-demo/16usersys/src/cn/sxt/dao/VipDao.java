package cn.sxt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.sxt.entity.Vip;
import cn.sxt.util.BaseDao;

public class VipDao extends BaseDao{
	public List<Vip> getList(){
		String sql="select * from t_vip";
		List<Vip> list = new ArrayList<Vip>();
		ResultSet rs = this.executeQuery(sql);
		try {
			while(rs.next()){
				list.add(new Vip(rs.getInt(1),rs.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return list.size()>0?list:null;
	}
	public Map<Integer,String> getMap(){
		String sql="select * from t_vip";
		Map<Integer,String> map= new HashMap<Integer,String>();
		ResultSet rs = this.executeQuery(sql);
		try {
			while(rs.next()){
				map.put(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return map.size()>0?map:null;
	}
}

package com.example.giftsystem.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.giftsystem.beans.CusInfo;
import com.example.giftsystem.beans.CusOrderInfo;
import com.example.giftsystem.beans.CusSelectLog;
import com.example.giftsystem.beans.ProductDateInfo;
import com.example.giftsystem.beans.ProductInfo;


@Repository
public class GiftSystemDao {
	
	@Qualifier("officialJdbcTemplate")
	@Autowired
	private JdbcTemplate jdbctemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedParameterjdbctemplate;


	public void saveCusSelectData(CusOrderInfo cusSelectData) {
		jdbctemplate.update("insert into cus_select_data(cus_id, product_id, product_status) values (?,?,?)",
				cusSelectData.getCus_id(), cusSelectData.getProduct_id(), "pre_order");
		
		jdbctemplate.update("insert into cus_select_log(cus_id, product_id, cus_option, exe_date) values (?,?,?,NOW())",
				cusSelectData.getCus_id(), cusSelectData.getProduct_id(), "pre_order");
		
	}
	
	
	public void saveDeliveryData(CusOrderInfo cusSelectData) {
		jdbctemplate.execute("commit;");
		jdbctemplate.update("update cus_select_data set cus_address = ?, cus_phone = ?, cus_email = ?, cus_deliver_date = ?,  product_status = ?"
				+ ", receive_time = ?, recipient = ?, cus_mobile = ?, cus_city = ? where cus_id = ? and product_id = ? and product_status = ? and id = ?",
				cusSelectData.getCus_address(), cusSelectData.getCus_phone(), cusSelectData.getCus_email(), new java.sql.Date(cusSelectData.getCus_deliver_date().getTime()), 
				"order_success", cusSelectData.getReceive_time(), cusSelectData.getRecipient(), cusSelectData.getCus_mobile(), cusSelectData.getCus_city()
				, cusSelectData.getCus_id(), cusSelectData.getProduct_id(), "pre_order", cusSelectData.getId());
		
		jdbctemplate.update("insert into cus_select_log(cus_id, product_id, cus_option, exe_date) values (?,?,?,NOW())",
				cusSelectData.getCus_id(), cusSelectData.getProduct_id(), "order_success");

	}
	
	public void updateDeliveryData(CusOrderInfo cusSelectData) {		
		jdbctemplate.update("update cus_select_data set cus_address = ?, cus_phone = ?, cus_email = ?, cus_deliver_date = ?"
				+ ", receive_time = ?, recipient = ?, cus_mobile = ?, cus_city = ? where cus_id = ? and product_id = ? and product_status = ? and id = ?",
				cusSelectData.getCus_address(), cusSelectData.getCus_phone(), cusSelectData.getCus_email(), new java.sql.Date(cusSelectData.getCus_deliver_date().getTime()), 
				cusSelectData.getReceive_time(), cusSelectData.getRecipient(), cusSelectData.getCus_city(), cusSelectData.getCus_city()
				, cusSelectData.getCus_id(), cusSelectData.getProduct_id(), "order_success", cusSelectData.getId());
		
		jdbctemplate.update("insert into cus_select_log(cus_id, product_id, cus_option, exe_date) values (?,?,?,NOW())",
				cusSelectData.getCus_id(), cusSelectData.getProduct_id(), "update_data");

	}

	
	public void cancelAllCusSelectData(String cus_id) {
		List<String> ids =jdbctemplate.query("select id from cus_select_data where cus_id = ? and not product_status = \"cancel\"", new OrderIdsMapper(), cus_id);
		jdbctemplate.update("update cus_select_data set product_status = ? where cus_id = ?",
				"cancel", cus_id);
		String all_id = "";
		for(String id : ids) {
			all_id = all_id + "," + id;
		}
		
		jdbctemplate.update("insert into cus_select_log(cus_id, product_id, cus_option, exe_date) values (?,?,?,NOW())",
				cus_id, all_id, "Cancel all datas");
	}
	private static class OrderIdsMapper implements RowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			String id = "" + rs.getInt("id");
			return id;
		}
	}
	public void cancelCusSelectData(String cus_id, int order_id) {
		jdbctemplate.update("update cus_select_data set product_status = ? where cus_id = ? and id = ?",
				"cancel", cus_id, order_id);
		jdbctemplate.update("insert into cus_select_log(cus_id, product_id, cus_option, exe_date) values (?,?,?,NOW())",
				cus_id, order_id, "cancel_data!");
	}
	
	public List<ProductInfo> getProductInfo() {
		
		List<ProductInfo> productInfos = jdbctemplate.query("select * from product_info order by price", new ProductInfoMapper());
		
		return productInfos;
	}

	public List<ProductDateInfo> getProductDateInfo() {
		
		List<ProductDateInfo> productDateInfos = jdbctemplate.query("select b.* from product_info as a, product_date_info b where a.product_id = b.product_id ",
				new ProductDateInfoMapper());
		
		return productDateInfos;
	}

	public ProductInfo getProductInfoById(String product_id) {
		
		List<ProductInfo> productInfos = jdbctemplate.query("Select * from product_info where product_id = ?", new ProductInfoMapper(), new Object[]{product_id});
		if (productInfos == null || productInfos.isEmpty()) {
			return null;
		}
		return productInfos.get(0);
	}
	
	public ProductDateInfo getProductDateInfoById(String product_id, java.util.Date product_date) {
		// for update  把這一筆資料鎖定 等 update 後 commit 才會放掉		
		jdbctemplate.execute("begin;");
		List<ProductDateInfo> productDateInfos = jdbctemplate.query("select * from product_date_info where product_id = ? and product_date = ? for update ",
				new ProductDateInfoMapper(), new Object[]{product_id, new java.sql.Date(product_date.getTime())});
		if (productDateInfos == null || productDateInfos.isEmpty()) {
			return null;
		}
		return productDateInfos.get(0);
	}
	
	public int updateProductInfoStock(ProductInfo productInfo) {
		int result = jdbctemplate.update("update product_info set product_stock = ? where product_id = ?"
				, new Object[]{productInfo.getProduct_stock(), productInfo.getProduct_id()});
		return result;
	}
	
	public int updateProductDateInfoStock(ProductDateInfo productDateInfo) {
		int result = jdbctemplate.update("update product_date_info set product_date_stock = ? where product_id = ? and product_date = ?"
				, new Object[]{productDateInfo.getProduct_date_stock(), productDateInfo.getProduct_id(), new java.sql.Date(productDateInfo.getProduct_date().getTime())});
		jdbctemplate.execute("commit;");		
		return result;
	}
	


	
	public List<String> getOrderProductIds(String cus_id) {
		List<String> product_ids;
		product_ids = jdbctemplate.query("select product_id from cus_select_data where cus_id = ?", 
					new ProductIdsMapper(), new Object[]{cus_id});		
		return product_ids;
	}
	
	public List<String> getPreOrderProductIds(String cus_id) {
		List<String> product_ids;
		product_ids = jdbctemplate.query("select product_id from cus_select_data where cus_id = ? and product_status = 'pre_order'", 
					new ProductIdsMapper(), new Object[]{cus_id});
		return product_ids;
	}
	private static class ProductIdsMapper implements RowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			String product_id = rs.getString("product_id");
			return product_id;
		}
	}

	public CusInfo getcusInfo(String cus_id) {
		
		List<CusInfo> cusInfos = jdbctemplate.query("select * from cus_info where cus_id = ?", new CusInfoMapper(), new Object[]{cus_id});
		if(cusInfos == null || cusInfos.isEmpty()) {
			return null;
		}
		
		return cusInfos.get(0);
	}
	
	public List<ProductDateInfo> getProductDateInfos(List<String> product_ids) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("ids", product_ids);
		List<ProductDateInfo> productDateInfos = namedParameterjdbctemplate.query("select * from product_date_info where product_id in (:ids)",
				parameters,new ProductDateInfoMapper());
		return productDateInfos;
	}
	
	public List<ProductInfo> getProductImages(String product_id) {	
		List<ProductInfo> productImages = jdbctemplate.query("select id,product_id,img_url from product_info where product_id = ?",
				new ProductImageMapper(), product_id);		
		return productImages;
	}
	
	public List<ProductInfo> getProductInfos(List<String> product_ids) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("ids", product_ids);

		System.out.println("data count : " + product_ids.size() + "  " + product_ids.get(0));
		
		List<ProductInfo> productInfos = namedParameterjdbctemplate.query("select * from product_info where product_id in (:ids)",
				parameters,new ProductInfoMapper());
		
		return productInfos;
	}
	
	public List<CusOrderInfo> getCusOrderInfo(String cus_id) {
		return jdbctemplate.query("select a.*,b.id as order_id,b.cus_id,b.cus_address,b.cus_phone,b.cus_email,b.cus_deliver_date,b.product_status"
				+ ",b.receive_time, b.recipient, b.cus_mobile, b.cus_city " + 
				" from product_info a , cus_select_data b where a.product_id = b.product_id and b.cus_id = ? and b.product_status != \"cancel\"", new CusOrderInfoMapper(), cus_id);
	}
	
	private static class CusOrderInfoMapper implements RowMapper<CusOrderInfo> {
		public CusOrderInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			CusOrderInfo cusOrderInfo = new CusOrderInfo();
			cusOrderInfo.setId(rs.getInt("id"));
			cusOrderInfo.setPorduct_total(rs.getInt("total"));
			cusOrderInfo.setProduct_name(rs.getString("product_name"));
			cusOrderInfo.setProduct_stock(rs.getInt("product_stock"));
			cusOrderInfo.setProduct_type(rs.getString("product_type"));
			cusOrderInfo.setImg_url(rs.getString("img_url"));
			cusOrderInfo.setSupplier(rs.getString("supplier"));
			cusOrderInfo.setProduct_id(rs.getString("product_id"));
			cusOrderInfo.setPrice(rs.getInt("price"));
			cusOrderInfo.setCus_address(rs.getString("cus_address"));
			cusOrderInfo.setCus_deliver_date(rs.getDate("cus_deliver_date"));
			cusOrderInfo.setCus_email(rs.getString("cus_email"));
			cusOrderInfo.setOrder_id(rs.getInt("order_id"));
			cusOrderInfo.setProduct_status(rs.getString("product_status"));
			cusOrderInfo.setCus_phone(rs.getString("cus_phone"));
			cusOrderInfo.setCus_id(rs.getString("cus_id"));
			cusOrderInfo.setReceive_time(rs.getString("receive_time"));
			cusOrderInfo.setRecipient(rs.getString("recipient"));
			cusOrderInfo.setCus_mobile(rs.getString("cus_mobile"));
			cusOrderInfo.setCus_city(rs.getString("cus_city"));

			return cusOrderInfo;
		}
	}
	
	private static class ProductInfoMapper implements RowMapper<ProductInfo> {
		public ProductInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProductInfo productInfo = new ProductInfo();
			productInfo.setId(rs.getInt("id"));
			productInfo.setPorduct_total(rs.getInt("total"));
			productInfo.setProduct_name(rs.getString("product_name"));
			productInfo.setProduct_stock(rs.getInt("product_stock"));			
			productInfo.setProduct_type(rs.getString("product_type"));
			productInfo.setImg_url(rs.getString("img_url"));
			productInfo.setSupplier(rs.getString("supplier"));
			productInfo.setProduct_id(rs.getString("product_id"));
			productInfo.setPrice(rs.getInt("price"));
		
			return productInfo;
		}
	}
		
	private static class CusInfoMapper implements RowMapper<CusInfo> {
		public CusInfo mapRow(ResultSet rs,int rowNum) throws SQLException {
			CusInfo cusInfo = new CusInfo();
			cusInfo.setId(rs.getInt("id"));
			cusInfo.setCus_id(rs.getString("cus_id"));
			cusInfo.setCus_points(rs.getInt("cus_points"));
			cusInfo.setCus_balance(rs.getInt("cus_balance"));
			cusInfo.setCus_company(rs.getString("cus_company"));
			

			return cusInfo;
		}
	}

	private static class ProductDateInfoMapper implements RowMapper<ProductDateInfo> {
		public ProductDateInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProductDateInfo productDateInfo = new ProductDateInfo();
			productDateInfo.setId(rs.getInt("id"));
			productDateInfo.setProduct_id(rs.getString("product_id"));
			productDateInfo.setProduct_date_stock(rs.getInt("product_date_stock"));
			productDateInfo.setProduct_date_total(rs.getInt("product_date_total"));
			productDateInfo.setProduct_date(rs.getDate("product_date"));
			productDateInfo.setProduct_display_date(rs.getString("product_display_date"));

			return productDateInfo;
		}
	}
	
	private static class ProductImageMapper implements RowMapper<ProductInfo> {
		public ProductInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProductInfo productImage = new ProductInfo();
			productImage.setId(rs.getInt("id"));
			productImage.setProduct_id(rs.getString("product_id"));
			productImage.setImg_url(rs.getString("product_image_url"));

			return productImage;
		}
	}

}

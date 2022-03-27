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
public class GiftSystemMgmtDao {
	
	@Qualifier("officialJdbcTemplate")
	@Autowired
	private JdbcTemplate jdbctemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedParameterjdbctemplate;
	//新增商品
	public void insertProductInfo(ProductInfo ProductInfo) {				
		jdbctemplate.update("insert into product_info(product_id, product_name, product_stock, porduct_total, product_type, img_url, supplier, price) values (?,?,?,?,?,?,?,?)",
				ProductInfo.getProduct_id(),ProductInfo.getProduct_name(),ProductInfo.getProduct_stock(),ProductInfo.getPorduct_total(),
				ProductInfo.getProduct_type(),ProductInfo.getImg_url(),ProductInfo.getSupplier(),ProductInfo.getPrice());
	}
	//獲取所有商品	
	public List<ProductInfo> getProductInfo() {		
		List<ProductInfo> productInfos = jdbctemplate.query("select * from product_info order by price", new ProductInfoMapper());		
		return productInfos;
	}
	//更新商品
	public void updateProductInfo(ProductInfo ProductInfo) {		
		jdbctemplate.update("update product_info set product_id = ?,product_name = ?,product_stock= ? ,porduct_total = ?,product_type = ?,img_url = ?,supplier = ?,price = ?"
				+ "where id = ?",ProductInfo.getProduct_id(),ProductInfo.getProduct_name(),ProductInfo.getProduct_stock(),ProductInfo.getPorduct_total(),
				ProductInfo.getProduct_type(),ProductInfo.getImg_url(),ProductInfo.getSupplier(),ProductInfo.getPrice(),ProductInfo.getId());		
	}
	//刪除商品
	public void deleteProductInfo(int id) {		
		jdbctemplate.update("delete from product_info where id = ?",id);		
	}
	
	//新增商品(Date)
	public void insertProductDateInfo(ProductDateInfo ProductDateInfo) {				
		jdbctemplate.update("insert into product_date_info(product_id, product_date_stock, product_date_total, product_date, product_display_date) values (?,?,?,?,?)",
				ProductDateInfo.getProduct_id(),ProductDateInfo.getProduct_date_stock(),ProductDateInfo.getProduct_date_total(),
				new java.sql.Date(ProductDateInfo.getProduct_date().getTime()),	new java.sql.Date(ProductDateInfo.getProduct_display_date().getTime()));
	}
	//獲取所有商品(Date)
	public List<ProductDateInfo> getProductDateInfo() {		
		List<ProductDateInfo> ProductDateInfos = jdbctemplate.query("select * from product_date_info order by product_date", new ProductDateInfoMapper());		
		return ProductDateInfos;
	}
	//更新商品(Date)
	public void updateProductDateInfo(ProductDateInfo ProductDateInfo) {		
		jdbctemplate.update("update product_date_info set product_id = ?,product_date_stock = ?,product_date_total= ? ,product_date = ?,product_display_date = ? "
				+ "where id = ?",ProductDateInfo.getProduct_id(),ProductDateInfo.getProduct_date_stock(),ProductDateInfo.getProduct_date_total(),
				new java.sql.Date(ProductDateInfo.getProduct_date().getTime()),	new java.sql.Date(ProductDateInfo.getProduct_display_date().getTime()),ProductDateInfo.getId());		
	}
	//刪除商品(Date)
	public void deleteProductDateInfo(int id) {		
		jdbctemplate.update("delete from product_date_info where id = ?",id);		
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

	private static class ProductDateInfoMapper implements RowMapper<ProductDateInfo> {
		public ProductDateInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProductDateInfo productDateInfo = new ProductDateInfo();
			productDateInfo.setId(rs.getInt("id"));
			productDateInfo.setProduct_id(rs.getString("product_id"));
			productDateInfo.setProduct_date_stock(rs.getInt("product_date_stock"));
			productDateInfo.setProduct_date_total(rs.getInt("product_date_total"));
			productDateInfo.setProduct_date(rs.getDate("product_date"));
			productDateInfo.setProduct_display_date(rs.getDate("product_display_date"));

			return productDateInfo;
		}
	}


}

package org.jeet.work.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jeet.work.model.ContactDetail;

public class ContactDetailDAO {

	public Connection getConnection() throws ClassNotFoundException {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:CONTACT.db";
			conn = DriverManager.getConnection(url);
			return conn;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public void createTable() throws Exception {
		try {
			String sql = "CREATE TABLE IF NOT EXISTS contact_detail ( id INTEGER PRIMARY KEY AUTOINCREMENT, firstname TEXT NOT NULL, lastname TEXT NOT NULL, email TEXT NOT NULL, phone TEXT NOT NULL )";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.execute();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	// Check table
	public String checkTable(String tableName) throws Exception {
		String result = null;
		try {
			String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, tableName);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					result = rs.getString(1);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			result = null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
		return result;
	}

	public int saveContact(ContactDetail contactDetail) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO contact_detail (firstname, lastname, email, phone) VALUES (?,?,?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, contactDetail.getFirstname());
			ps.setString(2, contactDetail.getLastname());
			ps.setString(3, contactDetail.getEmail());
			ps.setString(4, contactDetail.getPhone());
			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
		return i;
	}

	public List<ContactDetail> getAllContact() throws Exception {
		List<ContactDetail> contactDetailsList = new ArrayList<ContactDetail>();
		try {
			String sql = "SELECT * FROM contact_detail";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					ContactDetail contactDetail = new ContactDetail();
					contactDetail.setId(rs.getLong(1));
					contactDetail.setFirstname(rs.getString(2));
					contactDetail.setLastname(rs.getString(3));
					contactDetail.setEmail(rs.getString(4));
					contactDetail.setPhone(rs.getString(5));
					contactDetailsList.add(contactDetail);
				}
			}
			return contactDetailsList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	public ContactDetail getContactByID(long id) throws Exception {
		ContactDetail contactDetail = new ContactDetail();
		try {
			String sql = "SELECT * FROM contact_detail WHERE id=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					contactDetail.setId(rs.getLong(1));
					contactDetail.setFirstname(rs.getString(2));
					contactDetail.setLastname(rs.getString(3));
					contactDetail.setEmail(rs.getString(4));
					contactDetail.setPhone(rs.getString(5));
				}
			}
			return contactDetail;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	public int updateContact(ContactDetail contactDetail) throws Exception {
		getConnection().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "UPDATE contact_detail SET firstname=?,lastname=?,email=?,phone=? WHERE id=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, contactDetail.getFirstname());
			ps.setString(2, contactDetail.getLastname());
			ps.setString(3, contactDetail.getEmail());
			ps.setString(4, contactDetail.getPhone());
			ps.setLong(5, contactDetail.getId());
			i = ps.executeUpdate();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
			return i;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	public int deleteContact(long id) throws Exception {
		getConnection().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "DELETE FROM contact_detail WHERE id=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, id);
			i = ps.executeUpdate();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
			return i;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
}

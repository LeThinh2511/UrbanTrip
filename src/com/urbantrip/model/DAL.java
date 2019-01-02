package com.urbantrip.model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Driver;
import com.urbantrip.define.Define;

public class DAL {
	Connection conn;
	Statement stsm;
	
	public DAL () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/urbantrip", "root", Define.databasePassword);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public ResultSet getData(String sql) {
		stsm = null;
		try {
			stsm = conn.createStatement();
			return stsm.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateData(String sql) {
		stsm = null;
		try {
			stsm = conn.createStatement();
			return stsm.executeUpdate(sql) > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public ResultSet getListUser() {
		return this.getData("select * from urbantrip.user");
		
	}
	
	public boolean validateUser(User user) {
		String sql = "select * from User where email = '" + user.email + "'";
		try {
			stsm = conn.createStatement();
			ResultSet rs = stsm.executeQuery(sql);
			while (rs.next()) {
				String password = rs.getString(4);
				if (password.equals(user.password)) {
					return true;
				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Destination> getAllDestination() {
		ArrayList<Destination> allDestinations = new ArrayList<>();
		String sql = "select * from Destination";
		try {
			stsm = conn.createStatement();
			ResultSet rs = stsm.executeQuery(sql);
			while (rs.next()) {
				int idDestination = Integer.parseInt(rs.getString(1));
				int idTour = Integer.parseInt(rs.getString(3));
				String name = rs.getString(2);
				int idImage = rs.getInt(4);
				System.out.println("id image: " + idImage);
				Destination newDestination = new Destination(idDestination, idTour, name, idImage);
				allDestinations.add(newDestination);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allDestinations;
	}
	
	public Destination getDestination(int id) {
		Destination destination = null;
		String sql = "select * from Destination where id_destination = " + String.valueOf(id);
		try {
			stsm = conn.createStatement();
			ResultSet rs = stsm.executeQuery(sql);
			while (rs.next()) {
				int idDestination = Integer.parseInt(rs.getString(1));
				int idTour = Integer.parseInt(rs.getString(3));
				String name = rs.getString(2);
				int idImage = rs.getInt(4);
				destination = new Destination(idDestination, idTour, name, idImage);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return destination;
	}

	public void updateDestination(Destination destination) {
		String sql = "UPDATE Destination SET name='" + destination.getName() + "', id_tour=" + destination.getIdTour() + " WHERE id_destination=" + destination.getIdDestination();
		System.out.println(sql);
		try {
			stsm = conn.createStatement();
			int rs = stsm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int deleteDestination(int idDestination) {
		String sql = "DELETE FROM Destination WHERE id_destination=" + idDestination;
		System.out.println(sql);
		int count = 0;
		try {
			stsm = conn.createStatement();
			count = stsm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
	public int addDestination(Destination destination) {
		int row = 0;
		String sql = "insert into destination (name, id_tour, id_image) values (?, ?, ?)";
		try {
			PreparedStatement pstmtSave = conn.prepareStatement(sql);
			pstmtSave.setString(1, destination.getName());
			pstmtSave.setInt(2, destination.getIdTour());
			pstmtSave.setInt(3, destination.getIdImage());
			row = pstmtSave.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
	public byte[] getImage(int id) {
		byte[] content = null;
		String sql = "select * from Image where idImage = " + String.valueOf(id);
		try {
			stsm = conn.createStatement();
			ResultSet rs = stsm.executeQuery(sql);
			while (rs.next()) {
				content = rs.getBytes("image");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (content == null) {
			System.out.println("get image null");
		}
		return content;
	}
	
	public int addImage(InputStream inputStream, int idImage) {
		int row = 0;
		String sql = "insert into image (image, idImage) values (?, ?)";
		try {
			PreparedStatement pstmtSave = conn.prepareStatement(sql);
			pstmtSave.setBlob(1, inputStream);
			pstmtSave.setInt(2, idImage);
			row = pstmtSave.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
	public ArrayList<byte[]> getAllImages() {
		ArrayList<byte[]> images = new ArrayList<>();
		byte[] content = null;
		String sql = "select * from Image";
		try {
			stsm = conn.createStatement();
			ResultSet rs = stsm.executeQuery(sql);
			while (rs.next()) {
				content = rs.getBytes("image");
				images.add(content);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (content == null) {
			System.out.println("get image null");
		}
		return images;
	}
	
	public int getMaxImageID() {
		int id = 0;
		String sql = "SELECT * FROM Image ORDER BY idImage DESC LIMIT 1";
		try {
			stsm = conn.createStatement();
			ResultSet rs = stsm.executeQuery(sql);
			while (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

}
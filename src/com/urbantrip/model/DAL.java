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
	private PreparedStatement pst;

	public DAL() {
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

	public ArrayList<Tour> getAllTour() {
		ArrayList<Tour> allTours = new ArrayList<>();
		String sql = "select * from Tour";
		try {
			stsm = conn.createStatement();
			ResultSet rs = stsm.executeQuery(sql);
			while (rs.next()) {
				String idTour = rs.getString(1);
				String name = rs.getString(2);
				String description = rs.getString(3);
				Double price = Double.parseDouble(rs.getString(4));
				String type = rs.getString(5);
				String imagePath = rs.getString(6);
				Boolean isDeleted = Integer.parseInt(rs.getString(7)) == 0 ? false : true;
				allTours.add(new Tour(idTour, name, description, price, type, imagePath, isDeleted));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allTours;
	}

	public boolean deleleTour(int id) throws SQLException {
//		String sql = "Delete from urbantrip.tour where id_tour =" + id;
		String sql = "DELETE FROM urbantrip.tour where id_tour =?";
		pst = conn.prepareStatement(sql);
		pst.setInt(1, id);

		return pst.executeUpdate() > 0;

	}

	public int addNewTour(Tour tour) {
		String sql = "INSERT INTO urbantrip.tour(name, description, price, type) VALUE(?,?,?,?)";
		int kq = 0;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, tour.getName());
			pst.setString(2, tour.getDescription());
			pst.setDouble(3, tour.getPrice());
			pst.setString(4, tour.getType());
			kq = pst.executeUpdate();

			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return kq;
	}

	public int editTour(Tour tour, int id) {
		String sql = "UPDATE urbantrip.tour set name = ?, description = ?, price = ?, type=? WHERE id_tour =?";
		int kq = 0;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, tour.getName());
			pst.setString(2, tour.getDescription());
			pst.setDouble(3, tour.getPrice());
			pst.setString(4, tour.getType());
			pst.setInt(5, id);
			kq = pst.executeUpdate();

			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return kq;
	}
	
	public int addNewTrip(Trip trip) {
		String sql = "INSERT INTO urbantrip.trip(tourist,numberOfParticipants,nationality,phone,email,hotelAddress,id_tour,message) VALUE(?,?,?,?,?,?,?,?)";
		int kq = 0;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, trip.getTouristName());
			pst.setString(2, trip.getNumberOfParticipants());
			pst.setString(3, trip.getNationality() );
			pst.setString(4, trip.getPhone() );
			pst.setString(5, trip.getEmail() );
			pst.setString(6, trip.getHotelAddress() );
			pst.setInt(7, trip.getId_tour() );
			pst.setString(8, trip.getMessage() );
			
			
			kq = pst.executeUpdate();

			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return kq;
	}

}
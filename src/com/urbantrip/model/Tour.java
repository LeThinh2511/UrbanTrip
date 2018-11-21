package com.urbantrip.model;

import java.sql.ResultSet;

public class Tour {
	DAL dal;
	
	public Tour () {
		dal = new DAL();
	}
	
	public ResultSet getListTour() {
		return dal.getData("select * from urbantrip.tour");
	}

}

package ServicesForm;

import JavaBeans.Questions; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Question_Dao {
	static Connection cnx = null;
	public static void   startConnection() {
	  try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/Qcm", "root", "");
	  }catch(Exception e) {
		System.out.println(e);
	  }
	}
	
	public static List<Qestions> getQuestions(int idForm) {
		List<Qestions> lsquest = new ArrayList<Qestions>();
		try {
			startConnection();
			String sql = "select * from question where idForm=?";
			PreparedStatement sp =  cnx.prepareStatement(sql);
			sp.setInt(1, idForm);
			ResultSet rs =sp.executeQuery();
			while(rs.next()) {
				Questions qi = new Questions();
			      qi.setIdQ(rs.getInt(1));
			      qi.setIdForm(rs.getInt(2));
			      qi.setLibQ(rs.getString(3));
			      
			    lsquest.add(qi);
			}
			cnx.close();
		}catch(Exception e1) {System.out.println(e1);}
		return lsquest;
	}
	
	
	}
	
	



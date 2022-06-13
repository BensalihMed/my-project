package ServicesForm;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import JavaBeans.Repons;

public class Reponse_Dao {
	static Connection cnx = null;
	public static void   startConnection() {
	  try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/Qcm", "root", "");
	  }catch(Exception e) {
		System.out.println(e);
	  }
	}
	
	public static List<Repons> getReponseFor(int idQuestion) {
		List<Repons> lsreponse = new ArrayList<Repons>();
		try {
			startConnection();
			String sql = "select * from reponse where idQ=?";
			PreparedStatement sp =  cnx.prepareStatement(sql);
			sp.setInt(1, idQuestion);
			ResultSet rs =sp.executeQuery();
			while(rs.next()) {
				Repons rep = new Repons();
				
				rep.setIdRe(rs.getInt(1));
				rep.setIdQ(rs.getInt(2));
			      rep.setLibRe(rs.getString(3));
			      //re.setCorrect(rs.getBoolean(4));
			      lsreponse.add(rep);
			}
			cnx.close();
		}catch(Exception e1) {System.out.println(e1);}
		return lsreponse;
	}
	
}




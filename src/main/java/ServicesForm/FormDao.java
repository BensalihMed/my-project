package ServicesForm;
import JavaBeans.Formulaire;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FormDao {
	static Connection cnx = null;
	public static void   startConnection() {
	  try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/Qcm", "root", "");
	  }catch(Exception e) {
		System.out.println(e);
	  }
	}
	public static List<Formulaire> getReponseFor(int idQ) {
		List<Formulaire> lsform = new ArrayList<Formulaire>();
		try {
			startConnection();
			String sql = "select * from formulaires";
			PreparedStatement st =  cnx.prepareStatement(sql);
			st.setInt(1, idQ);
			ResultSet rs =st.executeQuery();
			while(rs.next()) {
				Formulaire forme = new Formulaire();
				
				forme.setIdForm(rs.getInt(1));
				forme.setLib_form(rs.getString(2));
				lsform.add(forme);
			}
			cnx.close();
		}catch(Exception e1) {System.out.println(e1);}
		return lsform;
	}

}

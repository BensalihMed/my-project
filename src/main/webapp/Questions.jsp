<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="ServicesForm.*,JavaBeans.*,java.util.*"%>
    <jsp:useBean  id="form" class="JavaBeans.Formulaire"  scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Insert title here </title>
</head>
<body>
<%! List<Questions> listq = new ArrayList<Questions>(); 
   List<Repons> listr = new ArrayList<Repons>();
    String question; String reponse;%>
   <%
     listq = Question_Dao.getQuestions(Formulaire.getId_form());
     for( Questions q : listq){
   %>
	 <%= q.getIdQ()%><b><%= q.getLibQ())%></b><br/>
	  <form action="" method="get">
	   <% 
	     listr =dao_reponse.getReponseFor(q.getIdQ()); 
	     for(Repons r : listr){ 
	   %>
		   <input type="radio" name="repQ<%=q.getIdQ() %>" value="<%=r.getIdRe()%>"><label><%= r.getLibRe() %> </label><br/>
	  <% } %> 
	   </form>
   <% } %>


</body>
</html>
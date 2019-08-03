import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.util.*;

public class Updateinfo extends HttpServlet 
{
public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
{

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String a=request.getParameter("cell");
		String n=request.getParameter("updatenew");
		String b=request.getParameter("ycardno");
		System.out.println(a);
		System.out.println(n);
		System.out.println(b);
		
		try
               {
		
	
                Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		Statement st=con.createStatement();
		ResultSet rs11 =st.executeQuery("select *from bank where CARD_NUMBER='"+ b +"'");			
		if(rs11.next())
		{
		if(a.equals("Addhar")){
		int i=st.executeUpdate("Update bank set ADDHAR='"+ n +"' where CARD_NUMBER='"+ b +"'");		
		if(i>0){
			out.println("<script type=\"text/javascript\">");
			out.println("alert('"+a+" Credentials Updatation Successfully');");
			out.println("location='/Bank2/updateinfo.html';");
			out.println("</script>");
		
		//RequestDispatcher dispatcher=request.getRequestDispatcher("index.html");
			//dispatcher.include(request,response);
		//out.println("");	
			}}
		if(a.equals("Mobile")){
		int i=st.executeUpdate("Update bank set MOBILE='"+ n +"' where CARD_NUMBER='"+ b +"'");
		//System.out.println(i);
		//String getID=null,To=null;		
		if(i>0){
			out.println("<script type=\"text/javascript\">");
			out.println("alert('"+a+" Credentials Updatation Successfully');");
			out.println("location='/Bank2/updateinfo.html';");
			out.println("</script>");
		
		//RequestDispatcher dispatcher=request.getRequestDispatcher("index.html");
			//dispatcher.include(request,response);
		out.println("");	
			}}
			if(a.equals("PAN_Number")){
		int i=st.executeUpdate("Update bank set PAN_Number='"+ n +"' where CARD_NUMBER='"+ b +"'");
		//System.out.println(i);
		//String getID=null,To=null;		
		if(i>0){
		//out.println("******Update Successfully******");
		out.println("<script type=\"text/javascript\">");
   		out.println("alert('"+a+" Credentials Updatation Successfully');");
   		out.println("location='/Bank2/updateinfo.html';");
   		out.println("</script>");
		//RequestDispatcher dispatcher=request.getRequestDispatcher("updateinfo.html");
			//dispatcher.include(request,response);
		out.println("");	
			}}
		}
		else
			{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Credential Not Match');");
			out.println("location='/Bank2/updateinfo.html';");
			out.println("</script>");
			}
					}              
		catch (Exception e2) 
               {
               System.out.println(e2);
               }
		
	
	out.close();


	}

}

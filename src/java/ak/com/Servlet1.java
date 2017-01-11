
package ak.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Servlet1", urlPatterns = {"/Servlet1"})
public class Servlet1 extends HttpServlet {

   public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
          PrintWriter out = response.getWriter();
      
      out.print("hello");
        try{
  Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","user1","password");
 
  PreparedStatement ps2=con.prepareStatement("select * from bind");//to select data from log table
                
  ResultSet rs1=ps2.executeQuery();
                
              
         
                
                
                
                while(rs1.next())
                  {
                      
                       
                        String qno=rs1.getString("ph"); 
                        String q=rs1.getString("id"); 
//                        String a=rs1.getString("answered"); 
//                        String s=rs1.getString("setno"); 
                        
                        out.println(qno);
                        out.println("       ");
                        out.println(q);
//                        out.println("       ");
//                        out.println(a);
//                         out.println("       ");
//                        out.println(s);
//                        out.println("       ");
                  }
        
       
            
              
        }
        
     
        
        
       
        catch(Exception e)
        {
            System.err.println(e);
        }
        }
        }
    

package dtcookie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
	
	@Autowired
	private DataSource dataSource; 
	
	@GetMapping("/")
    public @ResponseBody String sayHello() {
		try {
		    try (Connection con = dataSource.getConnection();
		        PreparedStatement pst = con.prepareStatement("select * from people");
		        ResultSet rs = pst.executeQuery();) {
		            while ( rs.next() ) {
		            	rs.getString("name");
		            }
			} 		
		} catch (Throwable t) {
			t.printStackTrace(System.err);
		}
        return "hello";
    }
}

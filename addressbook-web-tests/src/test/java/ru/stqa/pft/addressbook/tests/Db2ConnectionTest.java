package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.Contacts;


import java.sql.*;

public class Db2ConnectionTest {

    @Test
    public void testDb2Connection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=" +"&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select id,firstname,middlename,lastname from addressbook");
            Contacts contacts = new Contacts();
            while ((rs.next())){
                contacts.add(new ContactDate().withtId(rs.getInt("id")).withFistname(rs.getString("firstname"))
                        .withMiddlename(rs.getString("middlename")).withLastname(rs.getString("lastname")));
            }



            rs.close();
            st.close();
            conn.close();
            System.out.print(contacts);
            // Do something with the Connection


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}

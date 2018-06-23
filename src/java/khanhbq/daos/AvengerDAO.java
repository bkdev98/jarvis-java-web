package khanhbq.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import khanhbq.conn.DBConnection;
import khanhbq.dtos.AvengerDTO;

public class AvengerDAO implements Serializable {

    public AvengerDAO() {
    }
    
    public AvengerDTO checkLogin(String loginName, String password) throws Exception {
        AvengerDTO dto = null;
        try (Connection conn = DBConnection.getDBConnection()) {
            String sql = "SELECT ID, RealName, MadeUpName, AvatarUrl, Abilities, Role "
                    + "FROM Avenger WHERE LoginName = ? AND Password = ?";
            PreparedStatement preStm = conn.prepareStatement(sql);
            preStm.setString(1, loginName);
            preStm.setString(2, password);
            try (ResultSet rs = preStm.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("ID");
                    String realName = rs.getString("RealName");
                    String madeUpName = rs.getString("MadeUpName");
                    String avatarUrl = rs.getString("AvatarUrl");
                    String abilities = rs.getString("Abilities");
                    String role = rs.getString("Role");
                    dto = new AvengerDTO(id, loginName, realName, madeUpName, avatarUrl, abilities, role);
                }
            }
        }
        return dto;
    }
}

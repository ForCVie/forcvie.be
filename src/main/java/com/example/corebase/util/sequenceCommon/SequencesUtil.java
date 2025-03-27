package com.example.corebase.util.sequenceCommon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class SequencesUtil {

    private static final Logger logger = LoggerFactory.getLogger(SequencesUtil.class);

    @Autowired
    private DataSource dataSource;

    public String generateSequence(String prefix, String tableName) {
        String resultSeq = null;
        try (Connection connection = dataSource.getConnection()) {
            String selectQuery = "SELECT last_num FROM cps_seq_mng WHERE tbl_name = ?";
            PreparedStatement selectStmt = connection.prepareStatement(selectQuery);
            selectStmt.setString(1, tableName);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                long lastNum = rs.getLong("last_num") + 1;
                String updateQuery = "UPDATE cps_seq_mng SET last_num = ? WHERE tbl_name = ?";
                PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
                updateStmt.setLong(1, lastNum);
                updateStmt.setString(2, tableName);
                updateStmt.executeUpdate();
                resultSeq = prefix + String.format("%015d", lastNum);
            } else {
                String insertQuery = "INSERT INTO cps_seq_mng (tbl_name, last_num, prefix) VALUES (?, 1, ?)";
                PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
                insertStmt.setString(1, tableName);
                insertStmt.setString(2, prefix);
                insertStmt.executeUpdate();
                resultSeq = prefix + "000000000000001";
            }
        } catch (SQLException e) {
            logger.error("Error while generating sequence for table {}: {}", tableName, e.getMessage(), e);
        }

        return resultSeq;
    }
}

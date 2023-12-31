package com.openbanking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.openbanking.dto.BoardDto;

public class BoardDao {
	DataSource dataSource;
	
	public BoardDao() {
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<BoardDto> list() {
		
		
		ArrayList<BoardDto> boarddtos = new ArrayList<BoardDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select bId, bWid, bTitle, bContent, bDate, bHit, bTopic from board01";
			preparedStatement = connection.prepareCall(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int bId = resultSet.getInt("bId");
				String bWid = resultSet.getString("bWid");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				String bTopic = resultSet.getString("bTopic");
				
				BoardDto boarddto = new BoardDto(bId, bWid, bTitle, bContent, bDate, bHit, bTopic);
				/*와일문을 돌리면서 하나씩 하나씩 추가*/
				boarddtos.add(boarddto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				/*설정한 값 해체*/
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return boarddtos;
	}
}

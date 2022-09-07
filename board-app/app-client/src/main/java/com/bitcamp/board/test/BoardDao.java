package com.bitcamp.board.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
  private final String Url = "jdbc:mariadb://localhost:3306/studydb?user=study&password=1111";


  public List<Board> findAll() throws Exception {
    try(Connection con = DriverManager.getConnection(Url);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from x_board")) {

      ArrayList<Board> list = new ArrayList<>();
      while (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("board_id"));
        board.setTitle(rs.getString("title"));
        board.setContent(rs.getString("contents"));
        board.setRegisteredDate(rs.getDate("created_date"));
        board.setViewCount(rs.getInt("view_count"));
        list.add(board);
      }
      return list;
    }
  }

  public Board findBy(String no) throws Exception {
    try(Connection con = DriverManager.getConnection(Url);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select board_id,title,contents from x_board where board_id=" + no)) {

      if (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("board_id"));
        board.setTitle(rs.getString("title"));
        board.setContent(rs.getString("contents"));
        board.setRegisteredDate(rs.getDate("created_date"));
        board.setViewCount(rs.getInt("view_count"));
        return board;
      } else {
        return null;
      }
    }
  }

  public int insert(Board board) throws Exception {
    try(Connection con = DriverManager.getConnection(Url);
        Statement stmt = con.createStatement()) {
      String sql = String.format("insert into x_board(title,contents) value(%s,%s);", board.getTitle(), board.getContent());
      return stmt.executeUpdate(sql);      
    }
  }

  public int update(Board board) throws Exception {
    try(Connection con = DriverManager.getConnection(Url);
        Statement stmt = con.createStatement()) {
      String sql = String.format("update x_board set title=%s,contents=%s where board_id=%d", board.getTitle(), board.getContent(), board.getNo());
      return stmt.executeUpdate(sql);
    }
  }

  public int delete(int no) throws Exception {
    try(Connection con = DriverManager.getConnection(Url);
        Statement stmt = con.createStatement()) {
      stmt.executeUpdate("delete from x_board_file where board_id=" + no);
      return stmt.executeUpdate("delete from x_board where board_id=" + no);
    }
  }
}


package com.uniyaz.db;

import com.uniyaz.domian.Rehber;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AKARTAL on 3.3.2021.
 */
public class DbOperations {

    public void rehbbereEkle(String isim, String telefon) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO PERSONEL (ISIM, TELEFON) VALUE ('%s', '%s')";
        sql = String.format(sql, isim, telefon);

        try (
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/telefon?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false", "root", "Bayburt69*");
                PreparedStatement preparedStatement = con.prepareStatement(sql);
        ) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Rehber> rehberiGetir() {

        List<Rehber> rehberList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "SELECT * FROM PERSONEL";

        try (
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/telefon?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false", "root", "Bayburt69*");
                PreparedStatement preparedStatement = con.prepareStatement(sql);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String isim = resultSet.getString("ISIM");
                String telefon = resultSet.getString("TELEFON");
                Rehber rehber = new Rehber(id, isim, telefon);
                rehberList.add(rehber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rehberList;
    }

    public int kisiSil(String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/telefon?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false", "root", "Bayburt69*");


            String query = "DELETE FROM PERSONEL where id=?";

            PreparedStatement psmt = conn.prepareStatement(query);
            psmt.setString(1, id);
            return psmt.executeUpdate();

        }catch (Exception e) {
            e.printStackTrace();
        }

        return 0;


    }

    public int kisiGuncelle(int id,String isim,String telefon) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/telefon?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false", "root", "Bayburt69*");

            String query = "UPDATE PERSONEL SET isim=?,telefon=? where id=?";

            PreparedStatement psmt = conn.prepareStatement(query);
            psmt.setString(1, String.valueOf(id));
            psmt.setString(1,isim);
            psmt.setString(2,telefon);
            return psmt.executeUpdate();


        }catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }



}
package ru.sapteh;

import ru.sapteh.connection.ConnectionUtil;
import ru.sapteh.dao.MainDao;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main implements MainDao {

    static Connection conn = ConnectionUtil.getConnection();

    public static void main(String[] args) throws IOException, SQLException {

        Main main = new Main();

        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Что хотите сделать?");
            System.out.println("[c,u,d]");
            String crudSelect = bf.readLine();

            if (crudSelect.equals("c")){
                main.create();
            }
            if (crudSelect.equals("u")){
                main.update();
            }
            if (crudSelect.equals("d")){
                main.delete();
            }
        }
    }

    public void writeFile(){
        try {
            String fileName = "ConfigPc.txt";
            List<ConfigPc> list = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(SELECT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                list.add(new ConfigPc(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)));
            }
            File file = new File(fileName);
            file.createNewFile();
            try(FileWriter fw = new FileWriter(fileName)) {
                for (ConfigPc configPc : list) {
                    fw.write(configPc.toString());
                }
            }
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    public void create(){
        try {
            try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
                System.out.println("Введите modelCPU");
                String modelCPU = bf.readLine();
                System.out.println("Введите ram");
                String ram = bf.readLine();
                System.out.println("Введите hdd");
                String hdd = bf.readLine();
                System.out.println("Введите powerSupply");
                String powerSupply = bf.readLine();

                PreparedStatement statement = conn.prepareStatement(CREATE);
                statement.setString(1, modelCPU);
                statement.setString(2, ram);
                statement.setString(3, hdd);
                statement.setString(4, powerSupply);
                statement.executeUpdate();
                writeFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update() {
        try {
            try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))){
                System.out.println("Введите id изменения");
                int id = Integer.parseInt(bf.readLine());
                System.out.println("Введите modelCPU");
                String modelCPU = bf.readLine();
                System.out.println("Введите ram");
                String ram = bf.readLine();
                System.out.println("Введите hdd");
                String hdd = bf.readLine();
                System.out.println("Введите powerSupply");
                String powerSupply = bf.readLine();

                PreparedStatement statement = conn.prepareStatement(UPDATE);
                statement.setString(1, modelCPU);
                statement.setString(2, ram);
                statement.setString(3, hdd);
                statement.setString(4, powerSupply);
                statement.setInt(5, id);
                statement.executeUpdate();
                writeFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete() {
        try {
            try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))){
                System.out.println("Введите id удаления");
                int id = Integer.parseInt(bf.readLine());

                PreparedStatement statement = conn.prepareStatement(DELETE);
                statement.setInt(1, id);
                statement.executeUpdate();
                writeFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

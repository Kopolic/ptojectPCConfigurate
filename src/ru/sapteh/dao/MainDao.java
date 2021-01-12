package ru.sapteh.dao;

import ru.sapteh.ConfigPc;

public interface MainDao {
    String SELECT = String.format("SELECT * FROM %s", ConfigPc.TABLE_NAME);
    String CREATE = String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES (?, ?, ?, ?)",
            ConfigPc.TABLE_NAME, ConfigPc.MODEL_CPU, ConfigPc.RAM, ConfigPc.HDD, ConfigPc.POWER_SUPPLY);
    String UPDATE = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ? WHERE (%s = ?)",
            ConfigPc.TABLE_NAME, ConfigPc.MODEL_CPU, ConfigPc.RAM, ConfigPc.HDD, ConfigPc.POWER_SUPPLY, ConfigPc.ID);
    String DELETE = String.format("DELETE FROM %s WHERE (%s = ?)", ConfigPc.TABLE_NAME, ConfigPc.ID);

    void writeFile();
    void create();
    void update();
    void delete();
}

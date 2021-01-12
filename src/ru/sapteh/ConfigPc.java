package ru.sapteh;

import java.util.Objects;

public class ConfigPc {

    static public final String TABLE_NAME = "configuratepc";
    static public final String ID = "id";
    static public final String MODEL_CPU = "modelCPU";
    static public final String RAM = "ram";
    static public final String HDD = "hdd";
    static public final String POWER_SUPPLY = "powerSupply";

    private int id;
    private String modelCPU;
    private String ram;
    private String hdd;
    private String powerSupply;

    public ConfigPc(){

    }
    public ConfigPc(int id, String modelCPU, String ram, String hdd, String powerSupply) {
        this.id = id;
        this.modelCPU = modelCPU;
        this.ram = ram;
        this.hdd = hdd;
        this.powerSupply = powerSupply;
    }

    public int getId() {
        return id;
    }
    public String getModelCPU() {
        return modelCPU;
    }
    public String getRam() {
        return ram;
    }
    public String getHdd() {
        return hdd;
    }
    public String getPowerSupply() {
        return powerSupply;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setModelCPU(String modelCPU) {
        this.modelCPU = modelCPU;
    }
    public void setRam(String ram) {
        this.ram = ram;
    }
    public void setHdd(String hdd) {
        this.hdd = hdd;
    }
    public void setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %s %s\n",getId(),getModelCPU(),getRam(),getHdd(),getPowerSupply());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfigPc configPc = (ConfigPc) o;
        return id == configPc.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

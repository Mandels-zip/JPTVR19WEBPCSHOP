/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author pupil
 */
@Entity
public class Computer implements Serializable { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;
    private String model;
    private String procmodel;
    private String videocard;
    private String ram;
    private String soundboard;
    private String harddrive;
    private String ssd;
    private String power;
    private int price;
    private int quantity;
    private int discount;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date discountDate;
    private int discountDuration;
    public Computer() {
    }

    public Computer(String manufacturer, String model, String procmodel, String videocard, String ram, String soundboard, String harddrive, String ssd, String power, int price, int quantity) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.procmodel = procmodel;
        this.videocard = videocard;
        this.ram = ram;
        this.soundboard = soundboard;
        this.harddrive = harddrive;
        this.ssd = ssd;
        this.power = power;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProcmodel() {
        return procmodel;
    }

    public void setProcmodel(String procmodel) {
        this.procmodel = procmodel;
    }

    public String getVideocard() {
        return videocard;
    }

    public void setVideocard(String videocard) {
        this.videocard = videocard;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getSoundboard() {
        return soundboard;
    }

    public void setSoundboard(String soundboard) {
        this.soundboard = soundboard;
    }

    public String getHarddrive() {
        return harddrive;
    }

    public void setHarddrive(String harddrive) {
        this.harddrive = harddrive;
    }

    public String getSsd() {
        return ssd;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Computer{" + "id=" + id + ", manufacturer=" + manufacturer + ", model=" + model + ", procmodel=" + procmodel + ", videocard=" + videocard + ", ram=" + ram + ", soundboard=" + soundboard + ", harddrive=" + harddrive + ", ssd=" + ssd + ", power=" + power + ", price=" + price + ", quantity=" + quantity + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.manufacturer);
        hash = 43 * hash + Objects.hashCode(this.model);
        hash = 43 * hash + Objects.hashCode(this.procmodel);
        hash = 43 * hash + Objects.hashCode(this.videocard);
        hash = 43 * hash + Objects.hashCode(this.ram);
        hash = 43 * hash + Objects.hashCode(this.soundboard);
        hash = 43 * hash + Objects.hashCode(this.harddrive);
        hash = 43 * hash + Objects.hashCode(this.ssd);
        hash = 43 * hash + Objects.hashCode(this.power);
        hash = 43 * hash + this.price;
        hash = 43 * hash + this.quantity;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Computer other = (Computer) obj;
        if (this.price != other.price) {
            return false;
        }
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.manufacturer, other.manufacturer)) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        if (!Objects.equals(this.procmodel, other.procmodel)) {
            return false;
        }
        if (!Objects.equals(this.videocard, other.videocard)) {
            return false;
        }
        if (!Objects.equals(this.ram, other.ram)) {
            return false;
        }
        if (!Objects.equals(this.soundboard, other.soundboard)) {
            return false;
        }
        if (!Objects.equals(this.harddrive, other.harddrive)) {
            return false;
        }
        if (!Objects.equals(this.ssd, other.ssd)) {
            return false;
        }
        if (!Objects.equals(this.power, other.power)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   
    
    
    
    
}

package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

@Entity
public class Medicine {
    private long id;
    private long typeid;
    private String medicineno;
    private String medicinename;
    private String code;
    private double purchaseprice;
    private String medicinesize;
    private long stock;
    private double price;
    private long prescriptionid;
    private long status;
    private Date createdate;
    private Manufacturer manufacturer;
    private long manufacturerid;
    private Prescriptiontype prescriptiontype;

    public Prescriptiontype getPrescriptiontype() {
        return prescriptiontype;
    }

    public void setPrescriptiontype(Prescriptiontype prescriptiontype) {
        this.prescriptiontype = prescriptiontype;
    }

    public long getManufacturerid() {
        return manufacturerid;
    }

    public void setManufacturerid(long manufacturerid) {
        this.manufacturerid = manufacturerid;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TYPEID", nullable = false, precision = 0)
    public long getTypeid() {
        return typeid;
    }

    public void setTypeid(long typeid) {
        this.typeid = typeid;
    }

    @Basic
    @Column(name = "MEDICINENO", nullable = false, length = 20)
    public String getMedicineno() {
        return medicineno;
    }

    public void setMedicineno(String medicineno) {
        this.medicineno = medicineno;
    }

    @Basic
    @Column(name = "MEDICINENAME", nullable = false, length = 50)
    public String getMedicinename() {
        return medicinename;
    }

    public void setMedicinename(String medicinename) {
        this.medicinename = medicinename;
    }

    @Basic
    @Column(name = "CODE", nullable = true, length = 20)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "PURCHASEPRICE", nullable = false, precision = 0)
    public double getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(double purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    @Basic
    @Column(name = "MEDICINESIZE", nullable = false, length = 20)
    public String getMedicinesize() {
        return medicinesize;
    }

    public void setMedicinesize(String medicinesize) {
        this.medicinesize = medicinesize;
    }

    @Basic
    @Column(name = "STOCK", nullable = false, precision = 0)
    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    @Basic
    @Column(name = "PRICE", nullable = false, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "PRESCRIPTIONID", nullable = false, precision = 0)
    public long getPrescriptionid() {
        return prescriptionid;
    }

    public void setPrescriptionid(long prescriptionid) {
        this.prescriptionid = prescriptionid;
    }

    @Basic
    @Column(name = "STATUS", nullable = false, precision = 0)
    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    @Basic
    @Column(name = "CREATEDATE", nullable = true)
    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return id == medicine.id &&
                typeid == medicine.typeid &&
                Double.compare(medicine.purchaseprice, purchaseprice) == 0 &&
                stock == medicine.stock &&
                Double.compare(medicine.price, price) == 0 &&
                prescriptionid == medicine.prescriptionid &&
                status == medicine.status &&
                Objects.equals(medicineno, medicine.medicineno) &&
                Objects.equals(medicinename, medicine.medicinename) &&
                Objects.equals(code, medicine.code) &&
                Objects.equals(medicinesize, medicine.medicinesize) &&
                Objects.equals(createdate, medicine.createdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeid, medicineno, medicinename, code, purchaseprice, medicinesize, stock, price, prescriptionid, status, createdate);
    }
}

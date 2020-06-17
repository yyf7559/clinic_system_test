package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Prescriptiontype {
    private long id;
    private String tname;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TNAME", nullable = false, length = 50)
    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescriptiontype that = (Prescriptiontype) o;
        return id == that.id &&
                Objects.equals(tname, that.tname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tname);
    }
}

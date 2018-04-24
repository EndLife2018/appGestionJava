package pl.dmichalski.reservations.business.entity;


import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "files")
public class File {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_data")
    private Blob fileData;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "added_date")
    private Date addedDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Blob getFileData() {
        return fileData;
    }

    public void setFileData(Blob fileData) {
        this.fileData = fileData;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    @Override
    public String toString() {
        return this.fileName + " - " + this.fileType + " - " + this.addedDate;
    }

    public File(User user, String fileName, Blob fileData, String fileType, Date addedDate) {
        this.user = user;
        this.fileName = fileName;
        this.fileData = fileData;
        this.fileType = fileType;
        this.addedDate = addedDate;
    }

    public File() {
        this.addedDate = Date.valueOf(LocalDate.now());
    }
}

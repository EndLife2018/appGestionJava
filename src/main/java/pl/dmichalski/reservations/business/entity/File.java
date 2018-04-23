package pl.dmichalski.reservations.business.entity;


import javax.persistence.*;
import java.sql.Blob;

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

    @Column(name = "fileName")
    private String fileName;

    @Column(name = "password")
    private Blob fileData;

    @Column(name = "fileType")
    private Blob fileType;

    @Column(name = "addedDate")
    private Blob addedDate;

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

    public Blob getFileType() {
        return fileType;
    }

    public void setFileType(Blob fileType) {
        this.fileType = fileType;
    }

    public Blob getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Blob addedDate) {
        this.addedDate = addedDate;
    }
}

package com.neol.images.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "ms1", nullable = false)
    private String ms1;
    @Column(name = "ms2", nullable = false)
    private String ms2;
    @Column(name = "path", nullable = false)
    private String path;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "year", nullable = false)
    private String year;
    @Column(name = "position", nullable = false)
    private String position;

    @Transient
    private MultipartFile file;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMs1() {
        return ms1;
    }

    public void setMs1(String ms1) {
        this.ms1 = ms1;
    }

    public String getMs2() {
        return ms2;
    }

    public void setMs2(String ms2) {
        this.ms2 = ms2;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile image) {
        this.file = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

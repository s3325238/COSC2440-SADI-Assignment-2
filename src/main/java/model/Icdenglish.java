package model;

import javax.persistence.*;

@Entity
@Table(name = "icdenglish")
public class Icdenglish {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //chapter - group - type - disease
    @Column(name = "chapter_code")
    private String chapter_code;

    @Column(name = "chapter_name")
    private String chapter_name;

    @Column(name = "group_code")
    private String group_code;

    @Column(name = "group_name")
    private String group_name;

    @Column(name = "type_code")
    private String type_code;

    @Column(name = "type_name")
    private String type_name;

    @Column(name = "disease_code")
    private String disease_code;

    @Column(name = "disease_name")
    private String disease_name;

    @ManyToOne
    private Visit visit;

    // Null constructor
    public Icdenglish() {
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChapter_code() {
        return chapter_code;
    }

    public void setChapter_code(String chapter_code) {
        this.chapter_code = chapter_code;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }

    public String getGroup_code() {
        return group_code;
    }

    public void setGroup_code(String group_code) {
        this.group_code = group_code;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getType_code() {
        return type_code;
    }

    public void setType_code(String type_code) {
        this.type_code = type_code;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getDisease_code() {
        return disease_code;
    }

    public void setDisease_code(String disease_code) {
        this.disease_code = disease_code;
    }

    public String getDisease_name() {
        return disease_name;
    }

    public void setDisease_name(String disease_name) {
        this.disease_name = disease_name;
    }
}

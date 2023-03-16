package baitap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MySong {
    @Id
    @Column(columnDefinition = "varchar(10)")
    private String songNo;
    private String songName;
    private String songSinger;
    private String songType;
    private String songLink;

    public MySong() {
    }

    public MySong(String songNo, String songName, String songSinger, String songType, String songLink) {
        this.songNo = songNo;
        this.songName = songName;
        this.songSinger = songSinger;
        this.songType = songType;
        this.songLink = songLink;
    }

    public String getSongNo() {
        return songNo;
    }

    public void setSongNo(String songNo) {
        this.songNo = songNo;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongSinger() {
        return songSinger;
    }

    public void setSongSinger(String songSinger) {
        this.songSinger = songSinger;
    }

    public String getSongType() {
        return songType;
    }

    public void setSongType(String songType) {
        this.songType = songType;
    }

    public String getSongLink() {
        return songLink;
    }

    public void setSongLink(String songLink) {
        this.songLink = songLink;
    }

    @Override
    public String toString() {
        return "MySong{" +
                "songNo='" + songNo + '\'' +
                ", songName='" + songName + '\'' +
                ", songSinger='" + songSinger + '\'' +
                ", songType='" + songType + '\'' +
                ", songLink='" + songLink + '\'' +
                '}';
    }
}

package edu.mum.cs.cs425.studentmgmt.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class Transcript {
    @Id
    private long transcriptId;
    private String degreeTitle;

    public long getTranscriptId() {
        return transcriptId;
    }

    public void setTranscriptId(long transcriptId) {
        this.transcriptId = transcriptId;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    @Override
    public String toString() {
        return "Transcript{" +
                "transcriptId=" + transcriptId +
                ", degreeTitle='" + degreeTitle + '\'' +
                '}';
    }

    public Transcript() {
    }
    public Transcript(long transcriptId, String degreeTitle){
        this.transcriptId = transcriptId;
        this.degreeTitle = degreeTitle;
    }


}
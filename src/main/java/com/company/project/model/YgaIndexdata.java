package com.company.project.model;

import javax.persistence.*;

@Table(name = "yga_indexdata")
public class YgaIndexdata {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "PSR")
    private String psr;

    @Column(name = "EcologicalFactor")
    private String ecologicalfactor;

    @Column(name = "IndexName")
    private String indexname;

    @Column(name = "Citation")
    private String citation;

    @Column(name = "IssueUnit")
    private String issueunit;

    @Column(name = "IssueYear")
    private String issueyear;

    @Column(name = "Comment")
    private String comment;

    /**
     * @return Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return PSR
     */
    public String getPsr() {
        return psr;
    }

    /**
     * @param psr
     */
    public void setPsr(String psr) {
        this.psr = psr;
    }

    /**
     * @return EcologicalFactor
     */
    public String getEcologicalfactor() {
        return ecologicalfactor;
    }

    /**
     * @param ecologicalfactor
     */
    public void setEcologicalfactor(String ecologicalfactor) {
        this.ecologicalfactor = ecologicalfactor;
    }

    /**
     * @return IndexName
     */
    public String getIndexname() {
        return indexname;
    }

    /**
     * @param indexname
     */
    public void setIndexname(String indexname) {
        this.indexname = indexname;
    }

    /**
     * @return Citation
     */
    public String getCitation() {
        return citation;
    }

    /**
     * @param citation
     */
    public void setCitation(String citation) {
        this.citation = citation;
    }

    /**
     * @return IssueUnit
     */
    public String getIssueunit() {
        return issueunit;
    }

    /**
     * @param issueunit
     */
    public void setIssueunit(String issueunit) {
        this.issueunit = issueunit;
    }

    /**
     * @return IssueYear
     */
    public String getIssueyear() {
        return issueyear;
    }

    /**
     * @param issueyear
     */
    public void setIssueyear(String issueyear) {
        this.issueyear = issueyear;
    }

    /**
     * @return Comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
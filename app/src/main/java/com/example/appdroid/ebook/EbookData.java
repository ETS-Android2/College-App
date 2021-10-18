package com.example.appdroid.ebook;

public class EbookData {
    private String pdfTitle, pdfUrl;

    public EbookData() {
    }

    public String getpdfTitle() {
        return pdfTitle;
    }

    public void setpdfTitle(String pdfTitle) {
        this.pdfTitle = pdfTitle;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public EbookData(String name, String pdfUrl) {
        this.pdfTitle = pdfTitle;
        this.pdfUrl = pdfUrl;
    }
}

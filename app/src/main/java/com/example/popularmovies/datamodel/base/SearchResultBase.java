package com.example.popularmovies.datamodel.base;

import com.example.popularmovies.datamodel.Movie;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SearchResultBase<Type> {
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("results")
    @Expose
    protected List<Type> results = new ArrayList<Type>();
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;

    //CONSTRUCTOR
    public SearchResultBase() {}
    public SearchResultBase(List<Type> results) {
        this.results = results;
    }

    //GETTERS & SETTERS
    public List<Type> getResults() {
        return results;
    }
    public void setResults(List<Type> results) {
        this.results = results;
    }
    public Integer getPage() {
        return page;
    }
    public void setPage(Integer page) {
        this.page = page;
    }
    public Integer getTotalResults() {
        return totalResults;
    }
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }
    public Integer getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}

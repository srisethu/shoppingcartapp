/**
 * 
 */
package com.mindtree.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author M1017036
 *
 */
@Entity
@DiscriminatorValue(value ="BOOK")
public class Book extends Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 412285339145837525L;
	@Column
	private String genre;
	@Column
	private String author;
	@Column
	private String publications;
	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the publications
	 */
	public String getPublications() {
		return publications;
	}
	/**
	 * @param publications the publications to set
	 */
	public void setPublications(String publications) {
		this.publications = publications;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((publications == null) ? 0 : publications.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (publications == null) {
			if (other.publications != null)
				return false;
		} else if (!publications.equals(other.publications))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Book [genre=" + genre + ", author=" + author + ", publications=" + publications + "]";
	}
	
	
}

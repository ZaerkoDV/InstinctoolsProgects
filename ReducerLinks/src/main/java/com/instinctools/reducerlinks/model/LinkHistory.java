/**
 * 
 */
package com.instinctools.reducerlinks.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Zaerko_DV
 *
 */
@Entity(name="LinkHistory")
@Table(name="public.link_history")
public class LinkHistory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_link_history")
	private Long idLinkHistory;
	
	@Past
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="last_create")
	private Date lastCreate;
	
	@Column(name="ip_address")
	private String ipAddress;
	
	@OneToOne
	@JoinColumn(name="link_id")
	private Link link;

	public LinkHistory(){
	}
	
	public LinkHistory(Long idLinkHistory,Date lastCreate,String ipAddress, Link link){
		this.idLinkHistory=idLinkHistory;
		this.lastCreate=lastCreate;
		this.ipAddress=ipAddress;
		this.link=link;
	}
	
	/**
	 * @return the idLinkHistory
	 */
	public Long getIdLinkHistory() {
		return idLinkHistory;
	}

	/**
	 * @param idLinkHistory the idLinkHistory to set
	 */
	public void setIdLinkHistory(Long idLinkHistory) {
		this.idLinkHistory = idLinkHistory;
	}

	/**
	 * @return the lastCreate
	 */
	public Date getLastCreate() {
		return lastCreate;
	}

	/**
	 * @param lastCreate the lastCreate to set
	 */
	public void setLastCreate(Date lastCreate) {
		this.lastCreate = lastCreate;
	}

	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * @return the link
	 */
	public Link getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(Link link) {
		this.link = link;
	}
}

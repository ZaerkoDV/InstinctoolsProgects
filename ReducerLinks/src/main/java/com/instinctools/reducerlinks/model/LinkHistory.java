/**
 * @package com.instinctools.reducerlinks.model
 * 
 * Package com.instinctools.reducerlinks.model contain set of class which description
 * basic essence in Reducer Links project.The project is based on MVC architecture.
 * This class is part of model in MVC architecture.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions. 
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * LinkHistory entity describe additional characteristics of link.This entity have composition relations
 * to link entity.Class Link have feature which have link. There are ip address, last create, sum click on
 * link. Link history have relations: one-to-one with link. All communication is one-way.
 * 
 * The class is located in the com.instinctools.reducerlinks.model and describes part of model in MVC architecture.
 * This class includes a description LinkHistory entity. For creating LinkHistory model use Hibernate technology
 * (anatations). Class contains exclusively no-static public methods that return fields of entity. Methods
 * intended to access object fields.Class also contain overload methods toString(), hashCode(), equals().
 *
 * @see Hibernate annotations
 * 
 * @version 1.0 01.10.2015
 * @author Denis Zaerko
 */
@Entity(name="LinkHistory")
@Table(name="public.link_history")
public class LinkHistory {

	/**
	 * Unique identification number of LinkHisroty for entity LinkHisroty(colume: id_link_hisroty type:bigint).
	 * @type Long
	 */	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_genn")
	@SequenceGenerator(name = "seq_genn", sequenceName = "public.id_link_history_seq", initialValue=1, allocationSize=1)
	@Column(name="id_link_history",columnDefinition="integer", nullable = false)
	private Long idLinkHistory;
	
	/**
	 * Time create link is feature of entity link(colume:last_create type:date).
	 * @type Date
	 */
	@Past
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="last_create")
	private Date lastCreate;
	
	/**
	 * Ip address which have user.This is feature of entity link(colume:ip_address type:text).
	 * @type Date
	 */
	@Column(name="ip_address")
	private String ipAddress;
	
	/**
	 * Number of link visitsr.This is feature of entity link(colume:sum_click type:bigint).
	 * @type Date
	 */
	@Column(name="sum_click", columnDefinition="bigint default '0'")
	private Long sumClick;
	
	/**
	 * Link which have history.(colume forigin key:link_id type:bigint).
	 * @type Link
	 */
	@OneToOne
	@JoinColumn(name="link_id")
	private Link link;

	/**
	 * Empty constructor(default) of LinkHistory class.
	 */
	public LinkHistory(){
	}
	
	/**
	 * Overloaded constructor of LinkHistory class.
	 * 
	 * @type Long
	 * @type String
	 * @type Date
	 * 
	 * @param idLinkHistory
	 * @param lastCreate
	 * @param ipAddress
	 * @param sumClick
	 * @param link
	 */
	public LinkHistory(Long idLinkHistory,Date lastCreate,String ipAddress,Long sumClick, Link link){
		this.idLinkHistory=idLinkHistory;
		this.ipAddress=ipAddress;
		this.lastCreate=lastCreate;
		this.sumClick=sumClick;
		this.link=link;
	}
	
	/**
	 * @type Long
	 * @return idLinkHistory attribute of the LinkHistory
	 */
	public Long getIdLinkHistory() {
		return idLinkHistory;
	}

	/**
	 * Method change idLinkHistory attribute of the LinkHistory
	 * 
	 * @type Long
	 * @param idLinkHistory
	 */
	public void setIdLinkHistory(Long idLinkHistory) {
		this.idLinkHistory = idLinkHistory;
	}
	
	/**
	 * @type String 
	 * @return ipAddress attribute of the LinkHistory
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * Method change ipAddress attribute of the LinkHistory
	 * 
	 * @type String
	 * @param ipAddress
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * @type Date 
	 * @return lastCreate attribute of the LinkHistory
	 */
	public Date getLastCreate() {
		return lastCreate;
	}

	/**
	 * Method change lastCreate attribute of the LinkHistory
	 * 
	 * @type Date
	 * @param lastCreate
	 */
	public void setLastCreate(Date lastCreate) {
		this.lastCreate = lastCreate;
	}

	/**
	 * @type Long 
	 * @return sumClick attribute of the LinkHistory
	 */
	public Long getSumClick() {
		return sumClick;
	}

	/**
	 * Method change sumClick attribute of the LinkHistory
	 * 
	 * @type long
	 * @param sumClick
	 */
	public void setSumClick(Long sumClick) {
		this.sumClick = sumClick;
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
	
	/**
	 * Overload basic method hashCode()
	 * 
	 * @type Integer
	 * @return hashCode
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * Overload basic method toString()
	 * 
	 * @type String
	 * @return LinkHistory attribute as string.
	 */
	@Override
	public String toString() {
		if(!this.idLinkHistory.equals(null)){
			return this.idLinkHistory.toString()+" "+ this.ipAddress+" "+this.lastCreate+" "
					+this.sumClick;
		}
		return super.toString();
	}

	/**
	 * (Overload basic method) toString()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param object
	 * @return Boolean true if object belong to LinkHistory or false.
	 */
	public boolean equalsObject(Object obj) {
		boolean result = false;
		if (!obj.equals(null) && getClass().equals(obj.getClass())) {

			final LinkHistory other = (LinkHistory) obj;
			if (this.idLinkHistory.equals(other.idLinkHistory)) {
				result = true;
			}
		}
		return result;
	}
}

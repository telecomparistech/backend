/**
 * 
 */
package com.idlookid.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author quocanh
 *
 */
@Entity
@Table(name = "place")
public class Place {
	@Id
	@Column(name = "id", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "information", nullable = true)
	private String information;

	@Column(name = "icon_path", nullable = true)
	private String iconPath;

	@Column(name = "image_path", nullable = true)
	private String imagePath;

	@NotNull
	@Column(name = "country", nullable = false)
	private String country;

	@Column(name = "city", nullable = true)
	private String city;

	@Size(max = 100)
	@Column(name = "address", nullable = true)
	private String address;

	@Column(name = "street_number")
	private String streetNumber;
	
	@Column(name = "route")
	private String route;
	
	@Column(name = "postal_code")
	private String postalCode;
	
	@NotNull
	@Column(name = "latitude")
	Double latitude;

	@NotNull
	@Column(name = "longitude")
	Double longitude;

	@NotNull
	@Column(name = "community_code", nullable = false)
	String communityCode;

	@NotNull
	@Column(name = "place_type", nullable = false)
	String placeType;

	@Column(name = "reference_url", nullable = true)
	String referenceUrl;

	@Column(name = "idlookid_url", nullable = true)
	String idLookitUrl;

	@Column(name = "created_by_user_id")
	long createdByUserId;

	@Column(name = "created_date")
	Date createdDate;

	@Column(name = "updated_date")
	Date updatedDate;

	@Column(name = "created_from_ip")
	String createdFromIp;

	@Column(name = "email")
	String email;

	@Column(name = "telephone")
	String telephone;

	@Column(name = "openTime")
	String openTime;

	@Column(name = "closeTime")
	String closeTime;

	@Column(name = "organised_by")
	String organisedBy;

	/* PUBLIC METHODS */

	public Long getId() {
		return id;
	}

	@PrePersist
	protected void onCreate() {
		createdDate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updatedDate = new Date();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getCommunityCode() {
		return communityCode;
	}

	public void setCommunityCode(String communityCode) {
		this.communityCode = communityCode;
	}

	public String getPlaceType() {
		return placeType;
	}

	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}

	public String getReferenceUrl() {
		return referenceUrl;
	}

	public void setReferenceUrl(String referenceUrl) {
		this.referenceUrl = referenceUrl;
	}

	public String getIdLookitUrl() {
		return idLookitUrl;
	}

	public void setIdLookitUrl(String idLookitUrl) {
		this.idLookitUrl = idLookitUrl;
	}

	public long getCreatedByUserId() {
		return createdByUserId;
	}

	public void setCreatedByUserId(long createdByUserId) {
		this.createdByUserId = createdByUserId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCreatedFromIp() {
		return createdFromIp;
	}

	public void setCreatedFromIp(String createdFromIp) {
		this.createdFromIp = createdFromIp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public String getOrganisedBy() {
		return organisedBy;
	}

	public void setOrganisedBy(String organisedBy) {
		this.organisedBy = organisedBy;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
}

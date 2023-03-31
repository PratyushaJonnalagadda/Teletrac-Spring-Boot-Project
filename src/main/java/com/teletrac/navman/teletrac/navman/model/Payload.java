package com.teletrac.navman.teletrac.navman.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Payload implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	// @JsonIgnore
	private Long id;

	@NotNull
	@JsonProperty
	private String RecordType;
	@NotNull
	@JsonProperty
	private String DeviceId;
	@NotNull
	@JsonProperty
	private Date EventDateTime;
	@NotNull
	@JsonProperty
	private int FieldA;
	@NotNull
	@JsonProperty
	private String FieldB;
	@NotNull
	@JsonProperty
	private double FieldC;

	public String getDeviceId() {
		return DeviceId;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Payload [id=" + id + ", RecordType=" + RecordType + ", DeviceId=" + DeviceId + ", EventDateTime="
				+ EventDateTime + ", FieldA=" + FieldA + ", FieldB=" + FieldB + ", FieldC=" + FieldC + "]";
	}

}

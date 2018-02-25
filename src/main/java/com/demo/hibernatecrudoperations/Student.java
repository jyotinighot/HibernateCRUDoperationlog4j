package com.demo.hibernatecrudoperations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="Student_DB")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Stud_ID")
	private int studID;
	@Column(name="Stud_Name")
	private String studName;
	@Column(name="Stud_RollNo")
	private int studRollNo;
	@Column(name="Stud_Degree")
	private String studDegree;
	
	Student(int studID, String studName, int studRollNo, String studDegree) {
		super();
		this.studID = studID;
		this.studName = studName;
		this.studRollNo = studRollNo;
		this.studDegree = studDegree;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [studID=" + studID + ", studName=" + studName
				+ ", studRollNo=" + studRollNo + ", studDegree=" + studDegree
				+ "]";
	}

	/**
	 * @return the studID
	 */
	public int getStudID() {
		return studID;
	}

	/**
	 * @param studID the studID to set
	 */
	public void setStudID(int studID) {
		this.studID = studID;
	}

	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public int getStudRollNo() {
		return studRollNo;
	}
	public void setStudRollNo(int studRollNo) {
		this.studRollNo = studRollNo;
	}
	public String getStudDegree() {
		return studDegree;
	}
	public void setStudDegree(String studDegree) {
		this.studDegree = studDegree;
	}

	Student() {
		super();
		// TODO Auto-generated constructor stub
	}
}

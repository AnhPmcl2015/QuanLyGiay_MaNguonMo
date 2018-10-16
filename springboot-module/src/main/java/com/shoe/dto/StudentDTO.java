package com.shoe.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author quochung
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class StudentDTO {
	@Id
	private int id;
	@Column(name = "Fullname")
	private String fullname;
	@Column(name = "Ngaysinh")
	private Date ngaysinh;
	@Column(name = "gioitinh")
	private String gioitinh;
	@Column(name = "khoa")
	private String khoa;
	@OneToMany(mappedBy = "student")
	private Set<SubjectDTO> subjects;
}

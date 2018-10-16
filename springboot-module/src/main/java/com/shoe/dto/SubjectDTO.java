package com.shoe.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subject")
public class SubjectDTO {

	@Id
	private int id_subject;
	@Column(name = "MaMonHoc")
	private String mamonhoc;
	@Column(name = "TenMonHoc")
	private String tenmonhoc;
	@ManyToOne
	@JoinColumn(name = "ID", nullable = false)
	private StudentDTO student;

}

package test.practice.enumWithType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Auther {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// @Enumerated(EnumType.ORDINAL) //To insert number
	@Enumerated(EnumType.STRING) // To Insert Enum as string
	@Column(length = 20)
	private AutherStatus autherStatus;

	@Enumerated(EnumType.ORDINAL)
	@Column(columnDefinition = "smallint")
	private Gender gender;

	public Long getId() {
		return id;
	}

	public AutherStatus getAutherStatus() {
		return autherStatus;
	}

	public void setAutherStatus(AutherStatus autherStatus) {
		this.autherStatus = autherStatus;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}

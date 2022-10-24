package stark.foe.foeapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "greatbuildingreward")
public class GreatBuildingReward {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional=false)
	@JoinColumn(name="age")
	private Age age;
	
	@Column(name="level")
	private int level;
	
	@Column(name="total")
	private int total;
	
	@Column(name="p1")
	private int p1;
	
	@Column(name="p2")
	private int p2;
	
	@Column(name="p3")
	private int p3;
	
	@Column(name="p4")
	private int p4;
	
	@Column(name="p5")
	private int p5;
}

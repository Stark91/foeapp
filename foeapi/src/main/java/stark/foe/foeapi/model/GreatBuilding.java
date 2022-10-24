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
@Table(name = "greatbuilding")
public class GreatBuilding {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="age")
	private Age age;
	
	@Column(name="image")
	private String image;
	
	@Column(name="x")
	private Short x;
	
	@Column(name="y")
	private Short y;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="boost1")
	private GreatBuildingBoost boost1;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="boost2")
	private GreatBuildingBoost boost2;
}

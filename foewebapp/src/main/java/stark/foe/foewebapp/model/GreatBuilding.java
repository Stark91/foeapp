package stark.foe.foewebapp.model;

import lombok.Data;

@Data
public class GreatBuilding {

	private Long id;
	private String name;
	private Age age;
	private String image;
	private Short x;
	private Short y;
	private GreatBuildingBoost boost1;
	private GreatBuildingBoost boost2;
}

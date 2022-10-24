package stark.foe.foewebapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)
@Data
public class Rush extends ArchBoost {

	private int startLevelField;
	private int endLevelField;
	private Owner ownerField;
}

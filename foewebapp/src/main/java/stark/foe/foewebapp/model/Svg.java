package stark.foe.foewebapp.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Svg {

	private Short width;
	private Short height;
	private Short x;
	private Short y;
	private ArrayList<Line> lines;
}

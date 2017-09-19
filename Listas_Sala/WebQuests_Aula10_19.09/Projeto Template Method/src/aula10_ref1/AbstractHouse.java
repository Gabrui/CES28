package aula10_ref1;

public abstract class AbstractHouse {
	public final void buildHouse(){
		buildFoundation();
		buildPillars();
		buildWalls();
		buildWindows();
		System.out.println("House is built.");
	}
	protected void buildFoundation() {
		System.out.println("Building foundation with cement,iron rods and sand");
	}
	abstract protected void buildPillars();
	abstract protected void buildWalls();
	protected void buildWindows() {
		System.out.println("Building Glass Windows");
	}
}

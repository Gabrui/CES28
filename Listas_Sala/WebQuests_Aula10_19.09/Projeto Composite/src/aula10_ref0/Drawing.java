package aula10_ref0;

import java.util.LinkedList;

/**
 * 4.	Dadas a interface Shape e a classe Triangle como exemplos, 
 * implemente as classes faltantes e teste o sistema com a classe
 *  de teste TestComposite Pattern fornecida abaixo; não esqueça 
 *  de incluir o método clear () na classe Drawing, que remove 
 *  todos os seus shapes num dado momento.
 *  OK!	
 */
public class Drawing implements Shape{
	private LinkedList<Shape> shapes = new LinkedList<Shape>();

	public void add(Shape shape) {
		this.shapes.add(shape);
	}

	@Override
	public void draw(String fillColor) {
		for (Shape shape: shapes)
			shape.draw(fillColor);
	}

	public void clear() {
		System.out.println("Clearing all the shapes from drawing");
		shapes.clear();
	}

}

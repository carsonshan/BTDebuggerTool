package btdebuggertool.view;

import org.eclipse.zest.layouts.algorithms.AbstractLayoutAlgorithm;
import org.eclipse.zest.layouts.dataStructures.InternalNode;
import org.eclipse.zest.layouts.dataStructures.InternalRelationship;

public class ShiftDiagramLayoutAlgorithm extends AbstractLayoutAlgorithm {
	private double deltaX, deltaY;

	public ShiftDiagramLayoutAlgorithm(int styles) {
		super(styles);
	}

	@Override
	public void setLayoutArea(double x, double y, double width, double height) {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isValidConfiguration(boolean asynchronous,
			boolean continuous) {
		// TODO Auto-generated method stub
		return true;
	}

	protected void applyLayoutInternal(InternalNode[] entitiesToLayout,
			InternalRelationship[] relationshipsToConsider, double boundsX,
			double boundsY, double boundsWidth, double boundsHeight) {
		for (InternalNode entity : entitiesToLayout) {
			entity.setLocation(entity.getCurrentX() + deltaX,
					entity.getCurrentY() + deltaY);
		}
	}

	@Override
	protected void preLayoutAlgorithm(InternalNode[] entitiesToLayout,
			InternalRelationship[] relationshipsToConsider, double x, double y,
			double width, double height) {
		double minX = Double.MAX_VALUE;
		double minY = Double.MAX_VALUE;
		double maxX = 0;
		
		for (InternalNode entity : entitiesToLayout) {
			minX = Math.min(minX, entity.getCurrentX());
			minY = Math.min(minY, entity.getCurrentY());
			maxX = Math.max(maxX, entity.getCurrentX()+entity.getWidthInLayout());
		}
		double marginX = (width - (maxX - minX))/2;
		deltaX = marginX - minX;
		deltaY = 10 - minY;
	}

	@Override
	protected void postLayoutAlgorithm(InternalNode[] entitiesToLayout,
			InternalRelationship[] relationshipsToConsider) {
		// TODO Auto-generated method stub

	}

	@Override
	protected int getTotalNumberOfLayoutSteps() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int getCurrentLayoutStep() {
		// TODO Auto-generated method stub
		return 0;
	}

}

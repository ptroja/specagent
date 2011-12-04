package multirobotsystem.diagram.edit.parts.custom;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Rectangle;

public class DoubleBorderRoundedRectangle extends RoundedRectangle {
	
	@Override
     public void outlineShape(Graphics graphics) {
        super.outlineShape(graphics);
        
        graphics.pushState();
        
		float lineInset = Math.max(6.0f, getLineWidthFloat()) / 2.0f;
		int inset1 = (int) Math.floor(lineInset);
		int inset2 = (int) Math.ceil(lineInset)+1;

		Rectangle r = Rectangle.SINGLETON.setBounds(getBounds());
		r.x += inset1;
		r.y += inset1;
		r.width -= inset1 + inset2;
		r.height -= inset1 + inset2;

		graphics.drawRoundRectangle(r,
				Math.max(0, corner.width - (int) lineInset),
				Math.max(0, corner.height - (int) lineInset));        
        
        graphics.popState();
    }

}

